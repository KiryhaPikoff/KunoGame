package entity.monster;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import components.Attack;
import components.Condition;
import components.Coordinates;
import components.DirectionMove;
import components.DirectionPaint;
import components.Inventory;
import components.Stats;
import entity.Entity;
import map.Chunk;
import utils.Constants;
import utils.Drawable;
import utils.ImageLoader;
import utils.Moveable;

public class Skelet extends Entity implements Drawable, Moveable{
	
	public Skelet() {
		this.currentFrame = 0;
		this.isStopAnimation = false;
		
		this.currentCoordinate = new Coordinates(200, 200);
		this.stats = new Stats();
		
		stats.setMaxHealthPoint(500);
		stats.setCurrentHealthPoint(500);
		stats.setMaxManaPoint(0);
		stats.setCurrentManaPoint(0);
		stats.setSpeed(1);
		stats.setAttackTime(1000);
		stats.setAttackPower(3);
		
		this.inventory = new Inventory();
		
		this.directionMove = DirectionMove.STAND;
		this.directionPaint = DirectionPaint.EAST;
		this.condition = Condition.GO;
		this.attack = Attack.SWING;
		
		this.tileset = (BufferedImage) ImageLoader.loadImage("resources/images/monster_tileset2.png");
	}

	public void move(Chunk currentChunk) {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g) {
		g.drawImage(this.image, this.currentCoordinate.getX() - Constants.SIZE_TILE / 2, this.currentCoordinate.getY() - Constants.SIZE_TILE / 2, null);
	}

}
