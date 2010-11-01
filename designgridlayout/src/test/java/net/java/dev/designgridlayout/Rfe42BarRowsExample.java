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

public class Rfe42BarRowsExample extends AbstractBaseExample
{
	public static void main(String[] args)
	{
		Rfe42BarRowsExample example = new Rfe42BarRowsExample();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		layout.row().bar().addLeft(button("Left"));
		layout.row().bar().addCenter(button("Center"));
		layout.row().bar().addRight(button("Right"));
		layout.row().bar().addLeft(button("Left")).addCenter(button("Center"));
		layout.row().bar().addLeft(button("Left")).addRight(button("Right"));
		layout.row().bar().addCenter(button("Center")).addRight(button("Right"));
		layout.row().bar().addLeft(button("Left")).addCenter(button("Center")).addRight(button("Right"));
	}

	@Override protected void init(DesignGridLayout layout)
	{
		// This method is overridden to ensure consistent width is not disabled
	}
}