package myTestPackage.entity.components;

import myTestPackage.Coordinates;
import myTestPackage.entity.monster.TypeMonsters;

import java.io.Serializable;

public class Stats implements Serializable {
	private Coordinates coordinates;

	private TypeMonsters typeMonsters;

	protected int score;

	private int currentHealthPoints;
	private int maxHealthPoints;

	private int radiusPursuit;
	private int radiusAttack;
	
	private int damage;
	
	public Stats() {
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public TypeMonsters getTypeMonsters() {
		return typeMonsters;
	}

	public void setTypeMonsters(TypeMonsters typeMonsters) {
		this.typeMonsters = typeMonsters;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public int getCurrentHealthPoints() {
		return currentHealthPoints;
	}

	public void setCurrentHealthPoints(int currentHealthPoints) {
		this.currentHealthPoints = currentHealthPoints;
	}

	public int getMaxHealthPoints() {
		return maxHealthPoints;
	}

	public void setMaxHealthPoints(int maxHealthPoints) {
		this.maxHealthPoints = maxHealthPoints;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRadiusPursuit() {
		return radiusPursuit;
	}

	public void setRadiusPursuit(int radiusPursuit) {
		this.radiusPursuit = radiusPursuit;
	}

	public int getRadiusAttack() {
		return radiusAttack;
	}

	public void setRadiusAttack(int radiusAttack) {
		this.radiusAttack = radiusAttack;
	}
}
