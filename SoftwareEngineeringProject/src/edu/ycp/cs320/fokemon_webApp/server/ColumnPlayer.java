package edu.ycp.cs320.fokemon_webApp.server;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.TurnChoice;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class ColumnPlayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean gender;
	private Location PlayerLocation;
	private int PlayerID;
	private ArrayList <Pokemon> team;
	private int currentPokemonIndex;
	private TurnChoice choice;
	private int moveIndex;
	private int itemIndex;
	private int turnOrder;
	
	public ColumnPlayer() {
		
	}
	
	public ColumnPlayer(String _name, boolean _gender,Location _PlayerLocation, int _PlayerID, ArrayList <Pokemon> _team, int _currentPokemonIndex, TurnChoice _choice, int _moveIndex, int _itemIndex, int _turnOrder) {
		this.name = _name;
		this.gender = _gender;
		this.PlayerLocation = _PlayerLocation;
		this.PlayerID = _PlayerID;
		this.team = _team;
		this.currentPokemonIndex = _currentPokemonIndex;
		this.choice = _choice;
		this.moveIndex = _moveIndex;
		this.itemIndex = _itemIndex;
		this.turnOrder = _turnOrder;
	
	}
	
	public Player toPlayer(ColumnPlayer _columnPlayer) {
		Player player1 = new Player();
		player1.setName(_columnPlayer.getName());
		player1.setGender(_columnPlayer.isGender());
		player1.setPlayerLocation(_columnPlayer.getPlayerLocation());
		player1.setPlayerID(_columnPlayer.getPlayerID());
		player1.setTeam(_columnPlayer.getTeam());
		player1.setCurrentPokemonIndex(_columnPlayer.getCurrentPokemonIndex());
		player1.setChoice(_columnPlayer.getChoice());
		player1.setMoveIndex(_columnPlayer.getMoveIndex());
		player1.setItemIndex(_columnPlayer.getItemIndex());
		player1.setTurnOrder(_columnPlayer.getTurnOrder());
		
		return player1;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Location getPlayerLocation() {
		return PlayerLocation;
	}

	public void setPlayerLocation(Location playerLocation) {
		PlayerLocation = playerLocation;
	}

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public ArrayList<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(ArrayList<Pokemon> team) {
		this.team = team;
	}

	public int getCurrentPokemonIndex() {
		return currentPokemonIndex;
	}

	public void setCurrentPokemonIndex(int currentPokemonIndex) {
		this.currentPokemonIndex = currentPokemonIndex;
	}

	public TurnChoice getChoice() {
		return choice;
	}

	public void setChoice(TurnChoice choice) {
		this.choice = choice;
	}

	public int getMoveIndex() {
		return moveIndex;
	}

	public void setMoveIndex(int moveIndex) {
		this.moveIndex = moveIndex;
	}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}

	public int getTurnOrder() {
		return turnOrder;
	}

	public void setTurnOrder(int turnOrder) {
		this.turnOrder = turnOrder;
	}

	

}
