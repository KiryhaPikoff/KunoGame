package entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import components.Attack;
import components.Condition;
import components.Coordinates;
import components.DirectionMove;
import components.DirectionPaint;
import components.Inventory;
import components.Stats;
import components.Zones;
import entity.Entity;
import entity.control.Button;
import utils.Constants;
import utils.Drawable;
import utils.ImageLoader;
import utils.Moveable;

public class Player extends Entity implements Drawable, Moveable {
	
	public Player() {
		this.currentCoordinate = new Coordinates(100, 100);
		this.stats = new Stats(200, 200, 100, 100, 1000, 5, 2);
		this.inventory = new Inventory();
		
		this.directionMove = DirectionMove.STAND;
		this.directionPaint = DirectionPaint.EAST;
		this.condition = Condition.GO;
		this.attack = Attack.STAND;
		
		this.zone = new Zones(25, this.currentCoordinate);
		this.image = ImageLoader.loadImage("resources/images/player64.png");
		
		this.buttonsSpells = new ArrayList<Button>();
		this.buttonsMove = new ArrayList<Button>();
		
		this.initButtonsSpells();
		this.initButtonsMove();
		
		this.movableZone = new Rectangle(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.image, this.currentCoordinate.getX() - Constants.SIZE_TILE / 2, this.currentCoordinate.getY() - Constants.SIZE_TILE / 2, null);
	}

	public void move() {
		if(movableZone.contains(currentCoordinate.getX() + directionMove.getOffsetX() * stats.getSpeed(),
								currentCoordinate.getY() + directionMove.getOffsetY() * stats.getSpeed())) {
			this.setCurrentCoordinate(new Coordinates(getCurrentCoordinate().getX() + getDirectionMove().getOffsetX() * getStats().getSpeed(), 
					getCurrentCoordinate().getY() + getDirectionMove().getOffsetY() * getStats().getSpeed()));
		}
	}
	
	private void initButtonsSpells() {
		 // дописать
	}
	
	private void initButtonsMove() {
		buttonsMove.add(new Button(KeyEvent.VK_W));
		buttonsMove.add(new Button(KeyEvent.VK_A));
		buttonsMove.add(new Button(KeyEvent.VK_S));
		buttonsMove.add(new Button(KeyEvent.VK_D));
	}
 }

