package entity;
import java.awt.Image;

import java.awt.Rectangle;

import java.awt.image.BufferedImage;

import java.util.List;

import components.Attack;
import components.Condition;
import components.Coordinates;
import components.DirectionMove;
import components.DirectionPaint;
import components.Inventory;
import components.Stats;
import components.Zones;
import entity.control.Button;

public abstract class Entity {
	protected int currentFrame;
	protected boolean isStopAnimation;
	
	protected Coordinates currentCoordinate;
	protected Coordinates spawnCoordinate;
	protected Coordinates tilesetCoords;

	protected Stats stats;
	
	protected Inventory inventory;
	
	protected DirectionMove directionMove;
	protected DirectionPaint directionPaint;
	protected Condition condition;
	protected Attack attack;
	
	protected Zones zone;

	protected BufferedImage tileset;
	protected BufferedImage image;
	
	protected List<Button> buttonsSpells;
	protected List<Button> buttonsMove;
	
	protected Rectangle movableZone;
	
	public List<Button> getButtonsMove() {
		return buttonsMove;
	}
	public void setButtonsMove(List<Button> buttonsMove) {
		this.buttonsMove = buttonsMove;
	}
	
	public List<Button> getButtonsSpells() {
		return buttonsSpells;
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
	public void setButtonsSpells(List<Button> buttons) {
		this.buttonsSpells = buttons;
	}
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stat) {
		this.stats = stat;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public DirectionMove getDirectionMove() {
		return directionMove;
	}
	public void setDirectionMove(DirectionMove direction) {
		this.directionMove = direction;
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
	public DirectionPaint getDirectionPaint() {
		return directionPaint;
	}
	public void setDirectionPaint(DirectionPaint directionPaint) {
		this.directionPaint = directionPaint;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public Coordinates getTilesetCoords() {
		return tilesetCoords;
	}
	public void setTilesetCoords(Coordinates tilesetCoords) {
		this.tilesetCoords = tilesetCoords;
	}
	public BufferedImage getTileset() {
		return tileset;
	}
	public void setTileset(BufferedImage tileset) {
		this.tileset = tileset;
	}

	public Rectangle getMovableZone() {
		return movableZone;
	}
	public void setMovableZone(Rectangle movableZone) {
		this.movableZone = movableZone;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	public boolean isStopAnimation() {
		return isStopAnimation;
	}
	public void setStopAnimation(boolean isStopAnimation) {
		this.isStopAnimation = isStopAnimation;
	}
}
