package entity;
import java.awt.Image;
import java.util.List;

import components.Attack;
import components.Coordinates;
import components.Direction;
import components.Inventory;
import components.Stats;
import components.Zones;
import entity.control.Button;

public abstract class Entity {
	protected Coordinates currentCoordinate;
	protected Coordinates spawnCoordinate;
	protected Stats stat;
	protected Inventory inventory;
	protected Direction direction;
	protected Attack attack;
	protected Zones zone;
	protected List<Button> buttons;
	protected Image iamge;
	
	public Coordinates getCoordinate() {
		return this.currentCoordinate;
	}
	public List<Button> getButtons() {
		return buttons;
	}
	public Coordinates getCurrentCoordinate() {
		return currentCoordinate;
	}
	public void setCurrentCoordinate(Coordinates currentCoordinate) {
		this.currentCoordinate = currentCoordinate;
	}
	public Coordinates getSpawnCoordinate() {
		return spawnCoordinate;
	}
	public void setSpawnCoordinate(Coordinates spawnCoordinate) {
		this.spawnCoordinate = spawnCoordinate;
	}
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
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
