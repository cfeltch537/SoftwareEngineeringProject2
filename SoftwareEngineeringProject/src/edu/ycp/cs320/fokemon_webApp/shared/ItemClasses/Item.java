package edu.ycp.cs320.fokemon_webApp.shared.ItemClasses;

public class Item {
	private ItemName itemName;
	private String itemText;
	private int buyPrice;
	private int sellPrice;
	private boolean useInBattle;
	private boolean useOutOfBattle;
	
	public Item(ItemName itemName, int itemChace, int magnitude, String itemText, int buyPrice, int sellPrice, boolean useInBattle, boolean useOutOfBattle)	{
		this.itemName = itemName;
		this.itemText = itemText;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.useInBattle = useInBattle;
		this.useOutOfBattle = useOutOfBattle;
	}

	public ItemName getItemName() {
		return itemName;
	}

	public void setItemType(ItemName itemType) {
		this.itemName = itemType;
	}

	public String getItemText() {
		return itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public boolean getUseInBattle() {
		return useInBattle;
	}

	public void setUseInBattle(boolean useInBattle) {
		this.useInBattle = useInBattle;
	}

	public boolean getUseOutOfBattle() {
		return useOutOfBattle;
	}

	public void setUseOutOfBattle(boolean useOutOfBattle) {
		this.useOutOfBattle = useOutOfBattle;
	}

}
