package edu.ycp.cs320.fokemon;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Terrain{
	
	//Object[] layer = new Object[4];
	Flooring flooring;
	Structure structure;
	Stuff grassORobject;
	InteractionSpace interactionspaces;
	
	public Terrain(Flooring flooring, Structure structure, Stuff grassORobject, Stuff trainer, InteractionSpace interactionspaces, Object eventID){
		// This class will all of the necessary information for printing the map and reacting to event on spaces (i.e. trainer battles, grass, tall grass, buildings, rocks, etc.)
		
		this.flooring = flooring;
		this.structure = structure;
		this.grassORobject = grassORobject;
		this.interactionspaces = interactionspaces;
		
		
	}
	public Image getFlooringImage(){ // Returns the image for each flooring type
		
		switch(flooring){
			case Grass: return new ImageIcon(".\\src\\16x16_TerrainImages/Grass.png").getImage();
			case Water: return null;
			case Ground: return null;
			case Sand: return null;		
		}
		return null;
	}
	
}