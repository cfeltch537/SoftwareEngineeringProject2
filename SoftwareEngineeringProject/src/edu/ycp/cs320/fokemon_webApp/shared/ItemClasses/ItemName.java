package edu.ycp.cs320.fokemon_webApp.shared.ItemClasses;

public enum ItemName {
	FRESH_WATER("Fresh Water"),
	SODA_POP("Soda Pop"),
	LEMONADE("Lemonade"),
	ETHER("Ether"),
	MAX_ETHER("Max Ether"),
	ELIXIR("Elixir"),
	MAX_ELIXIR("Max Elixir"),
	HEAL_POWDER("Heal Powder"),
	ENERGY_POWDER("Energy Powder"),
	ENERGY_ROOT("Energy Root"),
	REVIVAL_HERB("Revival Herb"),
	POTION("Potion"),
	SUPER_POTION("Super Potion"),
	HYPER_POTION("Hyper Potion"),
	MAX_POTION("Max Potion"),
	FULL_RESTORE("Full Restore"),
	REVIVE("Revive"),
	MAX_REVIVE("Max Revive"),
	HP_UP("HP Up"),
	PROTEIN("Potion"),
	IRON("Iron"),
	CALCIUM("Calcium"),
	CARBOS("Carbox"),
	PP_UP("PP Up"),
	RARE_CANDY("Rare Candy"),
	X_ATTACK("X Attack"),
	X_DEFEND("X Defend"),
	X_SPECIAL("X Special"),
	X_SPEED("X Speed"),
	X_ACCURACY("X Accuracy"),
	POKE_BALL("Poke Ball"),
	GREAT_BALL("Great Ball"),
	ULTRA_BALL("Ultra Ball"),
	MASTER_BALL("Master Ball");


	public String name;

	private ItemName(String itemName)	{
		this.name = itemName;
	}
}
