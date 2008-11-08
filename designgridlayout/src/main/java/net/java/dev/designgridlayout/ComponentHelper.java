//  Copyright 2008 Jason Aaron Osgood, Jean-Francois Poilpret
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

import java.awt.Container;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.SwingConstants;

import org.jdesktop.layout.LayoutStyle;

final class ComponentHelper
{
	private ComponentHelper()
	{
	}
	
	static int maxValues(Iterable<JComponent> components, IExtractor extractor)
	{
		int max = 0;
		for (JComponent component: components)
		{
			max = Math.max(max, extractor.value(component));
		}
		return max;
	}
	
	static int sumValues(Iterable<JComponent> components, IExtractor extractor)
	{
		int sum = 0;
		for (JComponent component: components)
		{
			sum += extractor.value(component);
		}
		return sum;
	}
	
	static int hgap(List<JComponent> components, Container parent)
	{
		LayoutStyle layoutStyle = LayoutStyle.getSharedInstance();
		int hgap = 0;
		int size = components.size() - 1;
		for (int nth = 0; nth < size; nth++)
		{
			JComponent left = components.get(nth);
			JComponent right = components.get(nth + 1);
			int gap = layoutStyle.getPreferredGap(
				left, right, LayoutStyle.RELATED, SwingConstants.EAST, parent);
			hgap = Math.max(hgap, gap);
		}
		return hgap;
	}
	
	static boolean isFixedHeight(
		HeightGrowPolicy policy, Iterable<JComponent> components)
	{
		for (JComponent component: components)
		{
			if (policy.canGrowHeight(component))
			{
				return false;
			}
		}
		return true;
	}
}
