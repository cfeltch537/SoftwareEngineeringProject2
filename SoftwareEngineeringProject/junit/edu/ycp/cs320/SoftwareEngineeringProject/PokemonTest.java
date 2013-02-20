package edu.ycp.cs320.SoftwareEngineeringProject;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import PokemonClasses.Pokemon;


public class PokemonTest {
	private Pokemon squirtle;
	private Pokemon bulbasaur;
	private Pokemon charmander;
	
	@Before
	public void setUp() throws Exception {

		//squirtle = new Pokemon(10, 12, 15, 6, 3, 17, 49, 15, 32, 84, 71, 31, 7, 154494, "Squirtle");
		//bulbasaur = new Pokemon(4, 15, 48, 13, 21, 84, 41, 8, 64, 32, 14, 64, 1, 197482, "Bulbasaur");
		//charmander = new Pokemon(57, 65, 71, 14, 61, 48, 32, 47, 46, 48, 74, 14, 4, 154789, "Charmander");

	}
	
	@Test
	public void testGetCurHp() throws Exception {
		assertEquals(10, squirtle.getCurHp());
		assertEquals(4, bulbasaur.getCurHp());
		assertEquals(57, charmander.getCurHp());
	}
	
	@Test
	public void testGetBaseHp() throws Exception {
		assertEquals(12, squirtle.getBaseHp());
		assertEquals(15, bulbasaur.getBaseHp());
		assertEquals(65, charmander.getBaseHp());
	}
	
	@Test
	public void testGetCurAtk() throws Exception {
		assertEquals(15, squirtle.getCurAtk());
		assertEquals(48, bulbasaur.getCurAtk());
		assertEquals(71, charmander.getCurAtk());
	}
	
	@Test
	public void testGetBaseAtk() throws Exception {
		assertEquals(6, squirtle.getBaseAtk());
		assertEquals(13, bulbasaur.getBaseAtk());
		assertEquals(14, charmander.getBaseAtk());
	}
	
	@Test
	public void testGetCurDef() throws Exception {
		assertEquals(3, squirtle.getCurDef());
		assertEquals(21, bulbasaur.getCurDef());
		assertEquals(61, charmander.getCurDef());
	}
	
	@Test
	public void testGetBaseDef() throws Exception {
		assertEquals(17, squirtle.getBaseDef());
		assertEquals(84, bulbasaur.getBaseDef());
		assertEquals(48, charmander.getBaseDef());
	}
	
	@Test
	public void testGetCurSpAtk() throws Exception {
		assertEquals(49, squirtle.getCurSpAtk());
		assertEquals(41, bulbasaur.getCurSpAtk());
		assertEquals(32, charmander.getCurSpAtk());
	}
	
	@Test
	public void testGetBaseSpAtk() throws Exception {
		assertEquals(15, squirtle.getBaseSpAtk());
		assertEquals(8, bulbasaur.getBaseSpAtk());
		assertEquals(47, charmander.getBaseSpAtk());
	}
	
	@Test
	public void testGetCurSpDef() throws Exception {
		assertEquals(32, squirtle.getCurSpDef());
		assertEquals(64, bulbasaur.getCurSpDef());
		assertEquals(46, charmander.getCurSpDef());
	}
	
	@Test
	public void testGetBaseSpDef() throws Exception {
		assertEquals(84, squirtle.getBaseSpDef());
		assertEquals(32, bulbasaur.getBaseSpDef());
		assertEquals(48, charmander.getBaseSpDef());
	}
	
	@Test
	public void testGetCurSpd() throws Exception {
		assertEquals(71, squirtle.getCurSpd());
		assertEquals(14, bulbasaur.getCurSpd());
		assertEquals(74, charmander.getCurSpd());
	}
	
	@Test
	public void testGetBaseSpd() throws Exception {
		assertEquals(31, squirtle.getBaseSpd());
		assertEquals(64, bulbasaur.getBaseSpd());
		assertEquals(14, charmander.getBaseSpd());
	}
	
	@Test
	public void testGetPokeNum() throws Exception {
		assertEquals(7, squirtle.getPokeNum());
		assertEquals(1, bulbasaur.getPokeNum());
		assertEquals(4, charmander.getPokeNum());
	}
	
	@Test
	public void testGetIdNum() throws Exception {
		assertEquals(154494, squirtle.getIdNum());
		assertEquals(197482, bulbasaur.getIdNum());
		assertEquals(154789, charmander.getIdNum());
	}
	
	@Test
	public void testGetName() throws Exception {
		assertEquals("Squirtle", squirtle.getName());
		assertEquals("Bulbasaur", bulbasaur.getName());
		assertEquals("Charmander", charmander.getName());
	}
	
	@Test
	public void testSetCurHp() throws Exception {
		squirtle.setCurHp(18);
		assertEquals(18, squirtle.getCurHp());
	}
	
	@Test
	public void testSetBaseHp() throws Exception {
		squirtle.setBaseHp(25);
		assertEquals(25, squirtle.getBaseHp());
	}
	
	@Test
	public void testSetCurAtk() throws Exception {
		squirtle.setCurAtk(84);
		assertEquals(84, squirtle.getCurAtk());
	}
	
	@Test
	public void testSetBaseAtk() throws Exception {
		squirtle.setBaseAtk(26);
		assertEquals(26, squirtle.getBaseAtk());
	}
	
	@Test
	public void testSetCurDef() throws Exception {
		squirtle.setCurDef(51);
		assertEquals(51, squirtle.getCurDef());
	}
	
	@Test
	public void testSetBaseDef() throws Exception {
		squirtle.setBaseDef(68);
		assertEquals(68, squirtle.getBaseDef());
	}
	
	@Test
	public void testSetCurSpAtk() throws Exception {
		squirtle.setCurSpAtk(95);
		assertEquals(95, squirtle.getCurSpAtk());
	}
	
	@Test
	public void testSetBaseSpAtk() throws Exception {
		squirtle.setBaseSpAtk(47);
		assertEquals(47, squirtle.getBaseSpAtk());
	}
	
	@Test
	public void testSetCurSpDef() throws Exception {
		squirtle.setCurSpDef(38);
		assertEquals(38, squirtle.getCurSpDef());
	}
	
	@Test
	public void testSetBaseSpDef() throws Exception {
		squirtle.setBaseSpDef(16);
		assertEquals(16, squirtle.getBaseSpDef());
	}
	
	@Test
	public void testSetCurSpd() throws Exception {
		squirtle.setCurSpd(53);
		assertEquals(53, squirtle.getCurSpd());
	}
	
	@Test
	public void testSetBaseSpd() throws Exception {
		squirtle.setBaseSpd(64);
		assertEquals(64, squirtle.getBaseSpd());
	}
	
	@Test
	public void testSetPokeNum() throws Exception {
		squirtle.setPokeNum(27);
		assertEquals(27, squirtle.getPokeNum());
	}
	
	@Test
	public void testSetIdNum() throws Exception {
		squirtle.setIdNum(60);
		assertEquals(60, squirtle.getIdNum());
	}
	
	@Test
	public void testSetName() throws Exception {
		squirtle.setName("Blastoise");
		assertEquals("Blastoise", squirtle.getName());
	}
}
