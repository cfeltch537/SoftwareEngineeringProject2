package edu.ycp.cs320.battleTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.EffectType;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeInfo;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class BattleTest extends TestCase {

	// TODO - define test fixture objects
	private Pokemon Attacker;
	private Pokemon Defender;
	private Move AttackerMove;
	private Move DefenderMove;
	private Player user;
	private Player opp;
	private Location loc;
	private Battle battle;

	
	@Before
	public void setUp()	{
		loc = new Location(0, 0, 0);
		Attacker = Pokemon.GeneratePokemon(PokeID.Charizard, 40);
		Defender = Pokemon.GeneratePokemon(PokeID.Pikachu, 35);

		Pokemon Attacker2 = Pokemon.GeneratePokemon(PokeID.Charizard, 40);
		Attacker2 = Attacker;
		Pokemon Attacker3 = Pokemon.GeneratePokemon(PokeID.Charizard, 40);
		Attacker3 = Attacker;

		Pokemon Defender2 = Pokemon.GeneratePokemon(PokeID.Pikachu, 35);
		Defender2 = Defender;
		Pokemon Defender3 = Pokemon.GeneratePokemon(PokeID.Pikachu, 35);
		Defender3 = Defender;
		user = new Player(200, "joey", false, loc);
		user.getTeam().add(Attacker);
		user.getTeam().add(Attacker2);
		user.getTeam().add(Attacker3);
		opp = new Player(100, "tony", false, loc);
		opp.getTeam().add(Defender);
		opp.getTeam().add(Defender2);
		opp.getTeam().add(Defender3);

		user = new Player(200, "joey", false, loc);
		user.getTeam().add(Attacker);
		opp = new Player(100, "tony", false, loc);
		opp.getTeam().add(Defender);

		battle = new Battle(user, opp);
	}
	
		
		
	@Test
	// TODO - add test methods
	public void testCalcDamage() throws Exception {
		int damage1 = battle.CalcDamage(Attacker, Defender, AttackerMove);
		int damage2 = battle.CalcDamage(Defender, Attacker, AttackerMove);
		assertTrue(damage1 > damage2);
	}

	

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

}
