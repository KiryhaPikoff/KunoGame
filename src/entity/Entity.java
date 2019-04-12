package entity;

import java.awt.Image;

import components.Attack;
import components.Direction;
import components.Inventory;
import components.Stats;
import components.Zones;
import entity.control.Buttons;
import utils.Coordinates;

public abstract class Entity {
	protected Coordinates currentCoordinate;
	protected Coordinates spawnCoordinate;
	protected Stats stat;
	protected Inventory inventory;
	protected Direction direction;
	protected Attack attack;
	protected Zones zone;
	protected Buttons buttons;
	
	protected Image iamge;
	
	public Coordinates getCoordinate() {
		return currentCoordinate;
	}
	public void setCoordinate(Coordinates coordinate) {
		this.currentCoordinate = coordinate;
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
	public Buttons getButtons() {
		return buttons;
	}
	public void setButtons(Buttons buttons) {
		this.buttons = buttons;
	}
}
