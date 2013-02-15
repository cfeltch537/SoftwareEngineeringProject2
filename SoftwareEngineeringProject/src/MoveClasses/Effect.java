package MoveClasses;


public class Effect {
	private EffectType EffectIndex;
	private int EffectChance; 
	private int Magnitude;
	

	public Effect(EffectType EffectIndex, int EffectChance, int Magnitude) {
		this.setEffectIndex(EffectIndex);
		this.setEffectChance(EffectChance);
		this.setMagnitude(Magnitude);
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
}
