package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;

public enum InteractableObjectName {
	TallGrass(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass.png"),
	TallGrassLeftEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_LeftEdge.png"),
	TallGrassRightEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_RightEdge.png"),
	TallGrassLowerEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_LowerEdge.png"),
	TallGrassUpperEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_UpperEdge.png"),
	TallGrassUpperLeftEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_UpperLeftEdge.png"),
	TallGrassUpperRightEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_UpperRightEdge.png"),
	TallGrassLowerLeftEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_LowerLeftEdge.png"),
	TallGrassLowerRightEdge(Interaction.Battle_Wild, ".\\src/TerrainImages/TallGrass_LowerRightEdge.png"),
	Trainer(Interaction.Battle_Wild, "null");
	
	public Interaction interaction;
	public Image img;
	
	private InteractableObjectName(Interaction interaction, String imageSource) {
		this.interaction = interaction;
		this.img = new ImageIcon(imageSource).getImage();
	}
}