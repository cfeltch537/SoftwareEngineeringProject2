package edu.ycp.cs320.fokemon_webApp.shared.Battle;

public enum TurnChoice 
{
	MOVE (1),
	ITEM (2),
	SWITCH (3),
	RUN (4);
	
	//TMP: added the inteer values to allow database storing easily
	
	private final int index;   

    private TurnChoice(int index) {
        this.index = index;
    }

    public int index() { 
        return index; 
    }
}
