package edu.ycp.cs320.fokemon_webApp.shared.GUI;

import java.util.LinkedList;

import com.google.gwt.user.client.ui.Image;

public enum Flooring {
	// Flooring Unblocked*******************************
	Grass(new Interaction[] { Interaction.MovementAllowed }, "Grass.png"), 
	Ground(new Interaction[] { Interaction.MovementAllowed }, null), 
	Sand(new Interaction[] { Interaction.MovementAllowed }, "Sand.png"),
	// Flooring Blocked*********************************
	Blocked_Grass(new Interaction[] { Interaction.MovementBlocked },"Grass.png"), 
	Blocked_Ground(	new Interaction[] { Interaction.MovementBlocked }, null), 
	Blocked_Sand(new Interaction[] { Interaction.MovementBlocked }, "Sand.png"),
	// Water Types**************************************
	FreshWater(new Interaction[] { Interaction.MovementBlocked },"FreshWater.png"), 
	SaltWater(new Interaction[] { Interaction.MovementBlocked }, "SaltWater.png"), 
	WoodFloor(new Interaction[] {}, "WoodFloor.png"), 
	Nothing(new Interaction[] {}, "Nothing.png");

	public LinkedList<Interaction> interactionList = new LinkedList<Interaction>();
	public String imageSource;
	public Image img;

	private Flooring(Interaction[] defaultInteraction, String imageSource) {
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