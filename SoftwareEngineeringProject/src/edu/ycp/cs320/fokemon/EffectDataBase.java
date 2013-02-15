package edu.ycp.cs320.fokemon;

import java.util.Random;

public class EffectDataBase {
	private static Random rand=new Random();
	private static int randomNum=0;
	
	
	public static void moveEffect(Pokemon Attacker, Pokemon Defender, int EffectIndex, int EffectChance, int Magnitude){
		
		
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		randomNum = rand.nextInt(100);
		
		switch (EffectIndex) {
        case 1: //no effect
                 break;
        case 2:  //Paralyzed
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.PRL);
                 break;
        case 3:  //Poisoned
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.PSN);
                 break;
        case 4:  //Sleep
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.SLP);
                 break;	
        case 5:  //Burn
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.BRN);
                 break;
        case 6:  //Freeze
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.FRZ);
                 break;
        case 7:  //Death
        	if(EffectChance>=randomNum)
	        Defender.getStats().setCurHp(0);
                 break;
        case 8:  //Recover
        	if(EffectChance>=randomNum)
	        Defender.getStats().setCurHp(0);
                 break;
                 
                 

        default: //no effect
                 break;
    }
		
		
		
		

	
	}

}
