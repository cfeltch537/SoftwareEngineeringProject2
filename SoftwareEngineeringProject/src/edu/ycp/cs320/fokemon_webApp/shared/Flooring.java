package edu.ycp.cs320.fokemon_webApp.shared;

import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;


public enum Flooring {
	//Flooring Unblocked*******************************
	Grass(new Interaction[]{Interaction.MovementAllowed},".\\src\\TerrainImages/Grass.png"),
	Ground(new Interaction[]{Interaction.MovementAllowed},null),
	Sand(new Interaction[]{Interaction.MovementAllowed},".\\src\\TerrainImages/Sand.png"),
	//Flooring Blocked*********************************
	Blocked_Grass(new Interaction[]{Interaction.MovementBlocked},".\\src\\TerrainImages/Grass.png"),
	Blocked_Ground(new Interaction[]{Interaction.MovementBlocked},null),
	Blocked_Sand(new Interaction[]{Interaction.MovementBlocked},".\\src\\TerrainImages/Sand.png"),
	//Water Types**************************************
	FreshWater(new Interaction[] {Interaction.MovementBlocked}, ".\\src/TerrainImages/FreshWater.png"),
	SaltWater(new Interaction[] {Interaction.MovementBlocked}, ".\\src/TerrainImages/SaltWater.png");
	
	public LinkedList<Interaction> interactionList = new LinkedList<Interaction>();
	public String imageSource;
	public Image img;
	
	private Flooring(Interaction[] defaultInteraction, String imageSource) {
		//This constructor add the default interactions and image to the terrain
		//Default interactions are interactions inherit to the Object
		//Ex: Battling Wild Pokemon in tall grass, or not being able move onto rocks or buildings
		for(int i=0; i<defaultInteraction.length;i++){
			if(defaultInteraction[i]!=null){
				this.interactionList.add(defaultInteraction[i]);
			}
		}
		//^ As long as the default interaction is not 'null' add to interactionList
		if(imageSource!=null){
			this.imageSource = imageSource;
			this.img = new ImageIcon(imageSource).getImage();
		}
		//^Try to set object image; catch null pointer exceptions
	}
	//^Can be used to add additional interactions to an intractable object; if necessary

}