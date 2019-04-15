package myTestPackage.entity;

import java.awt.Graphics;

import myTestPackage.Drawable;
import myTestPackage.components.direction.Directed;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.keyboard.Coordinates;

public abstract class Entity implements Directed {
	
	protected Coordinates coordinates;
	protected DirectionMovement directionMovement;

	protected Coordinates getCoordinates() {
		return coordinates;
	}

	protected void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	protected DirectionMovement getDirectionMovement() {
		return directionMovement;
	}

	protected void setDirectionMovement(DirectionMovement directionMovement) {
		this.directionMovement = directionMovement;
	}
}
