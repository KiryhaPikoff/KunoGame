package myTestPackage.components.keyboard;

import java.util.ArrayList;
import java.util.List;

public final class ConditionMoveKeys {
	List<KeyboardKey> keys;
	
	public ConditionMoveKeys() {
		this.keys = new ArrayList<KeyboardKey>();
	}
	
	public ConditionMoveKeys(List<KeyboardKey> keys) {
		this.keys = new ArrayList<KeyboardKey>();
		this.keys = keys;
	}
	
	public void addKey(KeyboardKey key) {
		for (KeyboardKey keyboardKey : keys) {
			if(key.getKey() == keyboardKey.getKey()) {
				return;
			}
		}
		keys.add(key);
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (KeyboardKey keyboardKey : keys) {
			str.append(keyboardKey.toString() + "\n");
		}
		return str.toString();
	}
}
