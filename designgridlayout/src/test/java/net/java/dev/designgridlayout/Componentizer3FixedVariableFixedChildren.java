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

import net.java.dev.designgridlayout.Componentizer.Builder;

public class Componentizer3FixedVariableFixedChildren extends AbstractComponentizerExample
{
	public static void main(String[] args)
	{
		Componentizer3FixedVariableFixedChildren example = 
			new Componentizer3FixedVariableFixedChildren();
		example.go(true);
	}
	
	@Override protected void build(Builder builder)
	{
		//CSOFF: LineLength
		builder.fixedPref(label("Total:")).prefAndMore(field("999,999.99")).fixedPref(label("USD"));
		//CSON: LineLength
	}
}
