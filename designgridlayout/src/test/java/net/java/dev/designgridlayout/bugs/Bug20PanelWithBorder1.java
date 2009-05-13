//  Copyright 2009 Jason Aaron Osgood, Jean-Francois Poilpret
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

package net.java.dev.designgridlayout.bugs;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class Bug20PanelWithBorder1 extends Bug20PanelWithBorder2
{
	public static void main(String[] args)
	{
		Bug20PanelWithBorder1 example = new Bug20PanelWithBorder1();
		example.go(true);
	}

	@Override protected void prePack()
	{
		// Add a border to the container using DeisgnGridLayout
		JComponent panel = (JComponent) frame().getContentPane().getComponent(0);
		panel.setBorder(new TitledBorder("NoBorder"));
	}
}