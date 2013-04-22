package edu.ycp.cs320.fokemon_webApp.client;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class TempBattle {

	private Pokemon Attacker;
	private Pokemon Defender;
	private Move AttackerMove;
	private Move DefenderMove;
	private static Player user;
	private Player opp;
	private Location loc;
	private Battle battle;

	public TempBattle() {
		loc = new Location(0, 0, 0);
		user = new Player(200, "Cody F.", true, loc);
		opp = new Player(100, "Roberto", true, loc);
		
		user.getItems().add(ItemDatabase.generateItem(ItemName.SUPER_POTION,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.HYPER_POTION,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.REVIVE,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.MASTER_BALL,5));
		user.getItems().add(ItemDatabase.generateItem(ItemName.POKE_BALL,5));
		
		Attacker = Pokemon.GeneratePokemon(PokeID.Charizard, 75);
		Attacker.getInfo().setNickname("Charizizzle");
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Spore));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Bite));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Flamethrower));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Acid));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Hyper_Beam));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Hydro_Pump));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.SolarBeam));
		Defender = Pokemon.GeneratePokemon(PokeID.Pikachu, 35);
		Defender.getInfo().setNickname("Pikajew");
		Defender.getMoves().add(DefenderMove);
		Pokemon Attacker2 = Pokemon.GeneratePokemon(PokeID.Snorlax, 99);
		Pokemon Attacker3 = Pokemon.GeneratePokemon(PokeID.Blastoise, 30);
		Pokemon Defender2 = Pokemon.GeneratePokemon(PokeID.Abra, 10);
		Pokemon Defender3 = Pokemon.GeneratePokemon(PokeID.Gastly, 35);
		user.getTeam().add(Attacker);
		user.getTeam().add(Attacker2);
		user.getTeam().add(Attacker3);
		opp.getTeam().add(Defender);
		opp.getTeam().add(Defender2);
		opp.getTeam().add(Defender3);
		setBattle(new Battle(user, opp));
	}

	public static Player getUser() {

		return user;
	}

	public void setUser(Player user) {
		this.user = user;
	}

	public Player getOpp() {
		return opp;
	}

	public void setOpp(Player opp) {
		this.opp = opp;
	}

	public void update() {

	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}
}
