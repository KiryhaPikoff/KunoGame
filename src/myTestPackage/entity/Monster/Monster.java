package myTestPackage.entity.Monster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import myTestPackage.CircleZone;
import myTestPackage.Coordinates;
import myTestPackage.RectangleZone;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.direction.DirectionRandomizer;
import myTestPackage.entity.Entity;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageLoader;
import myTestPackage.utils.ImageStorage;

public class Monster extends Entity {
	
	// Player target;

	public Monster() {
		this.coordinates = new Coordinates();
		
		this.initCoordinates();
		
		this.setThisCoordZone(new CircleZone(Constants.SIZE_TILE / 2, new Coordinates(this.coordinates.getX() - Constants.SIZE_TILE / 2, this.coordinates.getY() - Constants.SIZE_TILE / 2)));
		
		this.initMovableZone();
		this.setDirectionMovement(DirectionMovement.STAND);
	}
	
	public void initGraphics(BufferedImage stand, BufferedImage up, BufferedImage down, BufferedImage left, BufferedImage right) {
		this.image = stand;
		
		animUP = new Animation(up);
		animDOWN = new Animation(down);
		animLEFT = new Animation(left);
		animRIGHT = new Animation(right);
	}
	
	private void initCoordinates() {
		this.coordinates = new Coordinates(450, 500);
	}
	
	private void initMovableZone() {
		this.movableZone = new RectangleZone(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SIZE_TILE / 2);
	}
	
	public void move() {
		this.getCoordinates().setPointXY(this.getCoordinates().getX() + this.directionMovement.getOffsetX(), this.getCoordinates().getY() + this.directionMovement.getOffsetY());
		this.getThisCoordZone().updateCoordinates(new Coordinates(this.coordinates.getX() - Constants.SIZE_TILE / 2, this.coordinates.getY() - Constants.SIZE_TILE / 2));
	}

	public void changeDirection() {
		this.directionMovement = DirectionRandomizer.rand();
	}

	public void updateAnimation() {
			switch(this.directionMovement) {
				case NORTH: {
					this.animUP.update();
					this.image = this.animUP.getCurrentImage();
					break;
				}
					
				case SOUTH: {
					this.animDOWN.update();
					this.image = this.animDOWN.getCurrentImage();
					break;
				}
				
				case WEST:
				case NORTH_WEST:
				case SOUTH_WEST: {
					this.animLEFT.update();
					this.image = this.animLEFT.getCurrentImage();
					break;
				}
				
				case EAST: 
				case NORTH_EAST:
				case SOUTH_EAST: {
					this.animRIGHT.update();
					this.image = this.animRIGHT.getCurrentImage();
					break;
				}
			} 
	}

	public void paint(Graphics g) {
		if(this.isTarget()) {
			g.drawImage(ImageStorage.TARGET, this.coordinates.getX() - Constants.SIZE_TILE / 2, this.coordinates.getY() - Constants.SIZE_TILE / 2, null);
		}
		g.drawImage(this.image, this.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.getCoordinates().getY() - Constants.SIZE_TILE / 2, null);
	}
}
