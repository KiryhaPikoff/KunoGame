package entity.player;

import java.awt.Graphics;

import entity.Entity;
import entity.components.Attack;
import entity.components.Direction;
import entity.components.Inventory;
import entity.components.Stats;
import entity.components.Zones;
import utils.Coordinates;
import utils.Drawable;
import utils.Moveable;

public class Player extends Entity implements Drawable, Moveable {
	
	public Player() {
		this.coordinate = new Coordinates(100, 100);
		this.stat = new Stats(200, 200, 100, 100, 1000, 5, 2);
		this.inventory = new Inventory();
		this.direction = Direction.STAND;
		this.attack = Attack.STAND;
		this.zone = new Zones(25, 200);
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}
}
