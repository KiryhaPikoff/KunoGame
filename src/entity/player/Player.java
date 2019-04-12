package entity.player;

import java.awt.Graphics;

import components.Attack;
import components.Coordinates;
import components.Direction;
import components.Inventory;
import components.Stats;
import components.Zones;
import entity.Entity;
import utils.Drawable;
import utils.ImageLoader;
import utils.Moveable;

public class Player extends Entity implements Drawable, Moveable {
	
	public Player() {
		this.currentCoordinate = new Coordinates(100, 100);
		this.stat = new Stats(200, 200, 100, 100, 1000, 5, 2);
		this.inventory = new Inventory();
		this.direction = Direction.STAND;
		this.attack = Attack.STAND;
		this.zone = new Zones(25, this.currentCoordinate);
		this.iamge = ImageLoader.loadImage("resources/images/player64.png");
	//	this.buttons = new Buttons();
	}

	public void paint(Graphics g) {
		g.drawImage(this.iamge, 100, 100, null);
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}

	public void changeAnimation() {
		// TODO Auto-generated method stub
		
	}
}
