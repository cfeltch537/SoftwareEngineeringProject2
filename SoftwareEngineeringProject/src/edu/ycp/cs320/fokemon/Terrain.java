package edu.ycp.cs320.fokemon;

import java.util.LinkedList;
import GUI.Flooring;
import GUI.InteractableObject;
import GUI.Interaction;

public class Terrain{
	
	public Flooring flooring; //The lowest level of each terrain. Not interactable.
	public LinkedList<InteractableObject> interactableObjectList = new LinkedList<InteractableObject>();;
	//^InteractableObjects can include everything from Trainers, TallGrass, Structures etc.
	//Each interactableObject contains a list of interactions and associated image (if applicable)
	
	public Terrain(Flooring flooring, InteractableObject[] interactableObjects){
		this.flooring = flooring;
		//^Sets Flooring
		if(interactableObjects!=null){
			for(int i=0; i<interactableObjects.length;i++){
				if(interactableObjects[i]!=null){
					this.interactableObjectList.add(interactableObjects[i]);
				}
			}
		}
		//^Try to set object image; catch null pointer exceptions
	}
	//^Constructor. Sets flooring of each terrain space in the area
	//Interactable objects can be added here too, but don't need to be
	public boolean isMovable(InteractableObject interactableObject){
		for(int i=0; i<this.interactableObjectList.size();i++){
			for(int j=0; i<this.interactableObjectList.get(i).interactionList.size();i++){
				if(this.interactableObjectList.get(i).interactionList.get(j).equals(Interaction.MovementBlocked)){
					return false;
				}
			}
		}
		return true;
	}
	//^isMovable returns true when the player can move to the terrain location
	//i.e. it does not contain a 'MovementBlocked' Interaction
}
