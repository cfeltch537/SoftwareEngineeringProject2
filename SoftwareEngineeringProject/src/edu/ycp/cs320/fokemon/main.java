
package edu.ycp.cs320.fokemon;

import java.io.IOException;
import edu.ycp.cs320.fokemon.Pokedex;

import GUI.TempGUI;
import GUI.TempMapPanel;

public class main {

	public static void main(String[] args){
		try {
			new TempGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pokedex test = new Pokedex();
		//test.toString();
		//TempGUI.main(null);
		//TempMapPanel tmp = new TempMapPanel();
		//tmp.repaint();
		test.pokeMap.get(34).printEntry();
	}

}

