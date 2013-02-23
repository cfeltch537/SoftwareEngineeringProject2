package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;


public enum Flooring {
	//Flooring is the base of every area. It comprises only the simplest components
	Grass(".\\src\\TerrainImages/Grass.png"),
	Ground(null),
	Sand(".\\src\\TerrainImages/Sand.png");
	
	public Image img;
	private Flooring(String imgSource){
		if(imgSource!=null){
			this.img = new ImageIcon(imgSource).getImage();
		}

	}
}
