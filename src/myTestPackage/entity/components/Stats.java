package myTestPackage.entity.components;

public class Stats {
	private int currentHealthPoints;
	private int maxHealthPoints;
	
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
}
