package edu.ycp.cs320.fokemon;

public class Location {
	private int AreaArrayIndex;
	private int x;
	private int y;
public Location(int AreaArrayIndexArea, int x, int y){
	this.AreaArrayIndex=AreaArrayIndex;
	this.x=x;
	this.y=y;
	}
int GetX(){
	return x;
}
void SetX(int x){
	this.x=x;
}
int GetY(){
	return y;
}
void SetY(int y){
	this.y=y;
}
int GetAreaArrayIndex(){
	return AreaArrayIndex;
}
void SetAreaArrayIndex(int AreaArrayIndex){
	this.AreaArrayIndex=AreaArrayIndex;
}

}
