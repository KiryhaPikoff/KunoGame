package myTestPackage.components.keyboard;

import java.util.List;

/*
 * ConditionKeys лист добавленных клавиш
 * 
 * Author: Pikov Kirill
 */

public abstract class ConditionKeys {
	protected List<KeyboardKey> keyboardKeys;
	
	public List<KeyboardKey> getKeyboardKeys() {
		return keyboardKeys;
	}
}
