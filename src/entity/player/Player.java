package entity.player;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import entity.components.Attack;
import entity.components.Direction;
import entity.components.Inventory;
import entity.components.Stats;
import entity.components.Zones;
import entity.control.Button;
import utils.Coordinates;
import utils.Drawable;
import utils.Moveable;

public class Player extends Entity implements Drawable, Moveable {
	
	public Player() {
		this.currentCoordinate = new Coordinates(100, 100);
		this.stat = new Stats(200, 200, 100, 100, 1000, 5, 2);
		this.inventory = new Inventory();
		this.direction = Direction.STAND;
		this.attack = Attack.STAND;
		this.zone = new Zones(25, this.currentCoordinate);
		this.buttons = new ArrayList<Button>();
		
		this.initButtons();
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}

	public void changeAnimation() {
		// TODO Auto-generated method stub
		
	}
	
	private void initButtons() {
		buttons.add(new Button(87)); // W
		buttons.add(new Button(65)); // A
		buttons.add(new Button(83)); // S
		buttons.add(new Button(68)); // D
	}
}
