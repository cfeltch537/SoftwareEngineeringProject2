package edu.ycp.cs320.fokemon_webApp.shared.MoveClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;


public class MoveDataBase {
	//private static ArrayList <Effect> effectList;
	//private static Effect effect;
	
	public static Move generateMove(MoveName moveName){
		ArrayList <Effect> effectList = new ArrayList<Effect>();
		Effect effect=new Effect(EffectType.NONE,0,0,"");
		effectList.add(effect);
		//Moves are Have no effect, no damage, are physical, type Normal, and have accuracy of 100 by default
		Move move=new Move(0, 0, effectList, 100, moveName, 0, PokeType.NORMAL,true,0);
		effectList.clear();
		
		
		switch (moveName) {
		case Confused:
			move.setDamage(40);
			move.setMaxPP(100000);
			move.setAccuracy(-1);
				break;
   	
	case Absorb:
		move.setDamage(20);
		move.setAccuracy(100);
		move.setMaxPP(25);
		move.setPhysical(false);
		move.setPokeType(PokeType.GRASS);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Acid:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.POISON);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(50);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
    	break;
	case Acid_Armor:
		move.setDamage(0);
		move.setAccuracy(-1);
		move.setMaxPP(40);
		move.setPhysical(false);
		move.setPokeType(PokeType.POISON);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Agility:
		move.setDamage(0);
		move.setAccuracy(-1);
		move.setMaxPP(30);
		move.setPhysical(false);
		move.setPokeType(PokeType.PSYCHIC);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Amnesia:
		move.setDamage(0);
		move.setAccuracy(-1);
		move.setMaxPP(20);
		move.setPhysical(false);
		move.setPokeType(PokeType.PSYCHIC);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Aurora_Beam:
		move.setDamage(65);
		move.setAccuracy(100);
		move.setMaxPP(20);
		move.setPhysical(false);
		move.setPokeType(PokeType.ICE);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Barrage:
		move.setDamage(15);
		move.setAccuracy(85);
		move.setMaxPP(20);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Barrier:
		move.setDamage(0);
		move.setAccuracy(0);
		move.setMaxPP(30);
		move.setPhysical(false);
		move.setPokeType(PokeType.PSYCHIC);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Bide:
		move.setDamage(0);
		move.setAccuracy(0);
		move.setMaxPP(10);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Bind:
		move.setDamage(15);
		move.setAccuracy(85);
		move.setMaxPP(20);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Bite:
    	move.setDamage(60);
    	move.setMaxPP(25);
    	move.setAccuracy(100);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.DARK);
    	
    	effectList.add(effect);
    	move.setEffect(effectList);
    	break;
	case Blizzard:
    	move.setDamage(120);
    	move.setMaxPP(5);
    	move.setAccuracy(70);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ICE);
    	
    	effect.setEffectIndex(EffectType.FREEZE);
    	effect.setEffectChance(30);
    	effect.setMagnitude(0);
    	
    	effectList.add(effect);
    	move.setEffect(effectList);
    	break;
	case Body_Slam:
		move.setDamage(85);
		move.setAccuracy(100);
		move.setMaxPP(15);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Bone_Club:
		move.setDamage(65);
		move.setAccuracy(85);
		move.setMaxPP(20);
		move.setPhysical(true);
		move.setPokeType(PokeType.GROUND);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Bonemerang:
		move.setDamage(50);
		move.setAccuracy(90);
		move.setMaxPP(10);
		move.setPhysical(true);
		move.setPokeType(PokeType.GROUND);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Bubble:
		move.setDamage(20);
		move.setAccuracy(100);
		move.setMaxPP(30);
		move.setPhysical(false);
		move.setPokeType(PokeType.WATER);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case BubbleBeam:
		move.setDamage(65);
		move.setAccuracy(100);
		move.setMaxPP(20);
		move.setPhysical(false);
		move.setPokeType(PokeType.WATER);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Clamp:
		move.setDamage(35);
		move.setAccuracy(75);
		move.setMaxPP(10);
		move.setPhysical(true);
		move.setPokeType(PokeType.WATER);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Comet_Punch:
		move.setDamage(18);
		move.setAccuracy(85);
		move.setMaxPP(15);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Confuse_Ray:
		move.setDamage(0);
		move.setAccuracy(100);
		move.setMaxPP(10);
		move.setPhysical(false);
		move.setPokeType(PokeType.GHOST);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Confusion:
		move.setDamage(50);
		move.setAccuracy(100);
		move.setMaxPP(25);
		move.setPhysical(false);
		move.setPokeType(PokeType.PSYCHIC);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Constrict:
		move.setDamage(10);
		move.setAccuracy(100);
		move.setMaxPP(35);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Conversion:
		move.setDamage(0);
		move.setAccuracy(0);
		move.setMaxPP(30);
		move.setPhysical(false);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Counter:
		move.setDamage(0);
		move.setAccuracy(100);
		move.setMaxPP(20);
		move.setPhysical(true);
		move.setPokeType(PokeType.FIGHTING);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Crabhammer:
		move.setDamage(90);
		move.setAccuracy(90);
		move.setMaxPP(10);
		move.setPhysical(true);
		move.setPokeType(PokeType.WATER);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Cut:
		move.setDamage(50);
		move.setAccuracy(95);
		move.setMaxPP(30);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Defense_Curl:
		move.setDamage(0);
		move.setAccuracy(0);
		move.setMaxPP(40);
		move.setPhysical(false);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Dig:
		move.setDamage(80);
		move.setAccuracy(100);
		move.setMaxPP(10);
		move.setPhysical(true);
		move.setPokeType(PokeType.GROUND);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Disable:
		move.setDamage(0);
		move.setAccuracy(100);
		move.setMaxPP(20);
		move.setPhysical(false);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case Dizzy_Punch:
		move.setDamage(70);
		move.setAccuracy(100);
		move.setMaxPP(10);
		move.setPhysical(true);
		move.setPokeType(PokeType.NORMAL);

		effectList.add(effect);
		move.setEffect(effectList);
		break;
	case DoubleSlap:
    	move.setDamage(15);
    	move.setAccuracy(85);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Double_Edge:
    	move.setDamage(120);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Double_Kick:
    	move.setDamage(30);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Double_Team:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Dragon_Rage:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.DRAGON);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Dream_Eater:
    	move.setDamage(100);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Drill_Peck:
    	move.setDamage(80);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FLYING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Earthquake:
    	move.setDamage(100);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.GROUND);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Egg_Bomb:
    	move.setDamage(100);
    	move.setAccuracy(75);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Ember:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(25);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.FIRE);
    	
    	effect.setEffectIndex(EffectType.BURN);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Explosion:
    	move.setDamage(250);
    	move.setAccuracy(100);
    	move.setMaxPP(5);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fire_Blast:
    	move.setDamage(120);
    	move.setAccuracy(85);
    	move.setMaxPP(5);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.FIRE);
    	
    	effect.setEffectIndex(EffectType.BURN);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fire_Punch:
    	move.setDamage(75);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIRE);
    	
    	effect.setEffectIndex(EffectType.BURN);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fire_Spin:
    	move.setDamage(35);
    	move.setAccuracy(85);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.FIRE);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fissure:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(5);
//    	move.setPhysical(true);
//    	move.setPokeType(PokeType.GROUND);
//    	
//    	effect.setEffectIndex(EffectType.FREEZE);
//    	effect.setEffectChance(50);
//    	effect.setMagnitude(0);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Flamethrower:
    	move.setDamage(95);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.FIRE);
    	
    	effect.setEffectIndex(EffectType.BURN);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Flash:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fly:
    	move.setDamage(90);
    	move.setAccuracy(95);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FLYING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Focus_Energy:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fury_Attack:
    	move.setDamage(15);
    	move.setAccuracy(85);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Fury_Swipes:
    	move.setDamage(18);
    	move.setAccuracy(80);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Glare:
    	move.setDamage(0);
    	move.setAccuracy(90);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Growl:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Growth:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Guillotine:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(5);
//    	move.setPhysical(true);
//    	move.setPokeType(PokeType.NORMAL);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Gust:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.FLYING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Harden:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Haze:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ICE);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Headbutt:
    	move.setDamage(70);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(30);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Hi_Jump_Kick:
    	move.setDamage(130);
    	move.setAccuracy(90);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Horn_Attack:
    	move.setDamage(65);
    	move.setAccuracy(100);
    	move.setMaxPP(25);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Horn_Drill:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(5);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Hydro_Pump:
    	move.setDamage(120);
    	move.setAccuracy(80);
    	move.setMaxPP(5);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.WATER);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Hyper_Beam:
    	move.setDamage(150);
    	move.setAccuracy(90);
    	move.setMaxPP(5);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Hyper_Fang:
    	move.setDamage(80);
    	move.setAccuracy(90);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(10);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Hypnosis:
    	move.setDamage(0);
    	move.setAccuracy(60);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effect.setEffectIndex(EffectType.SLEEP);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Ice_Beam:
    	move.setDamage(95);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ICE);
    	
    	effect.setEffectIndex(EffectType.FREEZE);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Ice_Punch:
    	move.setDamage(75);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.ICE);
    	
    	effect.setEffectIndex(EffectType.FREEZE);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Jump_Kick:
    	move.setDamage(100);
    	move.setAccuracy(95);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Karate_Chop:
    	move.setDamage(50);
    	move.setAccuracy(100);
    	move.setMaxPP(25);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Kinesis:
    	move.setDamage(0);
    	move.setAccuracy(80);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Leech_Life:
    	move.setDamage(20);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.BUG);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Leech_Seed:
    	move.setDamage(0);
    	move.setAccuracy(90);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Leer:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Lick:
    	move.setDamage(20);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.GHOST);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(30);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Light_Screen:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Lovely_Kiss:
    	move.setDamage(0);
    	move.setAccuracy(75);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effect.setEffectIndex(EffectType.SLEEP);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Low_Kick:
//    	move.setDamage(0);
//    	move.setAccuracy(100);
//    	move.setMaxPP(20);
//    	move.setPhysical(true);
//    	move.setPokeType(PokeType.FIGHTING);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Meditate:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Mega_Drain:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Mega_Kick:
    	move.setDamage(120);
    	move.setAccuracy(75);
    	move.setMaxPP(5);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Mega_Punch:
    	move.setDamage(80);
    	move.setAccuracy(85);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Metronome:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(10);
//    	move.setPhysical(false);
//    	move.setPokeType(PokeType.NORMAL);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Mimic:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Minimize:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Mirror_Move:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(20);
//    	move.setPhysical(false);
//    	move.setPokeType(PokeType.FLYING);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Mist:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ICE);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Night_Shade:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GHOST);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Pay_Day:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Peck:
    	move.setDamage(35);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FLYING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Petal_Dance:
    	move.setDamage(120);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Pin_Missile:
    	move.setDamage(14);
    	move.setAccuracy(85);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.BUG);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case PoisonPowder:
    	move.setDamage(0);
    	move.setAccuracy(75);
    	move.setMaxPP(35);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.POISON);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Poison_Gas:
    	move.setDamage(0);
    	move.setAccuracy(85);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.POISON);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Poison_Sting:
    	move.setDamage(15);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.POISON);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(30);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Pound:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Psybeam:
    	move.setDamage(65);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effect.setEffectIndex(EffectType.CONFUSION);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Psychic:
    	move.setDamage(90);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Psywave:
    	move.setDamage(0);
    	move.setAccuracy(80);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Quick_Attack:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Rage:
    	move.setDamage(20);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Razor_Leaf:
    	move.setDamage(55);
    	move.setAccuracy(95);
    	move.setMaxPP(25);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.GRASS);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Razor_Wind:
    	move.setDamage(80);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Recover:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Reflect:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Rest:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.PSYCHIC);
    	
    	effect.setEffectIndex(EffectType.SLEEP);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Roar:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Rock_Slide:
    	move.setDamage(75);
    	move.setAccuracy(90);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.ROCK);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(30);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Rock_Throw:
    	move.setDamage(50);
    	move.setAccuracy(90);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.ROCK);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Rolling_Kick:
    	move.setDamage(60);
    	move.setAccuracy(85);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(30);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Sand_Attack:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GROUND);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Scratch:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Screech:
    	move.setDamage(0);
    	move.setAccuracy(85);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Seismic_Toss:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Selfdestruct:
    	move.setDamage(200);
    	move.setAccuracy(100);
    	move.setMaxPP(5);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Sharpen:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Sing:
    	move.setDamage(0);
    	move.setAccuracy(55);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effect.setEffectIndex(EffectType.SLEEP);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Skull_Bash:
    	move.setDamage(100);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Sky_Attack:
    	move.setDamage(140);
    	move.setAccuracy(90);
    	move.setMaxPP(5);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FLYING);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(30);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Slam:
    	move.setDamage(80);
    	move.setAccuracy(75);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Slash:
    	move.setDamage(70);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Sleep_Powder:
    	move.setDamage(0);
    	move.setAccuracy(75);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effect.setEffectIndex(EffectType.SLEEP);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Sludge:
    	move.setDamage(65);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.POISON);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(30);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Smog:
    	move.setDamage(20);
    	move.setAccuracy(70);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.POISON);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(40);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case SmokeScreen:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Softboiled:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case SolarBeam:
    	move.setDamage(120);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case SonicBoom:
    	move.setDamage(20);
    	move.setAccuracy(90);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Spike_Cannon:
    	move.setDamage(20);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Splash:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Spore:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effect.setEffectIndex(EffectType.SLEEP);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
     	break;
	case Stomp:
    	move.setDamage(65);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(30);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Strength:
    	move.setDamage(80);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case String_Shot:
    	move.setDamage(0);
    	move.setAccuracy(95);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.BUG);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Struggle:
    	move.setDamage(50);
    	move.setAccuracy(100);
    	move.setMaxPP(0);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Stun_Spore:
    	move.setDamage(0);
    	move.setAccuracy(75);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.GRASS);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Submission:
    	move.setDamage(80);
    	move.setAccuracy(80);
    	move.setMaxPP(25);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FIGHTING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Substitute:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(10);
//    	move.setPhysical(false);
//    	move.setPokeType(PokeType.NORMAL);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Super_Fang:
//    	move.setDamage(0);
//    	move.setAccuracy(90);
//    	move.setMaxPP(10);
//    	move.setPhysical(true);
//    	move.setPokeType(PokeType.NORMAL);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Supersonic:
    	move.setDamage(0);
    	move.setAccuracy(55);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effect.setEffectIndex(EffectType.CONFUSION);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Surf:
    	move.setDamage(95);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.WATER);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Swift:
    	move.setDamage(60);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Swords_Dance:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Tackle:
    	move.setDamage(50);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Tail_Whip:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Take_Down:
    	move.setDamage(90);
    	move.setAccuracy(85);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Teleport:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(20);
//    	move.setPhysical(false);
//    	move.setPokeType(PokeType.PSYCHIC);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Thrash:
    	move.setDamage(120);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Thunder:
    	move.setDamage(120);
    	move.setAccuracy(70);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ELECTRIC);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(30);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case ThunderPunch:
    	move.setDamage(75);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.ELECTRIC);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case ThunderShock:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ELECTRIC);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
    case Thunder_Wave:
    	move.setDamage(0);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ELECTRIC);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(100);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
    	break;
	case Thunderbolt:
    	move.setDamage(95);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.ELECTRIC);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(10);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Toxic:
    	move.setDamage(0);
    	move.setAccuracy(90);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.POISON);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Transform:
//    	move.setDamage(0);
//    	move.setAccuracy(-1);
//    	move.setMaxPP(10);
//    	move.setPhysical(false);
//    	move.setPokeType(PokeType.NORMAL);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Tri_Attack:
    	move.setDamage(80);
    	move.setAccuracy(100);
    	move.setMaxPP(10);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effect.setEffectIndex(EffectType.PARALYZE);
    	effect.setEffectChance(7);
    	effect.setMagnitude(0);
    	effect.setEffectIndex(EffectType.BURN);
    	effect.setEffectChance(7);
    	effect.setMagnitude(0);
    	effect.setEffectIndex(EffectType.FREEZE);
    	effect.setEffectChance(7);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Twineedle:
    	move.setDamage(25);
    	move.setAccuracy(100);
    	move.setMaxPP(20);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.BUG);
    	
    	effect.setEffectIndex(EffectType.POISON);
    	effect.setEffectChance(20);
    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case ViceGrip:
    	move.setDamage(55);
    	move.setAccuracy(100);
    	move.setMaxPP(30);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Vine_Whip:
    	move.setDamage(35);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.GRASS);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Water_Gun:
    	move.setDamage(40);
    	move.setAccuracy(100);
    	move.setMaxPP(25);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.WATER);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Waterfall:
    	move.setDamage(80);
    	move.setAccuracy(100);
    	move.setMaxPP(15);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.WATER);
    	
//    	effect.setEffectIndex(EffectType.FLINCH);
//    	effect.setEffectChance(20);
//    	effect.setMagnitude(0);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Whirlwind:
//    	move.setDamage(0);
//    	move.setAccuracy(100);
//    	move.setMaxPP(20);
//    	move.setPhysical(false);
//    	move.setPokeType(PokeType.NORMAL);
//    	
//    	effectList.add(0, effect);
//    	move.setEffect(effectList);
		break;
	case Wing_Attack:
    	move.setDamage(60);
    	move.setAccuracy(100);
    	move.setMaxPP(35);
    	move.setPhysical(true);
    	move.setPokeType(PokeType.FLYING);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Withdraw:
    	move.setDamage(0);
    	move.setAccuracy(-1);
    	move.setMaxPP(40);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.WATER);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
		break;
	case Wrap:
    	move.setDamage(15);
    	move.setAccuracy(90);
    	move.setMaxPP(20);
    	move.setPhysical(false);
    	move.setPokeType(PokeType.NORMAL);
    	
    	effectList.add(0, effect);
    	move.setEffect(effectList);
    	break;
	default:
		break;
	}
	move.setCurPP(move.getMaxPP());
	return move;


	}
		
}


