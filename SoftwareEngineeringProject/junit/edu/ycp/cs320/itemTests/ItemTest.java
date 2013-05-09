package edu.ycp.cs320.itemTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.Item;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.EffectType;

public class ItemTest {
	private Item ultraBall;
	private Item freshWater;
	private Item maxRevive;
	private ArrayList<Effect> testList = new ArrayList<Effect>();
	private Effect testEffect;
	private static final double DELTA = 0.001;

	@Before
	public void setUp()	{
		testEffect = new Effect(EffectType.FREEZE, 0, 0, "");
		testList.add(testEffect);
		ultraBall = ItemDatabase.generateItem(ItemName.ULTRA_BALL, 2);
		freshWater = ItemDatabase.generateItem(ItemName.FRESH_WATER, 100);
		maxRevive = ItemDatabase.generateItem(ItemName.MAX_REVIVE, 40);
	}

	@Test
	public void testGetSellPrice()	{
		assertEquals(600, ultraBall.getSellPrice());
		assertEquals(100, freshWater.getSellPrice());
		assertEquals(2800, maxRevive.getSellPrice());
	}

	@Test
	public void testGetBuyPrice()	{
		assertEquals(1200, ultraBall.getBuyPrice());
		assertEquals(200, freshWater.getBuyPrice());
		assertEquals(0, maxRevive.getBuyPrice());
	}

	@Test
	public void testIsUseInBattle()	{
		assertTrue(ultraBall.isUseInBattle());
		assertTrue(freshWater.isUseInBattle());
		assertTrue(maxRevive.isUseInBattle());
	}

	@Test
	public void testIsUseOutOfBattle()	{
		assertFalse(ultraBall.isUseOutOfBattle());
		assertTrue(freshWater.isUseOutOfBattle());
		assertTrue(maxRevive.isUseOutOfBattle());
	}

	@Test
	public void testGetItemName()	{
		assertEquals("Ultra Ball", ultraBall.getItemName());
		assertEquals("Fresh Water", freshWater.getItemName());
		assertEquals("Max Revive", maxRevive.getItemName());
	}

	@Test
	public void testGetCatchRate()	{
		assertEquals(2, ultraBall.getCatchRate(), DELTA);
		assertEquals(0, freshWater.getCatchRate(), DELTA);
		assertEquals(0, maxRevive.getCatchRate(), DELTA);
	}

	@Test
	public void testGetQuantity()	{
		assertEquals(2, ultraBall.getQuantity());
		assertEquals(100, freshWater.getQuantity());
		assertEquals(40, maxRevive.getQuantity());
	}

	@Test
	public void testGetEffect()	{
		assertEquals(EffectType.RECOVERCONST, freshWater.getItemEffect().get(0).getEffectIndex());
		assertEquals(EffectType.RECOVERFULL, maxRevive.getItemEffect().get(0).getEffectIndex());
	}

	@Test
	public void testSetSellPrice()	{
		freshWater.setSellPrice(15164);
		assertEquals(15164, freshWater.getSellPrice());
		ultraBall.setSellPrice(8868);
		assertEquals(8868, ultraBall.getSellPrice());
	}

	@Test
	public void testSetBuyPrice()	{
		freshWater.setBuyPrice(69);
		assertEquals(69, freshWater.getBuyPrice());
		ultraBall.setBuyPrice(9969);
		assertEquals(9969, ultraBall.getBuyPrice());
	}

	@Test
	public void testSetUseInBattle()	{
		freshWater.setUseInBattle(false);
		assertFalse(freshWater.isUseInBattle());
		ultraBall.setUseInBattle(false);
		assertFalse(ultraBall.isUseInBattle());
	}

	@Test
	public void testSetUseOutOfBattle()	{
		freshWater.setUseOutOfBattle(false);
		assertFalse(freshWater.isUseOutOfBattle());
		ultraBall.setUseOutOfBattle(false);
		assertFalse(ultraBall.isUseOutOfBattle());
	}

	@Test
	public void testSetItemName()	{
		freshWater.setItemName("WUUUUTTER");
		assertEquals("WUUUUTTER", freshWater.getItemName());
		ultraBall.setItemName("U-Ball");
		assertEquals("U-Ball", ultraBall.getItemName());
	}

	@Test
	public void testSetCatchRate()	{
		freshWater.setCatchRate(25.1);
		assertEquals(25.1, freshWater.getCatchRate(), DELTA);
		ultraBall.setCatchRate(85.69);
		assertEquals(85.69, ultraBall.getCatchRate(), DELTA);
	}

	@Test
	public void testSetQuantity()	{
		freshWater.setQuantity(85);
		assertEquals(85, freshWater.getQuantity());
		ultraBall.setQuantity(50);
		assertEquals(50, ultraBall.getQuantity());
	}

	@Test
	public void testSetItemEffect()	{
		freshWater.setItemEffect(testList);
		assertEquals(EffectType.FREEZE, freshWater.getItemEffect().get(0).getEffectIndex());
		ultraBall.setItemEffect(testList);
		assertEquals(EffectType.FREEZE, ultraBall.getItemEffect().get(0).getEffectIndex());
	}
}