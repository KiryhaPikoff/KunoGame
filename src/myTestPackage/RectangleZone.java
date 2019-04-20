package myTestPackage;

import java.awt.Rectangle;

public class RectangleZone {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public RectangleZone(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean inZone(int x, int y) {
		return x > this.x && x < this.width && y > this.y && y < this.height;
	}
	
/*	public boolean inZone(Coordinates coordinates) {
		return this.rect.contains(coordinates.getX(), coordinates.getY());
	}*/
}
