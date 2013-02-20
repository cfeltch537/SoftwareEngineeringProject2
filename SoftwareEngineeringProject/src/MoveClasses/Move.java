package MoveClasses;

import java.util.ArrayList;

import PokemonClasses.PokeType;


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

	
	public static Move generateMove(MoveName moveName){
		ArrayList <Effect> effectList = new ArrayList<Effect>();
		Effect effect=new Effect(EffectType.NONE,0,0,"");
		effectList.add(effect);
		//Moves are Have no effect, no damage, are physical, type Normal, and have accuracy of 100 by default
		Move move=new Move(0, 0, effectList, 100, moveName, 0, PokeType.NORMAL,true);
		
		
		switch (moveName) {
        case Tackle: 
        	move.setDamage(20);
        	move.setMaxPP(30);
        	move.setAccuracy(90);
            	break;
        case Bite:
        	move.setDamage(60);
        	move.setMaxPP(15);
        	move.setAccuracy(85);
        		break;
        case Ember:
        	move.setDamage(40);
        	move.setMaxPP(15);
        	move.setAccuracy(85);
        	move.setPhysical(false);
        	move.setPokeType(PokeType.FIRE);
        	
        	effect.setEffectIndex(EffectType.BURN);
        	effect.setEffectChance(15);
        	effect.setMagnitude(0);
        	effectList.add(0, effect);
        	
        	move.setEffect(effectList);
        		break;
        case Heal:
        	move.setMaxPP(10);
        	move.setPhysical(false);
        	
        	effect.setEffectIndex(EffectType.RECOVERCONST);
        	effect.setEffectChance(100);
        	effect.setMagnitude(40);
        	effectList.add(effect);
        	
        	move.setEffect(effectList);
        		break;
        case Spore:
        	move.setMaxPP(10);
        	move.setPhysical(false);
        	
        	effect.setEffectIndex(EffectType.SLEEP);
        	effect.setEffectChance(100);
        	effect.setMagnitude(0);
        	effectList.add(effect);
        	
        	move.setEffect(effectList);
        		break;
        case Blizzard:
        	move.setDamage(100);
        	move.setMaxPP(10);
        	move.setAccuracy(70);
        	move.setPhysical(false);
        	move.setPokeType(PokeType.ICE);
        	
        	effect.setEffectIndex(EffectType.FREEZE);
        	effect.setEffectChance(30);
        	effect.setMagnitude(0);
        	effectList.add(effect);
        	
        	move.setEffect(effectList);
        		break;
        case Acid:
        	move.setDamage(40);
        	move.setMaxPP(15);
        	move.setAccuracy(85);
        	move.setPhysical(false);
        	move.setPokeType(PokeType.GRASS);
        	
        	effect.setEffectIndex(EffectType.POISON);
        	effect.setEffectChance(50);
        	effect.setMagnitude(0);
        	effectList.add(0, effect);
        	
        	move.setEffect(effectList);
        		break;
        		
        case Thunder_Wave:
        	move.setMaxPP(10);
        	move.setPhysical(false);
        	move.setPokeType(PokeType.ELECTRIC);
        	
        	effect.setEffectIndex(EffectType.PARALYZE);
        	effect.setEffectChance(100);
        	effect.setMagnitude(0);
        	effectList.add(effect);
        		break;
        default: //no effect
            	break;
		}
		move.setCurPP(move.getMaxPP());
		return move;
		
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

