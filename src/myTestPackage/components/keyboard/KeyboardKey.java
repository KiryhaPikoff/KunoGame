package myTestPackage.components.keyboard;

public final class KeyboardKey implements KeyboardKeyAction {
	private final int key; // номер клавиши
	private final KeyboardKeyAction action; 
	private boolean isPressed;
	
	public KeyboardKey(int key) {
		this.key = key;
		this.action = null;
		this.setPressed(false);
	}
	
	public KeyboardKey(int key, KeyboardKeyAction action) {
		this.key = key;
		this.action = action;
		this.setPressed(false);
	}
	
	public void doAction() {
		this.action.doAction();
	}
	
	public int getKey() {
		return this.key;
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
		return "Номер клавиши: " + String.valueOf(this.key);
	}
}
