package entity.control;

public class Button {
	protected int key;
	protected boolean isPressed;
	
	public Button(int key) {
		this.key = key;
	}	
	
	public void actionReleased() {
		isPressed = false;
	}
	
	public void actionPressed() {
		isPressed = true;
		System.out.println(key + "is Pressed");
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		key = key;
	}
	public boolean isPressed() {
		return isPressed;
	}
	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
}
