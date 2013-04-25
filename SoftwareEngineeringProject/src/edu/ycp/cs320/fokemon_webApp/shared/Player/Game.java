package edu.ycp.cs320.fokemon_webApp.shared.Player;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class Game {
	private static Player user;
	//private Battle battle;


	public Game(){
		Location loc=new Location(0, 0, 0);
		user = new Player(200, "Cody F.", true, loc);
		
		user.getItems().add(ItemDatabase.generateItem(ItemName.SUPER_POTION,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.HYPER_POTION,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.REVIVE,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.MASTER_BALL,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.POKE_BALL,5));
		
		Pokemon Attacker = Pokemon.GeneratePokemon(PokeID.Charizard, 75);
		Attacker.getInfo().setNickname("Charizizzle");
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Spore));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Bite));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Flamethrower));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Acid));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Hyper_Beam));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Hydro_Pump));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.SolarBeam));
		
		Pokemon Attacker2 = Pokemon.GeneratePokemon(PokeID.Snorlax, 99);
		Pokemon Attacker3 = Pokemon.GeneratePokemon(PokeID.Blastoise, 30);
		user.getTeam().add(Attacker);
		user.getTeam().add(Attacker2);
		user.getTeam().add(Attacker3);
		//setBattle(Battle.wildPokemonBattle(PokeID.Pikachu, 35));
	}
	public Game(Player user){
		Game.user=user;
	}


	public static Player getUser() {
		return user;
	}


	public static void setUser(Player user) {
		Game.user = user;
	}


//	public Battle getBattle() {
//		return battle;
//	}
//
//
//	public void setBattle(Battle battle) {
//		this.battle = battle;
//	}
}