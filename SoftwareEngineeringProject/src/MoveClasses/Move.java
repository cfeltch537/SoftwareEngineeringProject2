package MoveClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon.PokeType;

public class Move {
	private int curPP;
	private int maxPP;
	private ArrayList<Effect> effect;
	private int accuracy;
	private MoveName moveName;
	private int damage;
	private PokeType pokeType;
	private boolean physical;
	
	public Move(int curPP, int maxPP, ArrayList<Effect> effect, int accuracy, MoveName moveName, int damage, PokeType pokeType, boolean physical) {
		this.curPP = curPP;
		this.maxPP = maxPP;
		this.effect = effect;
		this.accuracy = accuracy;
		this.moveName = moveName;
		this.damage = damage;
		this.pokeType = pokeType;
		this.physical = physical;
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
}

