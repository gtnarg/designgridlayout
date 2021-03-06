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

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Basics9RealWorldExample3 extends AbstractDesignGridExample
{
	public static void main(String[] args)
	{
		Basics9RealWorldExample3 example = new Basics9RealWorldExample3();
		example.go(true);
	}

	// CSOFF: MagicNumber
	@Override public void build(DesignGridLayout layout)
	{
		addGroup(layout, projectLabel);
		layout.row().grid(idLabel).indent().add(id).empty(2);
		layout.emptyRow();

		addGroup(layout, mfgLabel);
		layout.row().grid(companyLabel).indent().add(company);
		layout.row().grid(contactLabel).indent().add(contact);
		layout.row().grid(orderLabel).indent().add(order).empty(2);
		layout.emptyRow();

		addGroup(layout, inspectorLabel);
		layout.row().grid(nameLabel).indent().add(name);
		layout.row().grid(referenceLabel).indent().add(reference).empty(2);
		layout.row().grid(statusLabel).indent().add(status).empty(2);
		layout.emptyRow();

		addGroup(layout, shipLabel);
		layout.row().grid(shipyardLabel).indent().add(shipyard);
		layout.row().grid(registerNoLabel).indent().add(registerNo).empty(2);
		layout.row().grid(hullNumsLabel).indent().add(hullNums).empty(2);
		layout.row().grid(projectTypeLabel).indent().add(projectType).empty(2);
	}
	// CSON: MagicNumber
	
	static private void addGroup(DesignGridLayout layout, JLabel group)
	{
		group.setForeground(Color.BLUE);
		layout.row().left().add(group).add(new JSeparator()).fill().withOwnRowWidth();
	}
	
	@Override public String name()
	{
		return "Skeleton";
	}

	// CSOFF: MemberName
	final private JLabel projectLabel = new JLabel("Project");
	final private JLabel idLabel = new JLabel("Identifier");
	final private JTextField id = new JTextField("Sample Project");
	final private JLabel mfgLabel = new JLabel("Manufacturer");
	final private JLabel companyLabel = new JLabel("Company");
	final private JTextField company = new JTextField("Hapag Lloyd");
	final private JLabel contactLabel = new JLabel("Contact");
	final private JTextField contact = new JTextField("Buzz Lightyear");
	final private JLabel orderLabel = new JLabel("Order No");
	final private JTextField order = new JTextField("583-992/20002");
	final private JLabel inspectorLabel = new JLabel("Inspector");
	final private JLabel nameLabel = new JLabel("Name");
	final private JTextField name = new JTextField("Clouseau");
	final private JLabel referenceLabel = new JLabel("Reference No");
	final private JTextField reference = new JTextField("32098");
	final private JLabel statusLabel = new JLabel("Status");
	final private JComboBox status = new JComboBox(new String[]{"In Progress", "Overdue"});
	final private JLabel shipLabel = new JLabel("Ship");
	final private JLabel shipyardLabel = new JLabel("Shipyard");
	final private JTextField shipyard = new JTextField("HDW");
	final private JLabel registerNoLabel = new JLabel("Register No");
	final private JTextField registerNo = new JTextField("22067");
	final private JLabel hullNumsLabel = new JLabel("Hull Numbers");
	final private JTextField hullNums = new JTextField("472");
	final private JLabel projectTypeLabel = new JLabel("Project Type");
	final private JComboBox projectType = new JComboBox(
		new String[]{"New Building", "Overhaul"});
	// CSON: MemberName
}
