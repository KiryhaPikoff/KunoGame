package components;

public class Stats {
	
	protected int maxHealthPoint;
	protected int currentHealthPoint;
	
	protected int maxManaPoint;
	protected int currentManaPoint; 
	
	protected int attackTime;			// время между атаками
	protected int attackPower;
	
	protected int speed;
	
	public Stats(int maxHealthPoint, int currentHealthPoint, int maxManaPoint, int currentManaPoint, 
				 int attackTime, int attackPower, int speed) {
		
		this.maxHealthPoint = maxHealthPoint;
		this.currentHealthPoint = currentHealthPoint;
		this.maxManaPoint = maxManaPoint;
		this.currentManaPoint = currentManaPoint;
		this.attackTime = attackTime;
		this.attackPower = attackPower;
		this.speed = speed;
	}
	
	public int getMaxHealthPoint() {
		return maxHealthPoint;
	}

	public void setMaxHealthPoint(int maxHealPoint) {
		this.maxHealthPoint = maxHealPoint;
	}

	public int getCurrentHealthPoint() {
		return currentHealthPoint;
	}

	public void setCurrentHealthPoint(int currentHealPoint) {
		this.currentHealthPoint = currentHealPoint;
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
