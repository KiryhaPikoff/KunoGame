package myTestPackage.entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import myTestPackage.Action;
import myTestPackage.CircleZone;
import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.RectangleZone;
import myTestPackage.components.GameInteface.HealthPointsBar;
import myTestPackage.components.direction.Directed;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.entity.components.Stats;
import myTestPackage.entity.monster.Attacking;
import myTestPackage.mover.Movable;
import myTestPackage.renderer.Animated;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.AttackTimer;

public abstract class Entity implements Directed, Drawable, Movable, Animated, Serializable, Attacking {
	
	protected String name;
	protected boolean isTarget = false;
	protected boolean canAttack = false;
	
	protected CircleZone thisCoordZone; // зона для выделения по кликам
	protected RectangleZone movableZone;

	protected Shape pursuitZone;
	protected Shape attackZone;

	protected HealthPointsBar healthPointsBar;
	protected AttackTimer attackTimer;
	
	protected Action action;
	
	protected Stats stats;
	protected Coordinates coordinates;
	protected DirectionMovement directionMovement;

	protected transient BufferedImage image;
	protected Animation animUP;
	protected Animation animDOWN;
	protected Animation animLEFT;
	protected Animation animRIGHT;
	
	protected Entity target;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
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

	public Stats getStats() {
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
}
