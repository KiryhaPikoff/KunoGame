package myTestPackage.entity.components;

import java.io.Serializable;

public class Stats implements Serializable {
	private int currentHealthPoints;
	private int maxHealthPoints;

	private int radiusPursuit;
	private int radiusAttack;
	
	private int damage;
	
	public Stats() {
		
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
