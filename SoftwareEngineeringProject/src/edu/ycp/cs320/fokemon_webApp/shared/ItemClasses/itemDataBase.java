package edu.ycp.cs320.fokemon_webApp.shared.ItemClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class itemDataBase {
	public static void itemEffect(Pokemon poke, ArrayList<Item> item)	{
		for(int i = 0; i < item.size(); i++)	{
			item.get(i).setItemText("");
			
			switch(item.get(i).getItemName())	{
			case NONE:
				break;
			case ELIXIR:
				item.get(i).setBuyPrice(0);
				item.get(i).setSellPrice(600);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				for(int j = 0; j < poke.getMoves().size(); j++)	{
					if(poke.getMove(j).getCurPP() + 10 > poke.getMove(j).getMaxPP())	{
						poke.getMove(j).setCurPP(poke.getMove(j).getMaxPP());
					}	else	{
						poke.getMove(j).setCurPP(poke.getMove(j).getCurPP() + 10);
					}
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s PP was restored by 10 on all moves");
				break;
			case ENERGY_POWDER:
				item.get(i).setBuyPrice(500);
				item.get(i).setSellPrice(250);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 50 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 50);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was restored by 50");
				break;
			case ENERGY_ROOT:
				item.get(i).setBuyPrice(800);
				item.get(i).setSellPrice(400);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 200 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 200);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was restored by 200");
				break;
			case ETHER:
				item.get(i).setBuyPrice(0);
				item.get(i).setSellPrice(1500);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getMove(i).getCurPP() + 10 > poke.getMove(i).getMaxPP())	{
					poke.getMove(i).setCurPP(poke.getMove(i).getMaxPP());
				}	else	{
					poke.getMove(i).setCurPP(poke.getMove(i).getCurPP() + 10);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s PP was restored by 10");
				break;
			case FRESH_WATER:
				item.get(i).setBuyPrice(200);
				item.get(i).setSellPrice(100);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 50 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 50);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was increased by 50");
				break;
			case FULL_RESTORE:
				item.get(i).setBuyPrice(3000);
				item.get(i).setSellPrice(1500);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				poke.getStats().setCurHp(poke.getStats().getMaxHp());
				poke.getStats().setStatus(Status.NRM);
				item.get(i).setItemText(poke.getInfo().getNickname() + "was restored to normal and full HP");
				break;
			case HEAL_POWDER:
				item.get(i).setBuyPrice(450);
				item.get(i).setSellPrice(225);
				item.get(i).setUseInBattle(true);			
				item.get(i).setUseOutOfBattle(true);
				poke.getStats().setStatus(Status.NRM);
				item.get(i).setItemText(poke.getInfo().getNickname() + " was restored to normal");
				break;
			case HYPER_POTION:
				item.get(i).setBuyPrice(1200);
				item.get(i).setSellPrice(600);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 200 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 200);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was increased by 200");
				break;
			case LEMONADE:
				item.get(i).setBuyPrice(350);
				item.get(i).setSellPrice(170);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 80 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 80);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was increased by 80");
				break;
			case MAX_ELIXIR:
				item.get(i).setBuyPrice(0);
				item.get(i).setSellPrice(2250);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				for(int j = 0; j < poke.getMoves().size(); j++)	{
					poke.getMove(j).setCurPP(poke.getMove(j).getMaxPP());
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s PP was restored to the max on all moves");
				break;
			case MAX_ETHER:
				item.get(i).setBuyPrice(0);
				item.get(i).setSellPrice(1000);
				item.get(i).setUseInBattle(true);
				poke.getMove(i).setCurPP(poke.getMove(i).getMaxPP());
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s PP was restored to the max");
				break;	
			case MAX_POTION:
				item.get(i).setBuyPrice(2500);
				item.get(i).setSellPrice(1250);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				poke.getStats().setCurHp(poke.getStats().getMaxHp());
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was restored to full");
				break;
			case MAX_REVIVE:
				item.get(i).setBuyPrice(0);
				item.get(i).setSellPrice(2000);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				poke.getStats().setStatus(Status.NRM);
				poke.getStats().setCurHp(poke.getStats().getMaxHp());
				item.get(i).setItemText(poke.getInfo().getNickname() + "was restored to normal and full HP");
				break;
			case POTION:
				item.get(i).setBuyPrice(300);
				item.get(i).setSellPrice(150);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 20 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 20);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was increased by 20");
				break;
			case REVIVAL_HERB:
				item.get(i).setBuyPrice(2800);
				item.get(i).setSellPrice(1400);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				poke.getStats().setStatus(Status.NRM);
				poke.getStats().setCurHp(poke.getStats().getMaxHp());
				item.get(i).setItemText(poke.getInfo().getNickname() + " was restored to normal and max HP");
				break;
			case REVIVE:
				item.get(i).setBuyPrice(1500);
				item.get(i).setSellPrice(750);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				poke.getStats().setStatus(Status.NRM);
				poke.getStats().setCurHp(poke.getStats().getMaxHp()/2);
				item.get(i).setItemText(poke.getInfo().getNickname() + "was restored to normal and half HP");
				break;
			case SODA_POP:
				item.get(i).setBuyPrice(300);
				item.get(i).setSellPrice(150);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 60 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 60);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was increased by 60");
				break;
			case SUPER_POTION:
				item.get(i).setBuyPrice(700);
				item.get(i).setSellPrice(350);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				if(poke.getStats().getCurHp() + 50 > poke.getStats().getMaxHp())	{
					poke.getStats().setCurHp(poke.getStats().getMaxHp());
				}	else	{
					poke.getStats().setCurHp(poke.getStats().getCurHp() + 50);
				}
				item.get(i).setItemText(poke.getInfo().getNickname() + "'s HP was increased by 50");
				break;
			case CALCIUM:	//effect not implemented yet
				item.get(i).setBuyPrice(9800);
				item.get(i).setSellPrice(4900);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				break;
			case HP_UP:		//effect not implemented yet
				item.get(i).setBuyPrice(9800);
				item.get(i).setSellPrice(4900);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				break;
			case IRON:		//effect not implemented yet
				item.get(i).setBuyPrice(9800);
				item.get(i).setSellPrice(4900);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				break;
			case PROTEIN:	//effect not implemented yet
				item.get(i).setBuyPrice(9800);
				item.get(i).setSellPrice(4900);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(true);
				break;
			case X_ATTACK:	//effect not implemented yet
				item.get(i).setBuyPrice(500);
				item.get(i).setSellPrice(250);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(false);
				break;
			case X_DEFEND:	//effect not implemented yet
				item.get(i).setBuyPrice(550);
				item.get(i).setSellPrice(275);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(false);
				break;
			case X_SPECIAL:	//effect not implemented yet
				item.get(i).setBuyPrice(350);
				item.get(i).setSellPrice(175);
				item.get(i).setUseInBattle(true);
				item.get(i).setUseOutOfBattle(false);
				break;
			}
		}
	}
}
