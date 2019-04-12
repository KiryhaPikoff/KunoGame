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
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
	
	public boolean isPressed() {
		return isPressed;
	}
}
