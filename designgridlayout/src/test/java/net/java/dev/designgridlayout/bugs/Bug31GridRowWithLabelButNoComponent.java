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

import net.java.dev.designgridlayout.AbstractBaseExample;
import net.java.dev.designgridlayout.DesignGridLayout;

public class Bug31GridRowWithLabelButNoComponent extends AbstractBaseExample
{
	public static void main(String[] args)
	{
		Bug31GridRowWithLabelButNoComponent example = new Bug31GridRowWithLabelButNoComponent();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		layout.row().grid(label("label1")).add(field("field1"));
		layout.row().grid(label("longlabel2"));
		layout.row().grid(label("label3")).add(field("longfield3"));
	}
}