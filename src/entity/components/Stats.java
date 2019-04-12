package entity.components;

public class Stats {
	
	protected int maxHealPoint;
	protected int currentHealPoint;
	
	protected int maxManaPoint;
	protected int currentManaPoint; 
	
	protected int attackTime;			// время между атаками
	protected int attackPower;
	
	protected int speed;
	
	public Stats(int maxHealPoint, int currentHealPoint, int maxManaPoint, int currentManaPoint, 
				 int attackTime, int attackPower, int speed) {
		
		this.maxHealPoint = maxHealPoint;
		this.currentHealPoint = currentHealPoint;
		this.maxManaPoint = maxManaPoint;
		this.currentManaPoint = currentManaPoint;
		this.attackTime = attackTime;
		this.attackPower = attackPower;
		this.speed = speed;
	}
	
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
