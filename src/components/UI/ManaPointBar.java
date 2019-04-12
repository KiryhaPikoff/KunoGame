package components.UI;

import java.awt.Color;
import java.awt.Graphics;

import utils.Drawable;

public class ManaPointBar extends Bar implements Drawable {

	public ManaPointBar(int currentValue, int maxValue) {
		this.currentValue = currentValue;
		this.maxValue = maxValue;
		this.color = Color.BLUE;
		this.x = 5;
		this.y = 30;
		this.width = 200;
		this.height = 15; 
	}
	

	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(this.x, this.y, this.width, this.height);
		g.setColor(this.color);

		g.fillRect(x + 1, y + 1, (this.currentValue  * (width - 1) / this.maxValue), height - 1);
	}
}
