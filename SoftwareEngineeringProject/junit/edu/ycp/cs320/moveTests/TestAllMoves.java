
package edu.ycp.cs320.moveTests;

import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;

public class TestAllMoves {
	
	@Test
	public void setUp()	{
		for(int i = 0; i < MoveName.getLength(); i++)	{
			MoveDataBase.generateMove(MoveName.getMove(i));
		}
	}
}

