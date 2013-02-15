package edu.ycp.cs320.fokemon;

import java.io.IOException;

class main {

	public static void main(String[] args){
		System.out.println("hello");
		try {
			new TempGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TempGUI.main(null);
		TempMapPanel tmp = new TempMapPanel();
		//tmp.repaint();
	}

}

