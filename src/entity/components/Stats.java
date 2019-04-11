package entity.components;

public class Stats {
	
	int maxHealPoint;
	int currentHealPoint;
	
	int maxManaPoint;
	int currentManaPoint; 
	
	int attackTime;
	int attackPower;
	
	int speed;
	
	public int getMaxHealPoint() {
		return maxHealPoint;
	}

	
	public void setMaxHealPoint(int maxHealPoint) {
		this.maxHealPoint = maxHealPoint;
	}

	public int getCurrentHealPoint() {
		return currentHealPoint;
	}

	public void setCurrentHealPoint(int currentHealPoint) {
		this.currentHealPoint = currentHealPoint;
	}

	public int getMaxManaPoint() {
		return maxManaPoint;
	}

	public void setMaxManaPoint(int maxManaPoint) {
		this.maxManaPoint = maxManaPoint;
	}

	public int getCurrentManaPoint() {
		return currentManaPoint;
	}

	public void setCurrentManaPoint(int currentManaPoint) {
		this.currentManaPoint = currentManaPoint;
	}

	public int getAttackTime() {
		return attackTime;
	}

	public void setAttackTime(int attackTime) {
		this.attackTime = attackTime;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
