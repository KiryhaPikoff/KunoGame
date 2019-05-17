package myTestPackage.components.keyboard;

import java.io.Serializable;

public final class KeyboardKey implements KeyboardKeyAction, Serializable {
	private final int id; // номер клавиши
	private final KeyboardKeyAction action; 
	private boolean isPressed;
	
	public KeyboardKey(int key) {
		this.id = key;
		this.action = null;
		this.setPressed(false);
	}
	
	public KeyboardKey(int key, KeyboardKeyAction action) {
		this.id = key;
		this.action = action;
		this.setPressed(false);
	}
	
	public void execute() {
		this.action.execute();
	}
	
	public int getID() {
		return this.id;
	}
	
	public KeyboardKeyAction getKeyboardKeyAction() {
		return this.action;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
	
	@Override
	public String toString() {
		return "Номер клавиши: " + String.valueOf(this.id);
	}
}
