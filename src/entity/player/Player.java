package entity.player;

import entity.Entity;
import entity.components.Attack;
import entity.components.Direction;
import entity.components.Inventory;
import entity.components.Stats;
import entity.components.Zones;
import utils.Coordinates;

public class Player extends Entity {
	
	public Player() {
		this.coordinate = new Coordinates(100, 100);
		this.stat = new Stats(200, 200, 100, 100, 1000, 5, 2);
		this.inventory = new Inventory();
		this.direction = Direction.STAND;
		this.attack = Attack.STAND;
		this.zone = new Zones(25, 200, 0);
	}
}
