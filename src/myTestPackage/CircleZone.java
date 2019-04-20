package myTestPackage;

import java.awt.Shape;

import myTestPackage.components.keyboard.Coordinates;

public class CircleZone {
	
	private Coordinates coordinates; 
	private int radius;
	
	public CircleZone(int radius, Coordinates coordinates) {
		this.radius = radius;
		this.coordinates = new Coordinates(coordinates);
	}
	
	public boolean inZone(int x, int y) {
		return Math.pow(this.coordinates.getX() - x, 2) + Math.pow(this.coordinates.getY() - y, 2) <= this.radius * this.radius;
	}
	
	public boolean inZone(Coordinates coordinates) {
		return coordinates.getX() * coordinates.getX() + coordinates.getY() * coordinates.getY() <= this.radius * this.radius;
	}
}
