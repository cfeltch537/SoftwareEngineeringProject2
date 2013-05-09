package edu.ycp.cs320.fokemon_webApp.shared.ItemClasses;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Effect;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sellPrice;
	private int buyPrice;
	private boolean useInBattle;
	private boolean useOutOfBattle;
	private ArrayList<Effect> itemEffect;
	private ItemName itemName;
	private double catchRate = 0;
	private int quantity = 0;

	public Item(int quantity, int sellPrice, int buyPrice, boolean useInBattle,
			boolean useOutOfBattle, ItemName itemName,
			ArrayList<Effect> itemEffect) {
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.useInBattle = useInBattle;
		this.useOutOfBattle = useOutOfBattle;
		this.itemName = itemName;
		this.itemEffect = itemEffect;
	}
	public Item() {
		this.sellPrice = 0;
		this.buyPrice = 0;
		this.useInBattle = false;
		this.useOutOfBattle = false;
		this.itemName = null;
		this.itemEffect = null;	
	}
	/**
	 * @return the sellPrice
	 */
	public int getSellPrice() {
		return sellPrice;
	}

	/**
	 * @param sellPrice
	 *            the sellPrice to set
	 */
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	/**
	 * @return the buyPrice
	 */
	public int getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice
	 *            the buyPrice to set
	 */
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the useInBattle
	 */
	public boolean isUseInBattle() {
		return useInBattle;
	}

	/**
	 * @param useInBattle
	 *            the useInBattle to set
	 */
	public void setUseInBattle(boolean useInBattle) {
		this.useInBattle = useInBattle;
	}

	/**
	 * @return the useOutOfBattle
	 */
	public boolean isUseOutOfBattle() {
		return useOutOfBattle;
	}

	/**
	 * @param useOutOfBattle
	 *            the useOutOfBattle to set
	 */
	public void setUseOutOfBattle(boolean useOutOfBattle) {
		this.useOutOfBattle = useOutOfBattle;
	}

	/**
	 * @return the itemName
	 */
	
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName.name;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName.name = itemName;
	}
	/**
	 * @return the catchRate
	 */
	public double getCatchRate() {
		return catchRate;
	}

	/**
	 * @param catchRate
	 *            the catchRate to set
	 */
	public void setCatchRate(double catchRate) {
		this.catchRate = catchRate;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the itemEffect
	 */
	public ArrayList<Effect> getItemEffect() {
		return itemEffect;
	}

	/**
	 * @param itemEffect
	 *            the itemEffect to set
	 */
	public void setItemEffect(ArrayList<Effect> itemEffect) {
		this.itemEffect = itemEffect;
	}

}
