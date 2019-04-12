package components.UI;

import java.awt.Color;

public abstract class Bar {
	protected int currentValue;
	protected int maxValue;
	protected Color color;
	protected int x;
	protected int y;
	protected int width;
	protected int height; 
	
	public void updateValue(int value) {
		this.currentValue = value;
	}
	
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
}
