package edu.ycp.cs320.fokemonTests;

import java.util.ArrayList;
import java.util.TreeMap;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeInfo;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;

import junit.framework.TestCase;

public class PokeInfoTest extends TestCase {
	// TODO - define test fixture objects
	private PokeInfo a;
	private PokeInfo b;
	private ArrayList<PokeType> type;

	@Override
	protected void setUp() throws Exception {
		// TODO - create test fixture objects
		type = new ArrayList<PokeType>();
		type.add(PokeType.NORMAL);
		a = new PokeInfo(PokeID.Mew, 2, "Mew", "a", false, type, 10, 3,255,new TreeMap<Integer,PokeID>(), null);
		type.add(PokeType.FIRE);
		b = new PokeInfo(PokeID.Mewtwo, 3, "Mewtwo", "b", true, type, 11, 4,255,new TreeMap<Integer,PokeID>(), null);
	}

	// TODO - add test methods
	public void testGetType() throws Exception {
		assertEquals(PokeType.NORMAL, a.getType().get(0));
		assertEquals(PokeType.NORMAL, b.getType().get(0));
		assertEquals(PokeType.FIRE, b.getType().get(1));
	}

	public void testGetPokeID() throws Exception {
		assertEquals(PokeID.Mew, a.getID());
		assertEquals(PokeID.Mewtwo, b.getID());
	}

	public void testGetPlayerID() throws Exception {
		assertEquals(2, a.getPlayerID());
		assertEquals(3, b.getPlayerID());
	}

	public void testGetPokemonName() throws Exception {
		assertEquals("Mew", a.getPokeName());
		assertEquals("Mewtwo", b.getPokeName());
	}

	public void testGetNickName() throws Exception {
		assertEquals("a", a.getNickname());
		assertEquals("b", b.getNickname());
	}

	public void testGetXp() throws Exception {
		assertEquals(3, a.getXp());
		assertEquals(4, b.getXp());
	}

	public void testGetLvl() throws Exception {
		assertEquals(10, a.getLvl());
		assertEquals(11, b.getLvl());
	}

	public void testGetGender() throws Exception {
		assertFalse(a.getGender());
		assertTrue(b.getGender());
	}

	public void testGetSetters() throws Exception {
		a.setGender(true);
		assertTrue(a.getGender());

		a.setLvl(1);
		assertEquals(1, a.getLvl());

		a.setNickname("tyrone");
		assertEquals("tyrone", a.getNickname());

		// a.setPlayerID(12);
		// assertEquals(12,a.getPlayerID());

		// a.setPokeID(12);
		// assertEquals(12,a.getID());

		type.clear();
		type.add(PokeType.ROCK);
		a.setType(type);
		assertEquals(PokeType.ROCK, a.getType().get(0));

		a.setLvl(5);
		assertEquals(5, a.getLvl());

		a.setXp(40);
		assertEquals(40, a.getXp());
	}

}
