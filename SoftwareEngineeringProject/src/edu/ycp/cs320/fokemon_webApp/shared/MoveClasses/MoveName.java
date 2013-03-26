package edu.ycp.cs320.fokemon_webApp.shared.MoveClasses;

public enum MoveName {
	Confused("Confused"),
	Tackle("Tackle"),
	Bite("Bite"),
	Ember("Ember"),
	Heal("Heal"),
	Spore("Spore"),
	Blizzard("Blizzard"),
	Acid("Acid"),
	Thunder_Wave("Thunder Wave");
	
	public String name;
	
	private MoveName(String moveName){
		this.name = moveName;
	}
}
