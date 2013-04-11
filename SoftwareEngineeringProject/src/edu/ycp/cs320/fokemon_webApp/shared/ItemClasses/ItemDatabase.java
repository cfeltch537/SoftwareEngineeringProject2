package edu.ycp.cs320.fokemon_webApp.shared.ItemClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.EffectType;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class ItemDatabase {
	public static Item generateItem(ItemName itemName, Pokemon attacker, ArrayList<Effect> effect, int moveIndex)	{
		ArrayList<Effect> effectList = new ArrayList<Effect>();
		Effect itemEffect = new Effect(EffectType.NONE,0,0,"");
		effectList.add(itemEffect);
		Item item = new Item(0, 0, false, false, itemName, effectList);

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
				if(attacker.getMove(i).getCurPP() + 10 > attacker.getMove(i).getMaxPP())	{
					attacker.getMove(i).setCurPP(attacker.getMove(i).getMaxPP());
				}	else 	{
					attacker.getMove(i).setCurPP(attacker.getMove(i).getCurPP() + 10);
				}
			}
			break;
		case ENERGY_POWDER:
			item.setQuantity(1);
			item.setBuyPrice(500);
			item.setSellPrice(250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getCurHp() + 50 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 50);
			}
			break;
		case ENERGY_ROOT:
			item.setQuantity(1);
			item.setBuyPrice(800);
			item.setSellPrice(400);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getCurHp() + 200 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 200);
			}
			break;
		case ETHER:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(600);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getMove(moveIndex).getCurPP() + 10 > attacker.getMove(moveIndex).getMaxPP())	{
				attacker.getMove(moveIndex).setCurPP(attacker.getMove(moveIndex).getMaxPP());
			}	else 	{
				attacker.getMove(moveIndex).setCurPP(attacker.getMove(moveIndex).getCurPP() + 10);
			}
			break;
		case FRESH_WATER:
			item.setQuantity(1);
			item.setBuyPrice(200);
			item.setSellPrice(100);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getCurHp() + 50 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 50);
			}
			break;
		case FULL_RESTORE:
			item.setQuantity(1);
			item.setBuyPrice(3000);
			item.setSellPrice(1500);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getStatus() != Status.FNT)	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
				attacker.getStats().setStatus(Status.NRM);
			}	else 	{
				break;
			}
			break;
		case HEAL_POWDER:
			item.setQuantity(1);
			item.setBuyPrice(450);
			item.setSellPrice(225);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getStatus() != Status.FNT)	{
				attacker.getStats().setStatus(Status.NRM);
			}	else 	{
				break;
			}
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
			if(attacker.getStats().getCurHp() + 200 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 200);
			}
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
			if(attacker.getStats().getCurHp() + 80 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 80);
			}
			break;
		case MAX_ELIXIR:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(2250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			for(int i = 0; i < attacker.getMoves().size(); i++){
				attacker.getMove(i).setCurPP(attacker.getMove(i).getMaxPP());
			}
			break;
		case MAX_ETHER:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(1000);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			attacker.getMove(moveIndex).setCurPP(attacker.getMove(moveIndex).getMaxPP());
			break;
		case MAX_POTION:
			item.setQuantity(1);
			item.setBuyPrice(2500);
			item.setSellPrice(1250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			break;
		case MAX_REVIVE:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(2800);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getStatus() == Status.FNT)	{
				attacker.getStats().setStatus(Status.NRM);
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				break;
			}
			break;
		case POTION:
			item.setQuantity(1);
			item.setBuyPrice(300);
			item.setSellPrice(150);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getCurHp() + 20 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 20);
			}
			break;
		case PP_UP:
			item.setQuantity(1);
			item.setBuyPrice(0);
			item.setSellPrice(4900);
			item.setUseInBattle(false);
			item.setUseOutOfBattle(true);
			if(attacker.getMove(moveIndex).getCurPP() + attacker.getMove(moveIndex).getMaxPP() / 5 > attacker.getMove(moveIndex).getMaxPP())	{
				attacker.getMove(moveIndex).setCurPP(attacker.getMove(moveIndex).getMaxPP());
			}	else 	{
				attacker.getMove(moveIndex).setCurPP(attacker.getMove(moveIndex).getCurPP() + attacker.getMove(moveIndex).getMaxPP() / 5);
			}
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
			if(attacker.getInfo().getLvl() + 1 <= 100)	{
				attacker.getInfo().setLvl(attacker.getInfo().getLvl() + 1);
			}	else 	{
				break;
			}
			break;
		case REVIVAL_HERB:
			item.setQuantity(1);
			item.setBuyPrice(2800);
			item.setSellPrice(1400);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getStatus() == Status.FNT)	{
				attacker.getStats().setStatus(Status.NRM);
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				break;
			}
			break;
		case REVIVE:
			item.setQuantity(1);
			item.setBuyPrice(1500);
			item.setSellPrice(750);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getStatus() == Status.FNT)	{
				attacker.getStats().setStatus(Status.NRM);
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp()/2);
			}	else 	{
				break;
			}
			break;
		case SODA_POP:
			item.setQuantity(1);
			item.setBuyPrice(300);
			item.setSellPrice(150);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getCurHp() + 60 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 60);
			}
			break;
		case SUPER_POTION:
			item.setQuantity(1);
			item.setBuyPrice(700);
			item.setSellPrice(350);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(true);
			if(attacker.getStats().getCurHp() + 50 > attacker.getStats().getMaxHp())	{
				attacker.getStats().setCurHp(attacker.getStats().getMaxHp());
			}	else 	{
				attacker.getStats().setCurHp(attacker.getStats().getCurHp() + 50);
			}
			break;
		case X_ACCURACY:
			item.setQuantity(1);
			item.setBuyPrice(950);
			item.setSellPrice(475);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			attacker.getTempBattleStats().setACCBoost(attacker.getTempBattleStats().getACCBoost() + 1);
			break;
		case X_ATTACK:
			item.setQuantity(1);
			item.setBuyPrice(500);
			item.setSellPrice(250);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			attacker.getTempBattleStats().setATKBoost(attacker.getTempBattleStats().getATKBoost() + 1);
			break;
		case X_DEFEND:
			item.setQuantity(1);
			item.setBuyPrice(550);
			item.setSellPrice(275);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			attacker.getTempBattleStats().setDEFBoost(attacker.getTempBattleStats().getDEFBoost() + 1);
			break;
		case X_SPECIAL:
			item.setQuantity(1);
			item.setBuyPrice(350);
			item.setSellPrice(175);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			attacker.getTempBattleStats().setSPATKBoost(attacker.getTempBattleStats().getSPATKBoost() + 1);
			break;
		case X_SPEED:
			item.setQuantity(1);
			item.setBuyPrice(350);
			item.setSellPrice(175);
			item.setUseInBattle(true);
			item.setUseOutOfBattle(false);
			attacker.getTempBattleStats().setSPDBoost(attacker.getTempBattleStats().getSPDBoost() + 1);
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
