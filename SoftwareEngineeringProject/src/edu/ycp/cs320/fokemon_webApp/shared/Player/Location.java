package edu.ycp.cs320.fokemon_webApp.shared.Player;

public class Location {
		private int AreaArrayIndex;
		private int x;
		private int y;
		
	public Location(int AreaArrayIndex, int x, int y){
		this.AreaArrayIndex=AreaArrayIndex;
		this.x=x;
		this.y=y;
		}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x=x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y=y;
	}
	public int getAreaArrayIndex(){
		return AreaArrayIndex;
	}
	public void setAreaArrayIndex(int AreaArrayIndex){
		this.AreaArrayIndex=AreaArrayIndex;
	}

}
