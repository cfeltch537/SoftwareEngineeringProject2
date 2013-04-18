package edu.ycp.cs320.fokemon_webApp.shared.ItemClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.EffectType;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class ItemDatabase {
	public static Item generateItem(ItemName itemName, Pokemon attacker, int moveIndex)	{
		ArrayList<Effect> itemEffect = new ArrayList<Effect>(); 
		Effect effect = new Effect(EffectType.NONE,0,0,"");
		itemEffect.add(effect);
		Item item = new Item(0, 0, 0, false, false, itemName, itemEffect);
		itemEffect.clear();
		
		switch(itemName)	{
		case CALCIUM:
			item.setQuantity(1);
			item.setBuyPrice(9800);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			break;
		case CARBOS:
			item.setQuantity(1);
			item.setBuyPrice(9800);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			break;
		case ELIXIR:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(1500);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			for(int i = 0; i < attacker.getMoves().size(); i++){
				effect.setEffectIndex(EffectType.PP_UP);
				effect.setEffectChance(100);
				effect.setMagnitude(attacker.getMove(i).getCurPP() + 10);
				
				itemEffect.add(0, effect);
			}
			item.setItemEffect(itemEffect);
			break;
		case ENERGY_POWDER:
			item.setQuantity(1);
			item.setBuyPrice(500);
			item.setSellPrice(250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(50);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case ENERGY_ROOT:
			item.setQuantity(1);
			item.setBuyPrice(800);
			item.setSellPrice(400);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(200);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case ETHER:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(600);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(10);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case FRESH_WATER:
			item.setQuantity(1);
			item.setBuyPrice(200);
			item.setSellPrice(100);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(50);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case FULL_RESTORE:
			item.setQuantity(1);
			item.setBuyPrice(3000);
			item.setSellPrice(1500);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERFULL);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getStats().getMaxHp());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case HEAL_POWDER:
			item.setQuantity(1);
			item.setBuyPrice(450);
			item.setSellPrice(225);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERFULL);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getStats().getCurHp());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case HP_UP:
			item.setQuantity(1);
			item.setBuyPrice(9800);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			break;
		case HYPER_POTION:
			item.setQuantity(1);
			item.setBuyPrice(1200);
			item.setSellPrice(600);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(200);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case IRON:
			item.setQuantity(1);
			item.setBuyPrice(9800);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			break;
		case LEMONADE:
			item.setQuantity(1);
			item.setBuyPrice(350);
			item.setSellPrice(175);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(80);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case MAX_ELIXIR:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(2250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			for(int i = 0; i < attacker.getMoves().size(); i++){
				effect.setEffectIndex(EffectType.PP_UP);
				effect.setEffectChance(100);
				effect.setMagnitude(attacker.getMove(i).getMaxPP());
				
				itemEffect.add(0, effect);
			}
			item.setItemEffect(itemEffect);
			break;
		case MAX_ETHER:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(1000);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.PP_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getMove(moveIndex).getMaxPP());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case MAX_POTION:
			item.setQuantity(1);
			item.setBuyPrice(2500);
			item.setSellPrice(1250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERFULL);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getStats().getMaxHp());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case MAX_REVIVE:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(2800);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERFULL);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getStats().getMaxHp());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case POTION:
			item.setQuantity(1);
			item.setBuyPrice(300);
			item.setSellPrice(150);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(20);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case PP_UP:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.PP_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getMove(moveIndex).getMaxPP() / 5 + attacker.getMove(moveIndex).getMaxPP());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case PROTEIN:
			item.setQuantity(1);
			item.setBuyPrice(9800);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			break;
		case RARE_CANDY:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(2400);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.LVL_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(1);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case REVIVAL_HERB:
			item.setQuantity(1);
			item.setBuyPrice(2800);
			item.setSellPrice(1400);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERFULL);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getStats().getMaxHp());
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case REVIVE:
			item.setQuantity(1);
			item.setBuyPrice(1500);
			item.setSellPrice(750);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERFULL);
			effect.setEffectChance(100);
			effect.setMagnitude(attacker.getStats().getMaxHp()/2);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case SODA_POP:
			item.setQuantity(1);
			item.setBuyPrice(300);
			item.setSellPrice(150);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(60);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case SUPER_POTION:
			item.setQuantity(1);
			item.setBuyPrice(700);
			item.setSellPrice(350);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			
			effect.setEffectIndex(EffectType.RECOVERCONST);
			effect.setEffectChance(100);
			effect.setMagnitude(50);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case X_ACCURACY:
			item.setQuantity(1);
			item.setBuyPrice(950);
			item.setSellPrice(475);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			
			effect.setEffectIndex(EffectType.STAT_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(1);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case X_ATTACK:
			item.setQuantity(1);
			item.setBuyPrice(500);
			item.setSellPrice(250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			
			effect.setEffectIndex(EffectType.STAT_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(2);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case X_DEFEND:
			item.setQuantity(1);
			item.setBuyPrice(550);
			item.setSellPrice(275);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			
			effect.setEffectIndex(EffectType.STAT_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(3);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case X_SPECIAL:
			item.setQuantity(1);
			item.setBuyPrice(350);
			item.setSellPrice(175);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			
			effect.setEffectIndex(EffectType.STAT_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(4);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case X_SPEED:
			item.setQuantity(1);
			item.setBuyPrice(350);
			item.setSellPrice(175);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			
			effect.setEffectIndex(EffectType.STAT_UP);
			effect.setEffectChance(100);
			effect.setMagnitude(5);
			
			itemEffect.add(0, effect);
			item.setItemEffect(itemEffect);
			break;
		case GREAT_BALL:
			item.setQuantity(1);
			item.setBuyPrice(600);
			item.setSellPrice(300);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			item.setCatchRate(1.5);
			break;
		case MASTER_BALL:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(0);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			item.setCatchRate(255);
			break;
		case POKE_BALL:
			item.setQuantity(1);
			item.setBuyPrice(200);
			item.setSellPrice(100);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			item.setCatchRate(1);
			break;
		case ULTRA_BALL:
			item.setQuantity(1);
			item.setBuyPrice(1200);
			item.setSellPrice(600);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			item.setCatchRate(2);
			break;
		default:
			break;
		}
		return item;
	}

}
