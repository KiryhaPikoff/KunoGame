package entity.control;

public class Buttons {
	protected boolean isPressedW;
	protected boolean isPressedA;
	protected boolean isPressedS;
	protected boolean isPressedD;
	
	protected boolean isPressed_1;
	protected boolean isPressed_2;
	protected boolean isPressed_3;

	
	public Buttons() {
		this.isPressedW = false;
		this.isPressedA = false;
		this.isPressedS = false;
		this.isPressedD = false;
		
		this.isPressed_1 = false;
		this.isPressed_2 = false;
		this.isPressed_3 = false;
	}
	
	public boolean isPressedW() {
		return isPressedW;
	}

	public void setPressedW(boolean isPressedW) {
		this.isPressedW = isPressedW;
	}

	public boolean isPressedA() {
		return isPressedA;
	}

	public void setPressedA(boolean isPressedA) {
		this.isPressedA = isPressedA;
	}

	public boolean isPressedS() {
		return isPressedS;
	}

	public void setPressedS(boolean isPressedS) {
		this.isPressedS = isPressedS;
	}

	public boolean isPressedD() {
		return isPressedD;
	}

	public void setPressedD(boolean isPressedD) {
		this.isPressedD = isPressedD;
	}

	public boolean isPressed_1() {
		return isPressed_1;
	}

	public void setPressed_1(boolean isPressed_1) {
		this.isPressed_1 = isPressed_1;
	}
}
