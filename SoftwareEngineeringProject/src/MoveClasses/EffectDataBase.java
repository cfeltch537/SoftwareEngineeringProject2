package MoveClasses;

import java.util.ArrayList;
import java.util.Random;

import edu.ycp.cs320.fokemon.Pokemon;
import edu.ycp.cs320.fokemon.Status;



public class EffectDataBase {
	private static Random rand=new Random();
	private static int randomNum=0;
	private static int i=0;
	
	
	public static void moveEffect(Pokemon Attacker, Pokemon Defender, ArrayList <Effect> effect){
		for (i=0; i<effect.size(); i++){
			randomNum = rand.nextInt(100);
			
			if(effect.get(i).getEffectChance()>=randomNum){
			
				switch (effect.get(i).getEffectIndex()) {
		        case NONE: //no effect
		                 break;
		        case PARALYZE:  //Paralyzed
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.PRL);
		                 break;
		        case POISON:  //Poisoned
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.PSN);
		                 break;
		        case SLEEP:  //Sleep
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.SLP);
		                 break;	
		        case BURN:  //Burn
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.BRN);
		                 break;
		        case FREEZE:  //Freeze
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.FRZ);
		                 break;
		        case KO:  //Death
			        Defender.getStats().setCurHp(0);
		                 break;
		        case RECOVER:  //Recover
			        Defender.getStats().setCurHp(0);
		                 break;  
		        default: //no effect
		                 break;
				}
			
			}	
			
		}	

	}
	}


