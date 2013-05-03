package edu.ycp.cs320.fokemon_webApp.shared.GUI;

import java.util.LinkedList;

import com.google.gwt.user.client.ui.Image;

public enum InteractableObject {
	Default(new Interaction[] {}, null),
	// Tall Grass Types********************************
	TallGrass(new Interaction[] { Interaction.Battle_Wild,
			Interaction.TallGrass }, "TallGrass.png"), 
	TallGrassLeftEdge(
			new Interaction[] { Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_LeftEdge.png"), 
	TallGrassRightEdge(
			new Interaction[] {	Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_RightEdge.png"), 
	TallGrassLowerEdge(
			new Interaction[] {	Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_LowerEdge.png"), 
	TallGrassUpperEdge(
			new Interaction[] {	Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_UpperEdge.png"), 
	TallGrassUpperLeftEdge(
			new Interaction[] { Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_UpperLeftEdge.png"), 
	TallGrassUpperRightEdge(
			new Interaction[] { Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_UpperRightEdge.png"), 
	TallGrassLowerLeftEdge(
			new Interaction[] { Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_LowerLeftEdge.png"), 
	TallGrassLowerRightEdge(
			new Interaction[] { Interaction.Battle_Wild, Interaction.TallGrass },
			"TallGrass_LowerRightEdge.png"),
	// Structures***************************************
	PokeCenter(new Interaction[] { Interaction.MovementBlocked },
			"PokeCenter.png"),
	HealingSpace(new Interaction[] { Interaction.HealAll },
			"PinkFlowers.png"), //Created to prompt for healing of pokemon
	PC(new Interaction[] { Interaction.MovementBlocked },
					"PC.png"),
	PCexchange(new Interaction[] { Interaction.EnterPCview },
			"PinkFlowers.png"),
	Trainer(new Interaction[] { Interaction.Battle_Wild }, null);
	// InteractableFlooring*****************************

	public LinkedList<Interaction> interactionList = new LinkedList<Interaction>();
	public String imageSource;
	public Image img;

	private InteractableObject(Interaction[] defaultInteraction,
			String imageSource) {
		// This constructor add the default interactions and image to the
		// terrain
		// Default interactions are interactions inherit to the Object
		// Ex: Battling Wild Pokemon in tall grass, or not being able move onto
		// rocks or buildings
		for (int i = 0; i < defaultInteraction.length; i++) {
			if (defaultInteraction[i] != null) {
				this.interactionList.add(defaultInteraction[i]);
			}
		}
		// ^ As long as the default interaction is not 'null' add to
		// interactionList
		if (imageSource != null) {
			this.imageSource = imageSource;
			this.img = new Image("TerrainImages/" + imageSource);
		}
		// ^Try to set object image; catch null pointer exceptions
	}
	// ^Can be used to add additional interactions to an intractable object; if
	// necessary
}