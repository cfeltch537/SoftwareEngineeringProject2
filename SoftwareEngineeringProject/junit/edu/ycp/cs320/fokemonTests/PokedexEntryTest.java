package edu.ycp.cs320.fokemonTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.Player.PokedexEntry;

public class PokedexEntryTest {
	private PokedexEntry dugtrio;
	private PokedexEntry onix;
	private PokedexEntry omanyte;
	
	@Before
	public void setUp() {
		dugtrio = new PokedexEntry(10, null, null, "GroundType", "Dugtrio", 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36);
		onix = new PokedexEntry(38, null, null, "RockType", "Onix", 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64);
		omanyte = new PokedexEntry(66, null, null, "RockType", "Omanyte", 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92);
	}
	
	@Test
	public void testGetId() {
		assertEquals(10, dugtrio.getId());
		assertEquals(38, onix.getId());
		assertEquals(66, omanyte.getId());
	}
	
	@Test
	public void testGetDetails() {
		assertEquals("GroundType", dugtrio.getDetails());
		assertEquals("RockType", onix.getDetails());
		assertEquals("RockType", omanyte.getDetails());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Dugtrio", dugtrio.getName());
		assertEquals("Onix", onix.getName());
		assertEquals("Omanyte", omanyte.getName());
	}
	
	@Test
	public void testGetType() {
		assertEquals(12, dugtrio.getType());
		assertEquals(40, onix.getType());
		assertEquals(68, omanyte.getType());
	}
	
	@Test
	public void testGetBaseHP() {
		assertEquals(14, dugtrio.getBaseHP());
		assertEquals(42, onix.getBaseHP());
		assertEquals(70, omanyte.getBaseHP());
	}
	
	@Test
	public void testGetBaseAtk() {
		assertEquals(16, dugtrio.getBaseAtk());
		assertEquals(44, onix.getBaseAtk());
		assertEquals(72, omanyte.getBaseAtk());		
	}
	
	@Test
	public void testGetBaseDef() {
		assertEquals(18, dugtrio.getBaseDef());
		assertEquals(46, onix.getBaseDef());
		assertEquals(74, omanyte.getBaseDef());		
	}
	
	@Test
	public void testGetBaseSpAtk() {
		assertEquals(20, dugtrio.getBaseSpAtk());
		assertEquals(48, onix.getBaseSpAtk());
		assertEquals(76, omanyte.getBaseSpAtk());		
	}
	
	@Test
	public void testGetBaseSpDef() {
		assertEquals(22, dugtrio.getBaseSpDef());
		assertEquals(50, onix.getBaseSpDef());
		assertEquals(78, omanyte.getBaseSpDef());		
	}
	
	@Test
	public void testGetBaseSpd() {
		assertEquals(24, dugtrio.getBaseSpd());
		assertEquals(52, onix.getBaseSpd());
		assertEquals(80, omanyte.getBaseSpd());		
	}
	
	@Test
	public void testGetIncHP() {
		assertEquals(26, dugtrio.getIncHP());
		assertEquals(54, onix.getIncHP());
		assertEquals(82, omanyte.getIncHP());
	}
	
	@Test
	public void testGetIncAtk() {
		assertEquals(28, dugtrio.getIncAtk());
		assertEquals(56, onix.getIncAtk());
		assertEquals(84, omanyte.getIncAtk());		
	}
	
	@Test
	public void testGetIncDef() {
		assertEquals(30, dugtrio.getIncDef());
		assertEquals(58, onix.getIncDef());
		assertEquals(86, omanyte.getIncDef());		
	}
	
	@Test
	public void testGetIncSpAtk() {
		assertEquals(32, dugtrio.getIncSpAtk());
		assertEquals(60, onix.getIncSpAtk());
		assertEquals(88, omanyte.getIncSpAtk());		
	}
	
	@Test
	public void testGetIncSpDef() {
		assertEquals(34, dugtrio.getIncSpDef());
		assertEquals(62, onix.getIncSpDef());
		assertEquals(90, omanyte.getIncSpDef());		
	}
	
	@Test
	public void testGetIncSpd() {
		assertEquals(36, dugtrio.getIncSpd());
		assertEquals(64, onix.getIncSpd());
		assertEquals(92, omanyte.getIncSpd());		
	}
	
	@Test
	public void testSetId() {
		dugtrio.setId(100);
		assertEquals(100, dugtrio.getId());
	}
	
	@Test
	public void testSetDetails() {
		dugtrio.setDetails("I have brothers");
		assertEquals("I have brothers", dugtrio.getDetails());
	}
	
	@Test
	public void testSetName() {
		dugtrio.setName("Dirty Mike");
		assertEquals("Dirty Mike", dugtrio.getName());
	}
	
	@Test
	public void testSetType() {
		dugtrio.setType(15);
		assertEquals(15, dugtrio.getType());
	}
	
	@Test
	public void testSetBaseHP() {
		dugtrio.setBaseHP(2);
		assertEquals(2, dugtrio.getBaseHP());
	}
	
	@Test
	public void testSetBaseAtk() {
		dugtrio.setBaseAtk(84);
		assertEquals(84, dugtrio.getBaseAtk());
	}
	
	@Test
	public void testSetBaseDef() {
		dugtrio.setBaseDef(49);
		assertEquals(49, dugtrio.getBaseDef());
	}
	
	@Test
	public void testSetBaseSpAtk() {
		dugtrio.setBaseSpAtk(37);
		assertEquals(37, dugtrio.getBaseSpAtk());
	}
	
	@Test
	public void testSetBaseSpDef() {
		dugtrio.setBaseSpDef(64);
		assertEquals(64, dugtrio.getBaseSpDef());
	}
	
	@Test
	public void testSetBaseSpd() {
		dugtrio.setBaseSpd(75);
		assertEquals(75, dugtrio.getBaseSpd());		
	}
	
	@Test
	public void testSetIncHP() {
		dugtrio.setIncHP(57);
		assertEquals(57, dugtrio.getIncHP());
	}
	
	@Test
	public void testSetIncAtk() {
		dugtrio.setIncAtk(10002);
		assertEquals(10002, dugtrio.getIncAtk());
	}
	
	@Test
	public void testSetIncDef() {
		dugtrio.setIncDef(3);
		assertEquals(3, dugtrio.getIncDef());
	}
	
	@Test
	public void testSetIncSpAtk() {
		dugtrio.setIncSpAtk(29);
		assertEquals(29, dugtrio.getIncSpAtk());		
	}
	
	@Test
	public void testSetIncSpDef() {
		dugtrio.setIncSpDef(55);
		assertEquals(55, dugtrio.getIncSpDef());
	}
	
	@Test
	public void testSetIncSpd() {
		dugtrio.setIncSpd(69);
		assertEquals(69, dugtrio.getIncSpd());
	}
}
