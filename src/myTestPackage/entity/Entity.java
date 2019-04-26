package myTestPackage.entity;

import java.awt.Graphics;

import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.RectangleZone;
import myTestPackage.components.direction.Directed;
import myTestPackage.components.direction.DirectedByKeyboard;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.mover.Movable;
import myTestPackage.renderer.Animated;

public abstract class Entity implements Directed, Drawable, DirectedByKeyboard, Movable, Animated {
	
	protected Coordinates coordinates;
	protected DirectionMovement directionMovement;
	protected RectangleZone movableZone;

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
}
