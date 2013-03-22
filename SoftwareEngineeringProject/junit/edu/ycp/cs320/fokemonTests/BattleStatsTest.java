package edu.ycp.cs320.fokemonTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.BattleStats;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;



public class BattleStatsTest {
	private BattleStats squirtle;
	private BattleStats bulbasaur;
	private BattleStats charmander;
	
	@Before
	public void setUp() throws Exception {
		squirtle = new BattleStats(10, 12, 14, 16, 18, 20, 22, Status.FRZ);
		bulbasaur = new BattleStats(24, 26, 28, 30, 32, 34, 36, Status.PSN);
		charmander = new BattleStats(38, 40, 42, 44, 46, 48, 50, Status.BRN);
	}
	
	@Test
	public void testGetCurHp() throws Exception {
		assertEquals(10, squirtle.getCurHp());
		assertEquals(24, bulbasaur.getCurHp());
		assertEquals(38, charmander.getCurHp());
	}
	
	@Test
	public void testGetMaxHp() throws Exception {
		assertEquals(12, squirtle.getMaxHp());
		assertEquals(26, bulbasaur.getMaxHp());
		assertEquals(40, charmander.getMaxHp());
	}
	
	@Test
	public void testGetAtkHp() throws Exception {
		assertEquals(14, squirtle.getAtk());
		assertEquals(28, bulbasaur.getAtk());
		assertEquals(42, charmander.getAtk());
	}
	
	@Test
	public void testGetDef() throws Exception {
		assertEquals(16, squirtle.getDef());
		assertEquals(30, bulbasaur.getDef());
		assertEquals(44, charmander.getDef());
	}
	
	@Test
	public void testGetSpAtk() throws Exception {
		assertEquals(18, squirtle.getSpAtk());
		assertEquals(32, bulbasaur.getSpAtk());
		assertEquals(46, charmander.getSpAtk());
	}
	
	@Test
	public void testGetSpDef() throws Exception {
		assertEquals(20, squirtle.getSpDef());
		assertEquals(34, bulbasaur.getSpDef());
		assertEquals(48, charmander.getSpDef());
	}
	
	@Test
	public void testGetSpd() throws Exception {
		assertEquals(22, squirtle.getSpd());
		assertEquals(36, bulbasaur.getSpd());
		assertEquals(50, charmander.getSpd());
	}
	
	@Test
	public void testSetCurHp() throws Exception {
		squirtle.setCurHp(69);
		assertEquals(69, squirtle.getCurHp());
	}
	
	@Test
	public void testSetMaxHp() throws Exception {
		squirtle.setMaxHp(69);
		assertEquals(69, squirtle.getMaxHp());
	}
	
	@Test
	public void testSetAtk() throws Exception {
		squirtle.setAtk(69);
		assertEquals(69, squirtle.getAtk());
	}
	
	@Test
	public void testSetDef() throws Exception {
		squirtle.setDef(69);
		assertEquals(69, squirtle.getDef());
	}
	
	@Test
	public void testSetSpAtk() throws Exception {
		squirtle.setSpAtk(69);
		assertEquals(69, squirtle.getSpAtk());
	}
	
	@Test
	public void testSetSpDef() throws Exception {
		squirtle.setSpDef(69);
		assertEquals(69, squirtle.getSpDef());
	}
	
	@Test
	public void testSetSpd() throws Exception {
		squirtle.setSpd(69);
		assertEquals(69, squirtle.getSpd());
	}
	
	@Test
	public void testFullHeal() throws Exception {
		bulbasaur.fullHeal();
		assertEquals(26, bulbasaur.getCurHp());
		assertEquals(Status.NRM, bulbasaur.getStatus());
	}
	
	@Test
	public void testPartialHeal() throws Exception {
		charmander.partialHeal(10);
		assertEquals(48, charmander.getCurHp());
	}
	
	@Test
	public void testChangeStatus() throws Exception {
		charmander.changeStatus(Status.NRM);
		assertEquals(Status.NRM, charmander.getStatus());
	}
}
