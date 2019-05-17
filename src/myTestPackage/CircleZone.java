package myTestPackage;

import java.io.Serializable;

public class CircleZone implements Serializable {
	
	private Coordinates coordinates; 
	private int radius;
	
	public CircleZone(int radius, Coordinates coordinates) {
		this.radius = radius;
		this.coordinates = new Coordinates(coordinates);
	}
	
	public void updateCoordinates(int x, int y) {
		this.coordinates = new Coordinates(x, y);
	}
	
	public void updateCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public boolean inZone(int x, int y) {
		return Math.pow(this.coordinates.getX() - x, 2) + Math.pow(this.coordinates.getY() - y, 2) <= this.radius * this.radius;
	}
	
	public boolean inZone(Coordinates coordinates) {
		return coordinates.getX() * coordinates.getX() + coordinates.getY() * coordinates.getY() <= this.radius * this.radius;
	}
}
