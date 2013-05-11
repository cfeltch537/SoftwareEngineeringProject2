package edu.ycp.cs320.moveTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.EffectType;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;

public class MoveTest {
	private Move moveA;
	private Move moveB;
	private Move moveC;
	private ArrayList<Effect> testEffectList = new ArrayList<Effect>();
	private Effect testEffect;

	@Before
	public void setUp() throws Exception {
		testEffect = new Effect(EffectType.POISON, 0, 0, "");
		testEffectList.add(testEffect);
		// moveA=new Move(0, 0, testEffectList, 0, null, 0, null, false);
		moveA = MoveDataBase.generateMove(MoveName.Tackle);
		moveB = MoveDataBase.generateMove(MoveName.Bite);
		moveC = MoveDataBase.generateMove(MoveName.Ember);
	}

	@Test
	public void testGetCurPP() {
		assertEquals(35, moveA.getCurPP());
		assertEquals(25, moveB.getCurPP());
		assertEquals(25, moveC.getCurPP());
	}

	@Test
	public void testGetMaxPP() {
		assertEquals(35, moveA.getMaxPP());
		assertEquals(25, moveB.getMaxPP());
		assertEquals(25, moveC.getMaxPP());
	}

	@Test
	public void testGetEffect() {
		assertEquals(EffectType.NONE, moveA.getEffect().get(0).getEffectIndex());
		assertEquals(EffectType.NONE, moveB.getEffect().get(0).getEffectIndex());
		assertEquals(EffectType.BURN, moveC.getEffect().get(0).getEffectIndex());
	}

	@Test
	public void testGetAccuracy() {
		assertEquals(100, moveA.getAccuracy());
		assertEquals(100, moveB.getAccuracy());
		assertEquals(100, moveC.getAccuracy());
	}

	@Test
	public void testGetMoveName() {
		assertEquals(MoveName.Tackle, moveA.getMoveName());
		assertEquals(MoveName.Bite, moveB.getMoveName());
		assertEquals(MoveName.Ember, moveC.getMoveName());
	}

	@Test
	public void testGetDamage() {
		assertEquals(50, moveA.getDamage());
		assertEquals(60, moveB.getDamage());
		assertEquals(40, moveC.getDamage());
	}

	@Test
	public void testGetPokeType() {
		assertEquals(PokeType.NORMAL, moveA.getPokeType());
		assertEquals(PokeType.DARK, moveB.getPokeType());
		assertEquals(PokeType.FIRE, moveC.getPokeType());
	}

	@Test
	public void testGetPhysical() {
		assertTrue(moveA.getPhysical());
		assertTrue(moveB.getPhysical());
		assertFalse(moveC.getPhysical());
	}

	@Test
	public void testSetCurPP() {
		moveA.setCurPP(10);
		assertEquals(10, moveA.getCurPP());
	}

	@Test
	public void testSetMaxPP() {
		moveA.setMaxPP(100);
		assertEquals(100, moveA.getMaxPP());
	}

	@Test
	public void testSetEffect() {
		moveA.setEffect(testEffectList);
		assertEquals(EffectType.POISON, moveA.getEffect().get(0)
				.getEffectIndex());
	}

	@Test
	public void testSetAccuracy() {
		moveA.setAccuracy(69);
		assertEquals(69, moveA.getAccuracy());
	}

	@Test
	public void testSetMoveName() {
		moveA.setMoveName(MoveName.Spore);
		assertEquals(MoveName.Spore, moveA.getMoveName());
	}

	@Test
	public void testSetDamage() {
		moveA.setDamage(54);
		assertEquals(54, moveA.getDamage());
	}

	@Test
	public void testSetPokeType() {
		moveA.setPokeType(PokeType.FLYING);
		assertEquals(PokeType.FLYING, moveA.getPokeType());
	}

	@Test
	public void testSetPhysical() {
		moveA.setPhysical(true);
		assertTrue(moveA.getPhysical());
	}
}
