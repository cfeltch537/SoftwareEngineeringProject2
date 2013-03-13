package edu.ycp.cs320.battleTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import edu.ycp.cs320.fokemon_webApp.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeInfo;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;
import edu.ycp.cs320.fokemon_webApp.shared.player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.player.Player;


public class BattleTest extends TestCase{
	
		// TODO - define test fixture objects
		private Pokemon Attacker;
		private Pokemon Defender;
		private Move AttackerMove;
		private Move DefenderMove;
		private Player user;
		private Player opp;
		private Location loc;
		private Battle battle;
		
		
		@Override
		protected void setUp() throws Exception {
			// TODO - create test fixture objects
			loc=new Location(0, 0, 0);
			AttackerMove=MoveDataBase.generateMove(MoveName.Tackle);
			DefenderMove=MoveDataBase.generateMove(MoveName.Bite);
			Attacker=new Pokemon(40, 40);
			Defender=new Pokemon(35, 35);
			Attacker.getMoves().add(AttackerMove);
			Attacker.getMoves().add(DefenderMove);
			Defender.getMoves().add(DefenderMove);
			user=new Player(200, "joey", false, loc);
			user.getTeam().add(Attacker);
			opp=new Player(100,"tony", false, loc);
			opp.getTeam().add(Defender);
			battle=new Battle(user, opp);
		}
		
		// TODO - add test methods
		public void testCalcDamage() throws Exception {
			int damage1=battle.CalcDamage(Attacker, Defender, AttackerMove);
			int damage2=battle.CalcDamage(Defender, Attacker, AttackerMove);
			assertTrue(damage1>damage2);
		}
		public void testTurn() throws Exception {
			user.getTeam(0).getStats().fullHeal();
			opp.getTeam(0).getStats().fullHeal();
			int userHP=user.getTeam(0).getStats().getCurHp();
			int oppHP=opp.getTeam(0).getStats().getCurHp();
			Attacker.getTempBattleStats().setACCBoost(6);
			Attacker.getTempBattleStats().setEVABoost(-6);
			Defender.getTempBattleStats().setACCBoost(6);
			Defender.getTempBattleStats().setEVABoost(-6);
			battle.Turn();
			assertTrue(userHP>battle.getUser().getTeam(0).getStats().getCurHp());
			assertTrue(userHP>user.getTeam(0).getStats().getCurHp());
			assertTrue(oppHP>opp.getTeam(0).getStats().getCurHp());
			assertEquals(Attacker, user.getTeam(0));
			assertEquals(user,battle.getUser());
		}
		public void testAttack() throws Exception {
			user.getTeam(0).getStats().fullHeal();
			opp.getTeam(0).getStats().fullHeal();
			int attackerHP=Attacker.getStats().getCurHp();
			int defenderHP=Attacker.getStats().getCurHp();
			Attacker.getTempBattleStats().setACCBoost(6);
			Attacker.getTempBattleStats().setEVABoost(-6);
			Defender.getTempBattleStats().setACCBoost(6);
			Defender.getTempBattleStats().setEVABoost(-6);
			
			battle.attack(Attacker, Defender,Attacker.getMove(0));
			battle.attack(Defender, Attacker, Defender.getMove(0));
			assertTrue(attackerHP>Attacker.getStats().getCurHp());
			assertTrue(defenderHP>Defender.getStats().getCurHp());
			
			while(Defender.getStats().getCurHp()>0){
				battle.attack(Attacker, Defender, Attacker.getMove(0));
			}
			assertEquals(Defender.getStats().getCurHp(), 0);
			assertEquals(Defender.getStats().getStatus(), Status.FNT);
		}
		
}
