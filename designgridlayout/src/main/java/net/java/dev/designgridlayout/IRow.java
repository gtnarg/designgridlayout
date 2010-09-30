//  Copyright 2005-2010 Jason Aaron Osgood, Jean-Francois Poilpret
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

/**
 * Any row created by {@link DesignGridLayout} implements this minimal
 * interface. Through this interface you can add components to the row.
 * <p/>
 * Subsequent calls to methods that add components result in adding components
 * left to right, i.e. the last added component is positioned to the right of
 * the previously last added component.
 * <p/>
 * Note that {@code DesignGridLayout} methods will return more specific
 * interfaces (that extend {@code IRow}).
 * 
 * @author Jean-Francois Poilpret
 */
public interface IRow
{
	/**
	 * Adds components to this row; each component has its own "column" in the
	 * row. Components are added left to right, in the same order as they appear
	 * in the arguments list.
	 * 
	 * @param children components to add to this row
	 * @return {@code this} row (to allow chaining other methods for the current 
	 * row)
	 */
	public abstract IRow add(JComponent... children);

	/**
	 * Adds components to this row; all components are "assembled" as one
	 * global component and use only one "column" in the row.
	 * <p/>
	 * Note that the width of each individual component will never grow bigger
	 * than its preferred width.
	 * 
	 * @param children components to assemble and add to this row
	 * @return {@code this} row (to allow chaining other methods for the current 
	 * row)
	 */
	public abstract IRow addMulti(JComponent... children);
}
