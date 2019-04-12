package components;

import java.awt.Color;
import java.awt.Graphics;

import utils.Drawable;

public class HealthPointBar extends Bar implements Drawable {

	public HealthPointBar(int maxValue) {
		this.currentValue = 0;
		this.maxValue = maxValue;
		this.color = Color.RED;
		this.x = 15;
		this.y = 40;
		this.width = 200;
		this.height = 15; 
	}
	
	public void updateValue(int value) {
		this.currentValue = value;
	}
	
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	public void paint(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		g.setColor(this.color);
		g.fillRect(x + 1, y + 1, this.currentValue / this.maxValue / width - 1, height - 1);
	}
}
