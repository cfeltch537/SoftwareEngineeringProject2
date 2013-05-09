package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.util.ArrayList;
import java.util.Random;
import edu.ycp.cs320.fokemon_webApp.client.FokemonUI;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Game;

import java.io.Serializable;


public class Pokemon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BattleStats stats;
	private PokeInfo info;
	private TempBattleStats tempBattleStats;
	private ArrayList<Move> moves;

	public Pokemon(PokeInfo info, BattleStats stats, ArrayList<Move> moves) {
		this.info = info;
		this.stats = stats;
		this.moves = moves;
	}
	
	public Pokemon(){
		this.info=null;
		this.stats=null;
		this.moves=null;
	}

	public static Pokemon GeneratePokemon(PokeID ID, int lvl) {
		Random rand = new Random();
		PokedexEntry entry = new PokedexEntry();
		entry = FokemonUI.getPokedex().getPokeMap().get(ID);
		boolean gender;
		if (rand.nextInt() % 2 == 0)
			gender = false;
		else
			gender = true;
		PokeInfo information = new PokeInfo(entry.getPokeID(), Game.getUser().getPlayerID(), entry.getPokeName(),
				entry.getPokeName(), gender, entry.getType(), lvl, 0,255, entry.getEvolution(),entry.getMoveList());
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int i=0;i<=lvl;i++){
			if(information.getMoveList().containsKey(i)){
				moves.add(MoveDataBase.generateMove(information.getMoveList().get(i)));
			}
		}
		
		BattleStats battleStats = new BattleStats(0, 0, 0, 0, 0, 0, 0,
				Status.NRM, entry.getBaseXP(), entry.getBaseStats(),
				entry.getEVyield());
		Pokemon pokemon = new Pokemon(information, battleStats, moves);
		pokemon.UpdateStats();
		pokemon.getStats().setCurHp(pokemon.getStats().getMaxHp());

		int xp = (int) Math.pow(pokemon.info.getLvl(), 3);
		pokemon.getInfo().setXp(xp);

		return pokemon;

	}

	public ArrayList<String> CheckLevelUp() {
		ArrayList<String> message = new ArrayList<String>();
		int xp = (int) Math.pow(info.getLvl() + 1, 3);
		if (xp < info.getXp())
			message.addAll(LevelUp());
		return message;
	}

	public ArrayList<String> LevelUp() {
		ArrayList<String> message = new ArrayList<String>();
		info.setLvl(info.getLvl() + 1);
		message.add(info.getNickname() + " has grown to level " + info.getLvl());
		CheckEvolve(message);
		CheckLearnMove(message);
		UpdateStats();
		return message;
	}

	public void UpdateStats() {
		UpdateHPStat();
		int stat;
		int IV = 0;
		int EV = 0;
		int Nature = 1;

		stat = ((IV + 2 * getStats().getBaseStats()[1] + EV / 4)
				* getInfo().getLvl() / 100 + 5)
				* Nature;
		getStats().setAtk(stat);

		stat = ((IV + 2 * getStats().getBaseStats()[2] + EV / 4)
				* getInfo().getLvl() / 100 + 5)
				* Nature;
		getStats().setDef(stat);

		stat = ((IV + 2 * getStats().getBaseStats()[3] + EV / 4)
				* getInfo().getLvl() / 100 + 5)
				* Nature;
		getStats().setSpAtk(stat);

		stat = ((IV + 2 * getStats().getBaseStats()[4] + EV / 4)
				* getInfo().getLvl() / 100 + 5)
				* Nature;
		getStats().setSpDef(stat);

		stat = ((IV + 2 * getStats().getBaseStats()[5] + EV / 4)
				* getInfo().getLvl() / 100 + 5)
				* Nature;
		getStats().setSpd(stat);
	}

	private void UpdateHPStat() {
		int max=getStats().getMaxHp();
		int HP;
		int IV = 0;
		int EV = 0;
		HP = (IV + 2 * getStats().getBaseStats()[0] + EV / 4 + 100)
				* getInfo().getLvl() / 100 + 10;
		getStats().setMaxHp(HP);
		getStats().setCurHp(getStats().getCurHp()+(HP-max));
		if(getStats().getCurHp()>getStats().getMaxHp()){
			getStats().setCurHp(getStats().getMaxHp());
		}

	}

	private void CheckLearnMove(ArrayList<String> message) {

		if(info.getMoveList().containsKey(info.getLvl())){
			moves.add(MoveDataBase.generateMove(info.getMoveList().get(info.getLvl())));
			message.add(info.getNickname() + " has learned " + info.getMoveList().get(info.getLvl()).toString());
		}

	}

	private void CheckEvolve(ArrayList<String> message) {
		if(info.getLvl()>info.getEvolution().lastKey()){
			Pokemon evo=Pokemon.GeneratePokemon(info.getEvolution().get(info.getEvolution().lastKey()), info.getLvl());
			info.setEvolution(evo.getInfo().getEvolution());
			info.setMoveList(evo.getInfo().getMoveList());
			evo.getStats().setCurHp(stats.getCurHp());
			stats=evo.getStats();
			info.setType(evo.getInfo().getType());
			//PokedexEntry entry = new PokedexEntry();
			//entry = FokemonUI.getPokedex().getPokeMap().get(info.getEvolution().get(info.getEvolution().lastKey()));
			message.add(info.getNickname() + " has evolved into " + evo.getInfo().getPokeName());
			//info.setEvolution(entry.getEvolution());
			//info.setMoveList(entry.getMoveList());
			//info.setType(entry.getType());
			if(info.getNickname()==info.getPokeName()){
				//info.setNickname(entry.getPokeName());
				info.setNickname(evo.getInfo().getPokeName());
			}
			//info.setID(entry.getPokeID());
			//info.setPokeName(entry.getPokeName());
			info.setID(evo.getInfo().getID());
			info.setPokeName(evo.getInfo().getPokeName());
			
			//BattleStats battleStats = new BattleStats(0, 0, 0, 0, 0, 0, 0,
				//	Status.NRM, entry.getBaseXP(), entry.getBaseStats(),
					//entry.getEVyield());
			//stats=battleStats;
			
		}

	}

	public BattleStats getStats() {
		return stats;
	}

	public void setStats(BattleStats stats) {
		this.stats = stats;
	}

	public PokeInfo getInfo() {
		return info;
	}

	public void setInfo(PokeInfo info) {
		this.info = info;
	}

	public TempBattleStats getTempBattleStats() {
		return tempBattleStats;
	}

	public void setTempBattleStats(TempBattleStats tempBattleStats) {
		this.tempBattleStats = tempBattleStats;
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}

	public Move getMove(int index) {
		return moves.get(index);
	}
}
