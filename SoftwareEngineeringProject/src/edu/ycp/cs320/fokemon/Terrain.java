package edu.ycp.cs320.fokemon;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Flooring;
import GUI.InteractableObject;
import GUI.InteractableObjectName;
import GUI.Interaction;
import GUI.Structure;

public class Terrain{
	
	public Flooring flooring;
	public Structure structure;
	public InteractableObject interactableObject;
	
	
	public Terrain(Flooring flooring, Structure structure, InteractableObject grassORobject, InteractableObject trainer, InteractableObject interactableObject, Object eventID){
		// This class will all of the necessary information for printing the map and reacting to event on spaces (i.e. trainer battles, grass, tall grass, buildings, rocks, etc.)
		
		this.flooring = flooring;
		this.structure = structure;
		this.interactableObject = interactableObject;
		
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
	
	public boolean isMovable(InteractableObject interactableObject){
		switch(interactableObject.interaction){
		case MovementAllowed: return true;
		case MovementBlocked: return false;
		default:
			return false;
		}
	}
	
}
