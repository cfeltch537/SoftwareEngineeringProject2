package edu.ycp.cs320.fokemon_webApp.shared.MoveClasses;

import java.util.ArrayList;
import java.util.Random;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class EffectDataBase {
	private static Random rand = new Random();

	public static ArrayList<String> moveEffect(Pokemon Attacker,
			Pokemon Defender, ArrayList<Effect> effect) {
		int randomNum = 0;
		ArrayList<String> battleMessage = new ArrayList<String>();
		for (int i = 0; i < effect.size(); i++) {
			randomNum = rand.nextInt(100);
			effect.get(i).setEffectText("");
			if (effect.get(i).getEffectChance() >= randomNum) {

				switch (effect.get(i).getEffectIndex()) {
				case NONE: // no effect
					break;
				case PARALYZE: // Paralyzed
					if (Defender.getStats().getStatus() == Status.NRM) {
						Defender.getStats().setStatus(Status.PRL);
						battleMessage.add(Defender.getInfo().getNickname()
								+ " was paralyzed.  ");
					}
					break;
				case POISON: // Poisoned
					if (Defender.getStats().getStatus() == Status.NRM) {
						Defender.getStats().setStatus(Status.PSN);
						battleMessage.add(Defender.getInfo().getNickname()
								+ " was poisoned.  ");
					}
					break;
				case SLEEP: // Sleep
					if (Defender.getStats().getStatus() == Status.NRM) {
						Defender.getStats().setStatus(Status.SLP);
						// Defender.getTempBattleStats().setSLPCount(effect.get(i).getMagnitude());
						Defender.getStats().setSLPCount(rand.nextInt(2) + 2);
						battleMessage.add(Defender.getInfo().getNickname()
								+ " fell asleep.  ");
					}
					break;
				case BURN: // Burn
					if (Defender.getStats().getStatus() == Status.NRM) {
						Defender.getStats().setStatus(Status.BRN);
						battleMessage.add(Defender.getInfo().getNickname()
								+ " was burned.  ");
					}
					break;
				case FREEZE: // Freeze
					if (Defender.getStats().getStatus() == Status.NRM) {
						Defender.getStats().setStatus(Status.FRZ);
						battleMessage.add(Defender.getInfo().getNickname()
								+ " was frozen solid.  ");
					}
					break;
				case KO: // Death
					Defender.getStats().setCurHp(0);
					battleMessage.add(Defender.getInfo().getNickname()
							+ " was One-Hit KOed.  ");
					break;
				case RECOVERCONST: // RecoverConstant HP
					if (Attacker.getStats().getCurHp()
							+ effect.get(i).getMagnitude() > Attacker
							.getStats().getMaxHp()) {
						Attacker.getStats().setCurHp(
								Attacker.getStats().getMaxHp());
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s HP was set to the maximum");
					} else {
						Attacker.getStats().setCurHp(
								Attacker.getStats().getCurHp()
										+ effect.get(i).getMagnitude());
						battleMessage.add(Attacker.getInfo().getNickname()
								+ " has recovered HP.  ");
					}
					break;
				case RECOVERFULL:
					if (Attacker.getStats().getStatus() != Status.FNT) {
						Attacker.getStats().setStatus(Status.NRM);
						Attacker.getStats().setCurHp(
								Attacker.getStats().getMaxHp());
						battleMessage
								.add(Attacker.getInfo().getNickname()
										+ " has recovered full HP and is back to normal. ");
					} else {
						battleMessage
								.add(Attacker.getInfo().getNickname()
										+ " nothing happened because they were fainted. ");
					}
					break;
				case PP_UP:
					Attacker.getMove(i).setCurPP(effect.get(i).getMagnitude());
					battleMessage.add(Attacker.getInfo().getNickname()
							+ " has recoverd some  PP. ");
					break;
				case LVL_UP:
					Attacker.getInfo().setXp((int)Math.pow(Attacker.getInfo().getLvl() + 1, 3));
					battleMessage.addAll(Attacker.LevelUp());
					/*if (Attacker.getInfo().getLvl() + 1 <= 100) {
						Attacker.getInfo().setLvl(
								Attacker.getInfo().getLvl()
										+ effect.get(i).getMagnitude());
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s level was increased by 1");
					} else {
						battleMessage.add(Attacker.getInfo().getNickname()
								+ " is already at the maximum level");
					}*/
					break;
				case FLINCH: // RecoverConstant HP
					Defender.getTempBattleStats().setFlinched(true);
					break;
				case STAT_UP:
					if (effect.get(i).getMagnitude() == 1) {
						Attacker.getTempBattleStats()
								.setACCBoost(
										Attacker.getTempBattleStats()
												.getACCBoost() + 1);
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s accuracy was increased by 1");
					} else if (effect.get(i).getMagnitude() == 2) {
						Attacker.getTempBattleStats()
								.setATKBoost(
										Attacker.getTempBattleStats()
												.getATKBoost() + 1);
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s attack was increased by 1");
					} else if (effect.get(i).getMagnitude() == 3) {
						Attacker.getTempBattleStats()
								.setDEFBoost(
										Attacker.getTempBattleStats()
												.getDEFBoost() + 1);
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s defense was increased by 1");
					} else if (effect.get(i).getMagnitude() == 4) {
						Attacker.getTempBattleStats()
								.setSPATKBoost(
										Attacker.getTempBattleStats()
												.getSPATKBoost() + 1);
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s special attack was increased by 1");
					} else if (effect.get(i).getMagnitude() == 5) {
						Attacker.getTempBattleStats()
								.setSPDBoost(
										Attacker.getTempBattleStats()
												.getSPDBoost() + 1);
						battleMessage.add(Attacker.getInfo().getNickname()
								+ "'s speed was increased by 1");
					}
				default: // no effect
					break;
				}

			}

		}
		return battleMessage;

	}
}