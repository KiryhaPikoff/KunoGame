package entity.player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import components.Attack;
import components.Coordinates;
import components.Direction;
import components.Inventory;
import components.Stats;
import components.Zones;
import entity.Entity;
import entity.control.Button;
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
		this.buttons = new ArrayList<Button>();
		this.initButtons();

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
	
	private void initButtons() {
		buttons.add(new Button(KeyEvent.VK_W) {
			@Override
			public void actionPressed() {
				System.out.println("Клавиша W");
			}
		});
		buttons.add(new Button(KeyEvent.VK_A)); 
		buttons.add(new Button(KeyEvent.VK_S)); 
		buttons.add(new Button(KeyEvent.VK_D)); 
	}
}

