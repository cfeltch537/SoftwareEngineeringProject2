package edu.ycp.cs320.fokemon_webApp.shared.Login;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.TurnChoice;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class ColumnPlayer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean gender;
	private int PlayerLocation;
	private int PlayerLocationX;
	private int PlayerLocationY;
	private int PlayerID;
	//private ArrayList <Pokemon> team;
	private int currentPokemonIndex;
	private int choice;
	private int moveIndex;
	private int itemIndex;
	private int turnOrder;

	public ColumnPlayer() {
		this.name = null;
		this.gender = false;
		this.PlayerLocation = 0;
		this.PlayerID = 0;
		//this.team = null;
		this.currentPokemonIndex = 0;
		this.choice = 0;
		this.moveIndex = 0;
		this.itemIndex = 0;
		this.turnOrder = 0;
	}

	public ColumnPlayer(String _name, boolean _gender, int _PlayerLocation, int _PlayerLocationX, int _PlayerLocationY, int _PlayerID,/* ArrayList <Pokemon> _team, */int _currentPokemonIndex, int _choice, int _moveIndex, int _itemIndex, int _turnOrder) {
		this.name = _name;
		this.gender = _gender;
		this.PlayerLocation = _PlayerLocation;
		this.PlayerLocationX = _PlayerLocationX;
		this.PlayerLocationY = _PlayerLocationY;
		this.PlayerID = _PlayerID;
		//this.team = _team;
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
		//player1.setPlayerLocation(_columnPlayer.getPlayerLocation());
		player1.setPlayerID(_columnPlayer.getPlayerID());
		//player1.setTeam(_columnPlayer.getTeam());
		player1.setCurrentPokemonIndex(_columnPlayer.getCurrentPokemonIndex());
		//player1.setChoice(_columnPlayer.getChoice());
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

	public int getPlayerLocation() {
		return PlayerLocation;
	}

	public void setPlayerLocation(int playerLocation) {
		PlayerLocation = playerLocation;
	}

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}
	/*
	public ArrayList<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(ArrayList<Pokemon> team) {
		this.team = team;
	}
	 */
	public int getCurrentPokemonIndex() {
		return currentPokemonIndex;
	}

	public void setCurrentPokemonIndex(int currentPokemonIndex) {
		this.currentPokemonIndex = currentPokemonIndex;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
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

	public int getPlayerLocationY() {
		return PlayerLocationY;
	}

	public void setPlayerLocationY(int playerLocationY) {
		PlayerLocationY = playerLocationY;
	}

	public int getPlayerLocationX() {
		return PlayerLocationX;
	}

	public void setPlayerLocationX(int playerLocationX) {
		PlayerLocationX = playerLocationX;
	}



}
