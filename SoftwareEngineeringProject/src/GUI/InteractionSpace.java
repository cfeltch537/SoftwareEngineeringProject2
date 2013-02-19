package GUI;

public enum InteractionSpace {
		MovementBlocked,
		MovementAllowed,
		TriggerTrainerBattle,
		TriggerChangeArea;

	public boolean isMovable(InteractionSpace interactionSpace){
		switch(interactionSpace){
		case MovementAllowed: return true;
		case MovementBlocked: return false;
		default:
			return false;
		}
	}

}