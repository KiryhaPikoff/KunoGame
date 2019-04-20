package myTestPackage.components.keyboard;

import java.util.ArrayList;
import java.util.List;

public final class ConditionMoveKeys extends ConditionKeys {
	
	private final KeyboardKey UP;
	private final KeyboardKey DOWN;
	private final KeyboardKey LEFT;
	private final KeyboardKey RIGHT;
	
	public ConditionMoveKeys(KeyboardKey UP, KeyboardKey DOWN, KeyboardKey LEFT, KeyboardKey RIGHT) {
		this.UP = UP;
		this.DOWN = DOWN;
		this.LEFT = LEFT;
		this.RIGHT = RIGHT;
		
		this.keyboardKeys = new ArrayList<KeyboardKey>();
		this.getKeyboardKeys().add(UP);
		this.getKeyboardKeys().add(DOWN);
		this.getKeyboardKeys().add(LEFT);
		this.getKeyboardKeys().add(RIGHT);
	}
	
	public KeyboardKey getKeyboardKeyUP() {
		return this.UP;
	}
	
	public KeyboardKey getKeyboardKeyDOWN() {
		return this.DOWN;
	}
	
	public KeyboardKey getKeyboardKeyLEFT() {
		return this.LEFT;
	}
	
	public KeyboardKey getKeyboardKeyRIGHT() {
		return this.RIGHT;
	}
}
