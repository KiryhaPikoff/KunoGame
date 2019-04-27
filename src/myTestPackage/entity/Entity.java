package myTestPackage.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.RectangleZone;
import myTestPackage.components.direction.Directed;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.mover.Movable;
import myTestPackage.renderer.Animated;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.ImageLoader;

public abstract class Entity implements Directed, Drawable, Movable, Animated {
	
	private String name;
	
	protected Coordinates coordinates;
	protected DirectionMovement directionMovement;
	protected RectangleZone movableZone;
	
	protected BufferedImage image;
	protected Animation animUP;
	protected Animation animDOWN;
	protected Animation animLEFT;
	protected Animation animRIGHT;
	
//	protected Entity target;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public DirectionMovement getDirectionMovement() {
		return directionMovement;
	}

	public void setDirectionMovement(DirectionMovement directionMovement) {
		this.directionMovement = directionMovement;
	}

	public RectangleZone getMovableZone() {
		return movableZone;
	}

	public void setMovableZone(RectangleZone movableZone) {
		this.movableZone = movableZone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}