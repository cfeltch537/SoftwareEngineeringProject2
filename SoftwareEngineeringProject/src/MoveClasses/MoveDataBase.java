package MoveClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon.PokeType;

public class MoveDataBase {
	//private static ArrayList <Effect> effectList;
	//private static Effect effect;
	
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
}
