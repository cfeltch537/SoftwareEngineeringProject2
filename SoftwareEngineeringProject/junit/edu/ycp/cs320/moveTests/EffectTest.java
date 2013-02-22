package edu.ycp.cs320.moveTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MoveClasses.Effect;
import MoveClasses.EffectType;

public class EffectTest {
	private Effect sleep;
	private Effect ko;
	private Effect recoil;
	
	@Before
	public void setUp() {
		sleep = new Effect(EffectType.SLEEP, 54, 27, "You went to sleep");
		ko = new Effect(EffectType.KO, 67, 19, "You were knocked out");
		recoil = new Effect(EffectType.RECOIL, 69, 86, "You were recoiled");
	}
	
	@Test
	public void testGetEffectIndex() {
		assertEquals(EffectType.SLEEP, sleep.getEffectIndex());
		assertEquals(EffectType.KO, ko.getEffectIndex());
		assertEquals(EffectType.RECOIL, recoil.getEffectIndex());
	}
	
	@Test
	public void testGetEffectChance() {
		assertEquals(54, sleep.getEffectChance());
		assertEquals(67, ko.getEffectChance());
		assertEquals(69, recoil.getEffectChance());
	}
	
	@Test
	public void testGetMagnitude() {
		assertEquals(27, sleep.getMagnitude());
		assertEquals(19, ko.getMagnitude());
		assertEquals(86, recoil.getMagnitude());
	}
	
	@Test
	public void testGetEffectText() {
		assertEquals("You went to sleep", sleep.getEffectText());
		assertEquals("You were knocked out", ko.getEffectText());
		assertEquals("You were recoiled", recoil.getEffectText());
	}
	
	@Test
	public void testSetEffectIndex() {
		sleep.setEffectIndex(EffectType.CHARGE);
		assertEquals(EffectType.CHARGE, sleep.getEffectIndex());
	}
	
	@Test
	public void testSetEffectChance() {
		sleep.setEffectChance(88);
		assertEquals(88, sleep.getEffectChance());
	}
	
	@Test
	public void testSetMagnitude() {
		sleep.setMagnitude(56);
		assertEquals(56, sleep.getMagnitude());
	}
	
	@Test
	public void testSetEffectText() {
		sleep.setEffectText("NIGHT NIGHT");
		assertEquals("NIGHT NIGHT", sleep.getEffectText());
	}
}
