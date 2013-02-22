package GUI;


public class InteractableObject {
	public InteractableObjectName objectName;
	public Interaction interaction;
	
	public InteractableObject(InteractableObjectName objectName, Interaction interaction){
		this.objectName = objectName;
		this.interaction = interaction;
	}
}
