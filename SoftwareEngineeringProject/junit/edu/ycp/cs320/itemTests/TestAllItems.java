
package edu.ycp.cs320.itemTests;

import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;

public class TestAllItems {
	
	@Test
	public void setUp()	{
		for(int i = 0; i < ItemName.getLength(); i++)	{
			ItemDatabase.generateItem(ItemName.getItem(i), 0);
		}
	}
}

