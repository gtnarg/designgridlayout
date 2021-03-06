//  Copyright 2005-2013 Jason Aaron Osgood, Jean-Francois Poilpret
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

public class RowSpan3TwoListsCustomWeights extends AbstractDesignGridExample
{
	public static void main(String[] args)
	{
		RowSpan3TwoListsCustomWeights example = new RowSpan3TwoListsCustomWeights();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		layout.row().grid(label("lbl1")).add(field("field1")).add(list());
		layout.row(0.0).grid(label("lbl3")).add(field("field3")).spanRow();
		layout.row().grid(label("lbl4")).add(field("field4"));
		
		layout.row().grid(label("lbl5")).add(list(), 2).add(field("field6"));
		layout.row().grid().spanRow().add(field("field7"));

		layout.row().grid(label("lbl8")).empty().add(field("field8"));
		layout.row().grid(label("lbl9")).spanRow().add(field("field9"));

		layout.row().center().add(button());
	}
}
