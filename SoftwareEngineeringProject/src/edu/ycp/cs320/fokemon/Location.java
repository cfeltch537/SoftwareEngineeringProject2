package edu.ycp.cs320.fokemon;

public class Location {
	private int AreaArrayIndex;
	private int x;
	private int y;
	
	public Location(int AreaArrayIndex, int x, int y){
		this.AreaArrayIndex = AreaArrayIndex;
		this.x = x;
		this.y = y;
	}
	
	public int GetX(){
		return x;
	}
	
	public void SetX(int x){
		this.x = x;
	}
	
	public int GetY(){
		return y;
	}
	
	public void SetY(int y){
		this.y = y;
	}
	
	public int GetAreaArrayIndex(){
		return AreaArrayIndex;
	}
	
	public void SetAreaArrayIndex(int AreaArrayIndex){
		this.AreaArrayIndex = AreaArrayIndex;
	}
}
