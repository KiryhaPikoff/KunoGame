package myTestPackage.entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import myTestPackage.Action;
import myTestPackage.CircleZone;
import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.RectangleZone;
import myTestPackage.components.GameInteface.HealthPointsBar;
import myTestPackage.components.direction.Directed;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.entity.components.Stats;
import myTestPackage.entity.monster.Attacking;
import myTestPackage.mover.Movable;
import myTestPackage.renderer.Animated;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.AttackTimer;

/*
 * Entity Некая сущность, харакатеризующая все одушевлённые объекты
 * 
 * Author: Syaman Sergey
 */

public abstract class Entity implements Directed, Drawable, Movable, Animated, Serializable, Attacking {
	protected String name;
	protected boolean isTarget = false;
	protected boolean canAttack = false;

	protected Font scoreFont;
	
	protected CircleZone thisCoordZone; // зона для выделения по кликам
	protected RectangleZone movableZone;

	protected Shape pursuitZone;
	protected Shape attackZone;

	protected HealthPointsBar healthPointsBar;
	protected AttackTimer attackTimer;
	
	protected Action action;
	
	protected Stats stats;
	protected DirectionMovement directionMovement;

	protected transient BufferedImage image;
	protected Animation animUP;
	protected Animation animDOWN;
	protected Animation animLEFT;
	protected Animation animRIGHT;
	
	protected Entity target;

	public void setEntity(Entity entity) {
		this.stats = new Stats();
		this.stats.setCoordinates(new Coordinates(450,500));
		this.stats.setMaxHealthPoints(30);
		this.stats.setCurrentHealthPoints(30);
		this.stats.setDamage(5);
		this.stats.setScore(0);

		this.target = null;
		this.healthPointsBar = new HealthPointsBar(this);
		this.attackTimer = new AttackTimer(500);
		this.attackTimer.initAttackSpeed(this);
		this.attackTimer.startAttackTimer();

		this.action = Action.MOVE;

		this.setThisCoordZone(new CircleZone(myTestPackage.utils.Constants.SIZE_TILE / 2, new Coordinates(this.stats.getCoordinates().getX() - myTestPackage.utils.Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - myTestPackage.utils.Constants.SIZE_TILE / 2)));

		this.movableZone = new RectangleZone(0, 0, myTestPackage.utils.Constants.WINDOW_WIDTH, myTestPackage.utils.Constants.WINDOW_HEIGHT - myTestPackage.utils.Constants.SIZE_TILE / 2);
		this.setDirectionMovement(DirectionMovement.STAND);
	}
	public DirectionMovement getDirectionMovement() {
		return directionMovement;
	}

	public void setDirectionMovement(DirectionMovement directionMovement) {
		this.directionMovement = directionMovement;
	}

	public RectangleZone getMovableZone() {
		return movableZone;
	}

	public void setMovableZone(RectangleZone movableZone) {
		this.movableZone = movableZone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CircleZone getThisCoordZone() {
		return thisCoordZone;
	}

	public void setThisCoordZone(CircleZone thisCoordZone) {
		this.thisCoordZone = thisCoordZone;
	}

	public boolean isTarget() {
		return isTarget;
	}

	public void setTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}

	public Stats stats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}

	public Shape getPursuitZone() {
		return pursuitZone;
	}

	public void setPursuitZone(Shape pursuitZone) {
		this.pursuitZone = pursuitZone;
	}

	public Shape getAttackZone() {
		return attackZone;
	}

	public void setAttackZone(Shape attackZone) {
		this.attackZone = attackZone;
	}

	public AttackTimer getAttackTimer() {
		return attackTimer;
	}

	public void setAttackTimer(AttackTimer attackTimer) {
		this.attackTimer = attackTimer;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	public Stats getStats() {
		return stats;
	}
}
