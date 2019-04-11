package entity;

import entity.components.Attack;
import entity.components.Direction;
import entity.components.Inventory;
import entity.components.Stats;
import entity.components.Zones;
import utils.Coordinates;

public abstract class Entity {
	protected Coordinates coordinate;
	protected Stats stat;
	protected Inventory inventory;
	protected Direction direction;
	protected Attack attack;
	protected Zones zone;
	
	public Coordinates getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinates coordinate) {
		this.coordinate = coordinate;
	}
	public Stats getStat() {
		return stat;
	}
	public void setStat(Stats stat) {
		this.stat = stat;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public Attack getAttack() {
		return attack;
	}
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	public Zones getZone() {
		return zone;
	}
	public void setZone(Zones zone) {
		this.zone = zone;
	}
}
