package edu.ycp.cs320.SoftwareEngineeringProject;

import junit.framework.TestCase;
import edu.ycp.cs320.fokemon.EffectDataBase;
import edu.ycp.cs320.fokemon.Pokemon;

public class EffectDataBaseTest extends TestCase {
	// TODO - define test fixture objects
	private Pokemon A;
	private Pokemon B;
	private int EffectIndex;
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO - create test fixture objects
		A=new Pokemon(1, 1, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, "A");
		B=new Pokemon(1,1, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, EffectIndex, "B");
		EffectIndex=1;
		A.setBaseAtk(12);
	}
	
	// TODO - add test methods
	public void testMoveEffect() throws Exception {
		//EffectDataBase.moveEffect(A, B, EffectIndex);
		assertEquals(10,A.getBaseAtk());
	}
}
