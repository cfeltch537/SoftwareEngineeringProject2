package edu.ycp.cs320.battleTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeMap;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.Battle.TurnChoice;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.EffectType;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Game;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.BattleStats;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeInfo;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class BattleTest extends TestCase {

	// TODO - define test fixture objects
	private Pokemon Attacker;
	private Pokemon Defender;
	private Player user;
	private Player opp;
	private Location loc;
	private Battle battle;
	private PokeInfo a;
	private PokeInfo b;
	private ArrayList<PokeType> type;
	private Game game;

	
	@Before
	public void setUp()	{
		type = new ArrayList<PokeType>();
		type.add(PokeType.NORMAL);
		a = new PokeInfo(PokeID.Mew, 2, "Mew", "a", false, type, 10, 3,255,new TreeMap<Integer,PokeID>(), null);
		type.add(PokeType.FIRE);
		b = new PokeInfo(PokeID.Mewtwo, 3, "Mewtwo", "b", true, type, 11, 4,255,new TreeMap<Integer,PokeID>(), null);
		BattleStats stats=new BattleStats(10, 12, 14, 16, 18, 20, 22, Status.FRZ, 0,null, null);
		loc = new Location(0, 0, 0);
		ArrayList<Move>moves=new ArrayList<Move>();
		
		moves.add(MoveDataBase.generateMove(MoveName.Tackle));
		Attacker = new Pokemon(a,stats,moves);
		Defender = new Pokemon(b,stats,moves);

		user = new Player(200, "joey", false, loc);
		user.getTeam().add(Attacker);
		game=new Game(user);

		opp = new Player(100, "tony", false, loc);
		opp.getTeam().add(Defender);

		battle = new Battle(user, opp);
	}
	
	
	@Test
	// TODO - add test methods
	public void testfindTurnOrder() throws Exception {
		battle.findTurnOrder();
	}
		
	@Test
	// TODO - add test methods
	public void testCheckTurnValidity() throws Exception {
		battle.CheckTurnValidity();
	}
	@Test
	// TODO - add test methods
	public void testIsTurnOK() throws Exception {
		battle.isTurnOk(user);
	}
	@Test
	// TODO - add test methods
	public void testTurn() throws Exception {
		battle.Turn(1);
		battle.Turn(2);
		battle.Turn(3);
		battle.getOpponent().getTeam(battle.getOpponent().getCurrentPokemonIndex()).getStats().setStatus(Status.FNT);
		battle.Turn(3);
		game.HealTeam();
	}
	@Test
	// TODO - add test methods
	public void testGetSet() throws Exception {
		battle.setBattleMessage(battle.getBattleMessage());

		battle.setBattleOver(battle.getBattleOver());
		battle.setSwitchTeam(battle.getSwitchTeam());
		battle.setUserLost(battle.getUserLost());	
		battle.CatchPokemon();
		battle.getUser();
		battle.getUser().setChoice(TurnChoice.RUN);
		battle.Turn(1);
	}
	@Test
	// TODO - add test methods
	public void testPokemon() throws Exception {
		Pokemon pika=battle.getUser().getTeam(0);
		TreeMap<Integer,PokeID> evo=new TreeMap<Integer,PokeID>();
		evo.put(5,PokeID.Abra);
		TreeMap<Integer,MoveName> moveList=new TreeMap<Integer,MoveName>();
		moveList.put(5,MoveName.Absorb);
		pika.getInfo().setEvolution(evo);
		pika.getInfo().setMoveList(moveList);
		int[] array=new int[6];
		array[0]=1;
		array[1]=1;
		array[2]=1;
		array[3]=1;
		array[4]=1;
		array[5]=1;
		
		pika.getStats().setBaseStats(array);
		
		pika.CheckLevelUp();
		pika.getInfo().setLvl(4);
		pika.getInfo().setXp(1000);
		pika.CheckLevelUp();
		
	}
	
/*
	public void testAttack() throws Exception {
		user.getTeam(0).getStats().fullHeal();
		opp.getTeam(0).getStats().fullHeal();
		int attackerHP = Attacker.getStats().getCurHp();
		int defenderHP = Attacker.getStats().getCurHp();
		Attacker.getTempBattleStats().setACCBoost(6);
		Attacker.getTempBattleStats().setEVABoost(-6);
		Defender.getTempBattleStats().setACCBoost(6);
		Defender.getTempBattleStats().setEVABoost(-6);

		battle.attack(Attacker, Defender, Attacker.getMove(0));
		battle.attack(Defender, Attacker, Defender.getMove(0));
		assertTrue(attackerHP > Attacker.getStats().getCurHp());
		assertTrue(defenderHP > Defender.getStats().getCurHp());

		while (Defender.getStats().getCurHp() > 0) {
			battle.attack(Attacker, Defender, Attacker.getMove(0));
		}
		assertEquals(Defender.getStats().getCurHp(), 0);
		assertEquals(Defender.getStats().getStatus(), Status.FNT);
	}
*/
}
