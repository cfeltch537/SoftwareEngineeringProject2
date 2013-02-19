package edu.ycp.cs320.fokemon;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Flooring;
import GUI.InteractionSpace;
import GUI.Structure;
import GUI.Stuff;

public class Terrain{
	
	//Object[] layer = new Object[4];
	Flooring flooring;
	Structure structure;
	Stuff grassOrObject;
	InteractionSpace interactionspaces;
	
	public Terrain(Flooring flooring, Structure structure, Stuff grassORobject, Stuff trainer, InteractionSpace interactionspaces, Object eventID){
		// This class will all of the necessary information for printing the map and reacting to event on spaces (i.e. trainer battles, grass, tall grass, buildings, rocks, etc.)
		
		this.flooring = flooring;
		this.structure = structure;
		this.grassOrObject = grassORobject;
		this.interactionspaces = interactionspaces;
		
		
	}
	
	public Image getFlooringImage(){ // Returns the image for each flooring type
		if(flooring==null){
			return null;
		}
		switch(flooring){
			case Grass: return new ImageIcon(".\\src\\TerrainImages/Grass.png").getImage();
			case Water: return null;
			case Ground: return null;
			case Sand: return null;		
		}
		return null;
	}
	
	public Image getGrassORobjectImage(){ // Returns the image for each grass or object type
		if(grassOrObject==null){
			return null;
		}
		switch(grassOrObject){
			case TallGrass: return new ImageIcon(".\\src/TerrainImages/TallGrass.png").getImage();
			case TallGrassLeftEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_LeftEdge.png").getImage();
			case TallGrassRightEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_RightEdge.png").getImage();
			case TallGrassLowerEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_LowerEdge.png").getImage();
			case TallGrassUpperEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_UpperEdge.png").getImage();
			case TallGrassUpperRightEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_UpperRightEdge.png").getImage();
			case TallGrassLowerRightEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_LowerRightEdge.png").getImage();
			case TallGrassLowerLeftEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_LowerLeftEdge.png").getImage();
			case TallGrassUpperLeftEdge: return new ImageIcon(".\\src/TerrainImages/TallGrass_UpperLeftEdge.png").getImage();
		default:
			break;	
		}
		return null;
	}
	
	public void setGrassORobject(Stuff stuff){
		grassOrObject = stuff;
	}
}
