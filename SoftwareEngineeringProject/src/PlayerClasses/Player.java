package PlayerClasses;

import java.util.ArrayList;

import Battle.TurnChoice;
import PokemonClasses.Pokemon;
import PokemonClasses.Status;



public class Player {
	private String name;
	private boolean gender;
	private Location PlayerLocation;
	private int PlayerID;
	private ArrayList <Pokemon> team;
	private int currentPokemonIndex;
	private TurnChoice choice;
	private int moveIndex;
	private int itemIndex;
	
	

	public Player(int PlayerID, String name, boolean gender, Location playerLocation){
		this.setPlayerID(PlayerID);
		this.setName(name);
		this.setGender(gender);
		this.currentPokemonIndex=0;
		
		team=new ArrayList<Pokemon>();
		setPlayerLocation(new Location(playerLocation.getAreaArrayIndex(), playerLocation.getX(), playerLocation.getY()));
		//team.add(new Pokemon())
		

	}

	public int getTeamSize() {
		return team.size();	
	}

	public Pokemon getTeam(int i) {
		return team.get(i);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
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

	public int getCurrentPokemonIndex() {
		return currentPokemonIndex;
	}

	public void setCurrentPokemonIndex(int currentPokemonIndex) {
		if (currentPokemonIndex<getTeamSize()){
			if(team.get(currentPokemonIndex).getStats().getStatus()!=Status.FNT){
				this.currentPokemonIndex = currentPokemonIndex;
			}
		}
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
}
