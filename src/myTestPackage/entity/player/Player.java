package myTestPackage.entity.player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.RectangleZone;
import myTestPackage.components.direction.DirectedByKeyboard;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.keyboard.ConditionMoveKeys;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.components.keyboard.KeyboardKeyAction;
import myTestPackage.entity.Entity;
import myTestPackage.mover.Movable;
import myTestPackage.renderer.Animated;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageLoader;

public final class Player extends Entity {

	private ConditionMoveKeys conditionMoveKeys;
	private BufferedImage image = ImageLoader.loadImage("resources/images/player64.png");
	private Animation animUP;
	private Animation animDOWN;
	private Animation animLEFT;
	private Animation animRIGHT;
	
	
	public Player() {
		this.initCoordinates();
		this.initAnimations();
		this.initMoveKeys();
		this.initMovableZone();
		this.setDirectionMovement(DirectionMovement.STAND);
	}
	
	private void initAnimations() {
		animUP = new Animation("resources/images/player_up.png");
		animDOWN = new Animation("resources/images/player_down.png");
		animLEFT = new Animation("resources/images/player_left.png");
		animRIGHT = new Animation("resources/images/player_right.png");
	}
	
	private void initCoordinates() {
		this.coordinates = new Coordinates(500, 500);
	}
	
	private void initMovableZone() {
		this.movableZone = new RectangleZone(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SIZE_TILE / 2);
	}
	
	private void initMoveKeys() {
		this.conditionMoveKeys = new ConditionMoveKeys(
		new KeyboardKey(KeyEvent.VK_W),
		new KeyboardKey(KeyEvent.VK_S),
		new KeyboardKey(KeyEvent.VK_A),
		new KeyboardKey(KeyEvent.VK_D));
	}
	
	public void changeDirection() {
		if(conditionMoveKeys.getKeyboardKeyUP().isPressed()) this.setDirectionMovement(DirectionMovement.NORTH);
		if(conditionMoveKeys.getKeyboardKeyDOWN().isPressed()) this.setDirectionMovement(DirectionMovement.SOUTH);
		if(conditionMoveKeys.getKeyboardKeyLEFT().isPressed()) this.setDirectionMovement(DirectionMovement.WEST);
		if(conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.EAST);
		
		if(conditionMoveKeys.getKeyboardKeyUP().isPressed() && conditionMoveKeys.getKeyboardKeyLEFT().isPressed()) this.setDirectionMovement(DirectionMovement.NORTH_WEST);
		if(conditionMoveKeys.getKeyboardKeyUP().isPressed() && conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.NORTH_EAST);
		if(conditionMoveKeys.getKeyboardKeyDOWN().isPressed() && conditionMoveKeys.getKeyboardKeyLEFT().isPressed()) this.setDirectionMovement(DirectionMovement.SOUTH_WEST);
		if(conditionMoveKeys.getKeyboardKeyDOWN().isPressed() && conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.SOUTH_EAST);
	
		if( !conditionMoveKeys.getKeyboardKeyUP().isPressed() &&
			!conditionMoveKeys.getKeyboardKeyDOWN().isPressed() &&
			!conditionMoveKeys.getKeyboardKeyLEFT().isPressed() && 
			!conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.STAND);
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
		g.drawImage(this.image, this.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.getCoordinates().getY() - Constants.SIZE_TILE / 2, null);
	}
	
	public void move() {
		this.getCoordinates().setPointXY(this.getCoordinates().getX() + this.directionMovement.getOffsetX(), this.getCoordinates().getY() + this.directionMovement.getOffsetY());
	}

	public ConditionMoveKeys getConditionMoveKeys() {
		return conditionMoveKeys;
	}
}
