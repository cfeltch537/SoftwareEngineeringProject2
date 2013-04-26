package edu.ycp.cs320.fokemon_webApp.shared.MoveClasses;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;

public class Move implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int curPP;
	private int maxPP;
	private ArrayList<Effect> effect;
	private int accuracy;
	private MoveName moveName;
	private int damage;
	private PokeType pokeType;
	private boolean physical;
	private int movePriority;

	public Move(int curPP, int maxPP, ArrayList<Effect> effect, int accuracy,
			MoveName moveName, int damage, PokeType pokeType, boolean physical,
			int movePriority) {
		this.curPP = curPP;
		this.maxPP = maxPP;
		this.effect = new ArrayList<Effect>(effect); // make a copy of the list
		this.accuracy = accuracy;
		this.moveName = moveName;
		this.damage = damage;
		this.pokeType = pokeType;
		this.physical = physical;
		this.movePriority = movePriority;
	}

	public Move() {
		this.curPP = 0;
		this.maxPP = 0;
		this.effect = null; // make a copy of the list
		this.accuracy = 0;
		this.moveName = null;
		this.damage = 0;
		this.pokeType = null;
		this.physical = false;
		this.movePriority = 0;
	}
	
	public int getCurPP() {
		return curPP;
	}

	public void setCurPP(int curPP) {
		this.curPP = curPP;
	}

	public int getMaxPP() {
		return maxPP;
	}

	public void setMaxPP(int maxPP) {
		this.maxPP = maxPP;
	}

	public ArrayList<Effect> getEffect() {
		return effect;
	}

	public void setEffect(ArrayList<Effect> effect) {
		this.effect = effect;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public MoveName getMoveName() {
		return moveName;
	}

	public void setMoveName(MoveName moveName) {
		this.moveName = moveName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public PokeType getPokeType() {
		return pokeType;
	}

	public void setPokeType(PokeType pokeType) {
		this.pokeType = pokeType;
	}

	public boolean getPhysical() {
		return physical;
	}

	public void setPhysical(boolean physical) {
		this.physical = physical;
	}

	public int getMovePriority() {
		return movePriority;
	}

	public void setMovePriority(int movePriority) {
		this.movePriority = movePriority;
	}
}
