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

import javax.swing.JComponent;

// Used for all components added to a non-grid row
class ComponentizerItem extends BasicItem
{
	// Used to create an item holding a real component (that may span several
	// rows below or not)
	public ComponentizerItem(JComponent component, boolean variableWidth)
	{
		super(component);
		_variableWidth = variableWidth;
	}

	public boolean isVariableWidth()
	{
		return _variableWidth;
	}
	
	final private boolean _variableWidth;
}
