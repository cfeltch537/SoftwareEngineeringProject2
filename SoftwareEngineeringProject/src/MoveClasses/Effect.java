package MoveClasses;


public class Effect {
	private EffectType EffectIndex;
	private int EffectChance; 
	private int Magnitude;
	private String EffectText;
	

	public Effect(EffectType EffectIndex, int EffectChance, int Magnitude) {
		this.setEffectIndex(EffectIndex);
		this.setEffectChance(EffectChance);
		this.setMagnitude(Magnitude);
		EffectText="";
	}


	public EffectType getEffectIndex() {
		return EffectIndex;
	}


	public void setEffectIndex(EffectType effectIndex) {
		EffectIndex = effectIndex;
	}


	public int getEffectChance() {
		return EffectChance;
	}


	public void setEffectChance(int effectChance) {
		EffectChance = effectChance;
	}


	public int getMagnitude() {
		return Magnitude;
	}


	public void setMagnitude(int magnitude) {
		Magnitude = magnitude;
	}


	public String getEffectText() {
		return EffectText;
	}


	public void setEffectText(String effectText) {
		EffectText = effectText;
	}
}
