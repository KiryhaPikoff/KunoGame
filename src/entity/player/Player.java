package entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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
import map.Chunk;
import utils.Constants;
import utils.Drawable;
import utils.ImageLoader;
import utils.Moveable;

public class Player extends Entity implements Drawable, Moveable {
	
	public Player() {
		this.currentFrame = 0;
		
		this.startFrameCondition = 0;
		this.finishFrameCondition = 2;
		
		this.isStopAnimation = false;
		
		this.currentCoordinate = new Coordinates(500, 500);
		this.stats = new Stats(200, 200, 100, 100, 1000, 5, 2);
		this.inventory = new Inventory();
		
		this.directionMove = DirectionMove.STAND;
		this.directionPaint = DirectionPaint.SOUTH;
		this.condition = Condition.GO;
		this.attack = Attack.SWING;
		
		this.zone = new Zones(25, this.currentCoordinate);
		
		this.tileset = (BufferedImage) ImageLoader.loadImage("resources/images/player_tileset.png");
		
		this.buttonsSpells = new ArrayList<Button>();
		this.buttonsMove = new ArrayList<Button>();
		
		this.initButtonsSpells();
		this.initButtonsMove();

		this.movableZone = new Rectangle(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.image, this.currentCoordinate.getX() - Constants.SIZE_TILE / 2, this.currentCoordinate.getY() - Constants.SIZE_TILE / 2, null);
	}

	public void move(Chunk currentChunk) {
		if(movableZone.contains(currentCoordinate.getX() + directionMove.getOffsetX() * stats.getSpeed(),
								currentCoordinate.getY() + directionMove.getOffsetY() * stats.getSpeed()) &&
		   currentChunk.getTileXY(currentCoordinate.getX() + directionMove.getOffsetX() * stats.getSpeed(),
				   				  currentCoordinate.getY() + directionMove.getOffsetY() * stats.getSpeed()).getTileType().isPassable()) {
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

