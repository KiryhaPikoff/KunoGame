package myTestPackage.components.keyboard;

public final class KeyboardKey implements KeyboardKeyAction {
	private final int key; // номер клавиши
	private final KeyboardKeyAction action; 
	
	public KeyboardKey(int key, KeyboardKeyAction action) {
		this.key = key;
		this.action = action;
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
	
	@Override
	public String toString() {
		return "Номер клавиши: " + String.valueOf(this.key);
	}
}
