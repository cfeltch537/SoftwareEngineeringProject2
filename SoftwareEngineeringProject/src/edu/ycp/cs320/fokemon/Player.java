package edu.ycp.cs320.fokemon;

public class Player {
	private String name;
	private boolean gender;
	
	public Player(String nName, boolean nGender){
		setName(nName);
		setGender(nGender);
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
