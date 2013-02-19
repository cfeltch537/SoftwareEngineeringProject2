package MoveClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon.PokeType;
import edu.ycp.cs320.fokemon.Pokemon;
import edu.ycp.cs320.fokemon.Status;

public class MoveDataBase {
	static ArrayList <Effect> effectList;
	static Effect effect;
	
	public static Move createMove(MoveName moveName){
		effectList.clear();
		effect=new Effect(EffectType.NONE,0,0);
		effectList.add(effect);
		Move move=new Move(0, 0, effectList, 100, moveName, 0, PokeType.NORMAL);
		
		
		switch (moveName) {
        case Tackle: 
        	effect.add(EffectType.NONE);
                 break;
        default: //no effect
                 break;
		}
		return move;
		
	}
}
