package myTestPackage.entity.player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import myTestPackage.Drawable;
import myTestPackage.RectangleZone;
import myTestPackage.components.direction.DirectedByKeyboard;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.keyboard.ConditionMoveKeys;
import myTestPackage.components.keyboard.Coordinates;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.components.keyboard.KeyboardKeyAction;
import myTestPackage.entity.Entity;
import myTestPackage.mover.Movable;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageLoader;

public final class Player extends Entity implements Drawable, DirectedByKeyboard, Movable {

	private ConditionMoveKeys conditionMoveKeys;
	private BufferedImage image = ImageLoader.loadImage("resources/images/player64.png");
	
	public Player() {
		this.initCoordinates();
		this.initMoveKeys();
		this.initMovableZone();
		this.setDirectionMovement(DirectionMovement.STAND);
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
