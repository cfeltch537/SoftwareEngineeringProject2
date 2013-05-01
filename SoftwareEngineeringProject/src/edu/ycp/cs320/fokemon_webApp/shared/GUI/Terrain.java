package edu.ycp.cs320.fokemon_webApp.shared.GUI;

import java.util.LinkedList;

public class Terrain {

	public Flooring flooring; // The lowest level of each terrain. Not
								// interactable.
	public LinkedList<InteractableObject> interactableObjectList = new LinkedList<InteractableObject>();;

	// ^InteractableObjects can include everything from Trainers, TallGrass,
	// Structures etc.
	// Each interactableObject contains a list of interactions and associated
	// image (if applicable)

	public Terrain(Flooring flooring, InteractableObject[] interactableObjects) {
		this.flooring = flooring;
		// ^Sets Flooring
		if (interactableObjects != null) {
			for (int i = 0; i < interactableObjects.length; i++) {
				if (interactableObjects[i] != null) {
					this.interactableObjectList.add(interactableObjects[i]);
				}
			}
		}
		// ^Try to set object image; catch null pointer exceptions
	}

	// ^Constructor. Sets flooring of each terrain space in the area
	// Interactable objects can be added here too, but don't need to be
	public boolean isMovable() {
		return !this.flooring.interactionList
				.contains(Interaction.MovementBlocked);
	}

	public boolean isTallGrassPresent() {

		for (int i = 0; i < this.interactableObjectList.size(); i++) {
			if (this.interactableObjectList.get(i).interactionList
					.contains(Interaction.TallGrass)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isWildPokemon() {

		for (int i = 0; i < this.interactableObjectList.size(); i++) {
			if (this.interactableObjectList.get(i).interactionList
					.contains(Interaction.Battle_Wild)) {
				return true;
			}
		}
		return false;
	}
	public boolean isHealAllSpace() {

		for (int i = 0; i < this.interactableObjectList.size(); i++) {
			if (this.interactableObjectList.get(i).interactionList
					.contains(Interaction.HealAll)) {
				return true;
			}
		}
		return false;
	}

	// ^isMovable returns true when the player can move to the terrain location
	// i.e. it does not contain a 'MovementBlocked' Interaction
	public void blockMovement() {
		switch (flooring) {
		case Grass:
			this.flooring = Flooring.Blocked_Grass;
			break;
		case Ground:
			this.flooring = Flooring.Blocked_Ground;
			break;
		case Sand:
			this.flooring = Flooring.Blocked_Sand;
			break;
		default:
			break;
		}
	}
}
