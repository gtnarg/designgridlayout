//  Copyright 2005-2011 Jason Aaron Osgood, Jean-Francois Poilpret
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package net.java.dev.designgridlayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.java.dev.designgridlayout.Componentizer.Builder;

final class ComponentizerLayout implements LayoutManager, Builder
{
	ComponentizerLayout(JComponent parent)
	{
		_parent = parent;
		_parent.setLayout(this);
		_orientation = new OrientationPolicy(_parent);
	}
	
	@Override public Builder withSmartVerticalResize()
	{
		_heightTester = _defaultHeightTester;
		return this;
	}

	@Override public Builder withoutSmartVerticalResize()
	{
		_heightTester = new UnitHeightGrowPolicy(_defaultHeightTester);
		return this;
	}

	@Override public Builder addFixed(JComponent... children)
	{
		add(false, children);
		return this;
	}

	@Override public Builder addVariable(JComponent... children)
	{
		add(true, children);
		_numVariableWidthComponents += children.length;
		return this;
	}
	
	protected void add(boolean variableWidth, JComponent[] children)
	{
		for (JComponent child: children)
		{
			_children.add(new ComponentizerItem(child, variableWidth));
			_parent.add(child);
		}
	}

	@Override public JComponent component()
	{
		return _parent;
	}

	public int getBaseline()
	{
		computeAll();
		return _baseline;
	}
	
	@Override public void layoutContainer(Container parent)
	{
		checkParent(parent);
		
		synchronized(parent.getTreeLock())
		{
			computeAll();

			// Check layout orientation
			boolean rtl = _orientation.isRightToLeft();

			int parentWidth = parent.getSize().width;
			//TODO should we use min width instead of pref width here?
			// Never layout components smaller than the minimum size
			parentWidth = Math.max(parentWidth, _prefWidth);
			int availableWidth = parentWidth - _gap;
			int prefWidth = _prefWidth - _gap;
			
			// 2 situations:
			// - if available width = pref width, use pref width of all components
			// - if available width > pref width, increase size only of variable components
			int extra = 0;
			int fudge = 0;
			if (availableWidth > prefWidth && _numVariableWidthComponents > 0)
			{
				// Calculate extra width for each variable width component
				extra = (availableWidth - prefWidth) / _numVariableWidthComponents;
				// Fudge is assigned to the first variable width components (1 pixel per component)
				fudge = (availableWidth - prefWidth) % _numVariableWidthComponents;
			}

			// Perform actual layout
			LayoutHelper helper = new LayoutHelper(_heightTester, parentWidth, rtl);
			helper.setRowAvailableHeight(_parent.getHeight());
			helper.setY(0);
			int nth = 0;
			int x = 0;
			for (ComponentizerItem child: _children)
			{
				int width = child.preferredWidth();
				if (child.isVariableWidth())
				{
					if (extra > 0)
					{
						width += extra;
					}
					if (fudge > 0)
					{
						width++;
						fudge--;
					}
				}
				helper.setSizeLocation(child.component(), x, width, _height, _baseline);
				x += width + _gaps[nth];
				nth++;
			}
		}
	}

	@Override public Dimension minimumLayoutSize(Container parent)
	{
		initSizeCalculation(parent);
		return new Dimension(_prefWidth, _height);
//		return new Dimension(_minWidth, _height);
	}

	@Override public Dimension preferredLayoutSize(Container parent)
	{
		initSizeCalculation(parent);
		return new Dimension(_prefWidth, _height);
	}
	
	private void initSizeCalculation(Container parent)
	{
		checkParent(parent);
		computeAll();
	}

	@Override public void addLayoutComponent(String name, Component comp)
	{
		throw new IllegalArgumentException("do not use this method");
	}

	@Override public void removeLayoutComponent(Component comp)
	{
		throw new IllegalArgumentException("do not use this method");
	}
	
	private void computeAll()
	{
		if (!_inited)
		{
			_baseline = ComponentHelper.maxValues(_children, BaselineExtractor.INSTANCE);
			_minWidth = ComponentHelper.sumValues(_children, MinWidthExtractor.INSTANCE);
			_prefWidth = ComponentHelper.sumValues(_children, PrefWidthExtractor.INSTANCE);
			_height = ComponentHelper.maxValues(_children, PrefHeightExtractor.INSTANCE);

			ComponentGapsHelper helper = ComponentGapsHelper.instance();
			_gaps = new int[_children.size()];
			for (int nth = 0; nth < _children.size() - 1; nth++)
			{
				JComponent left = _children.get(nth).component();
				JComponent right = _children.get(nth + 1).component();
				int gap = helper.getHorizontalGap(
					left, right, ComponentPlacement.RELATED, _parent);
				_gaps[nth] = gap;
				_gap += gap;
			}
			_minWidth += _gap;
			_prefWidth += _gap;
			//FIXME potential IndexOutOfBounds when no component at all (rare but could happen)
			_gaps[_children.size() - 1] = 0;

			_inited = true;
		}
	}
	
	private void checkParent(Container parent)
	{
		if (parent != _parent)
		{
			throw new IllegalArgumentException(
				"must use HorizontalLayout instance with original parent container");
		}
	}

	static private HeightGrowPolicy _defaultHeightTester = new DefaultGrowPolicy();

	private final JComponent _parent;
	private final List<ComponentizerItem> _children = new ArrayList<ComponentizerItem>();
	private HeightGrowPolicy _heightTester = _defaultHeightTester;
	private final OrientationPolicy _orientation;
	private boolean _inited = false;
	private int _baseline = 0;
	private int _height = 0;
	private int _minWidth = 0;
	private int _prefWidth = 0;
	private int[] _gaps = null;
	private int _gap = 0;
	private int _numVariableWidthComponents = 0;
}
