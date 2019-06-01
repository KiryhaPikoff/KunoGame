package myTestPackage.entity.monster;



import myTestPackage.Action;
import myTestPackage.CircleZone;
import myTestPackage.Coordinates;
import myTestPackage.RectangleZone;
import myTestPackage.components.GameInteface.HealthPointsBar;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.direction.DirectionPursuit;
import myTestPackage.components.direction.DirectionRandomizer;
import myTestPackage.entity.Entity;
import myTestPackage.entity.components.Stats;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.AttackTimer;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageStorage;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

/*
 * Monster объект которому противопостоит игрок - враг
 * 
 * Author: Pikov Kirill && Syaman Sergey
 */

public class Monster extends Entity {
	Monster() {
		this.stats = new Stats();
		this.target = null;
		this.action = Action.MOVE;

		this.attackTimer = new AttackTimer(1000);
		this.attackTimer.initAttackMonster(this);

		this.healthPointsBar = new HealthPointsBar(this);

		this.initCoordinates();
		this.initPursuitZone();
		this.initAttackZone();

		this.setThisCoordZone(new CircleZone(Constants.SIZE_TILE / 2, new Coordinates(this.stats.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - Constants.SIZE_TILE / 2)));
		
		this.initMovableZone();
		this.setDirectionMovement(DirectionMovement.STAND);
	}
	
	void initGraphics(BufferedImage stand, BufferedImage up, BufferedImage down, BufferedImage left, BufferedImage right) {
		this.image = stand;
		
		animUP = new Animation(up);
		animDOWN = new Animation(down);
		animLEFT = new Animation(left);
		animRIGHT = new Animation(right);
	}
	
	private void initCoordinates() {
		this.stats.setCoordinates(new Coordinates());
	}
	
	private void initMovableZone() {
		this.movableZone = new RectangleZone(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SIZE_TILE / 2);
	}

	private void initPursuitZone() {
		this.pursuitZone = new Ellipse2D.Float(this.stats.getCoordinates().getX() - this.stats.getRadiusPursuit() / 2,
												this.stats.getCoordinates().getY() - this.stats.getRadiusPursuit() / 2,
													this.stats.getRadiusPursuit(),
													this.stats.getRadiusPursuit());
	}
	private void initAttackZone() {
		this.attackZone = new Ellipse2D.Float(this.stats.getCoordinates().getX() - this.stats.getRadiusAttack() / 2,
												this.stats.getCoordinates().getY() - this.stats.getRadiusAttack() / 2,
													this.stats.getRadiusAttack(),
													this.stats.getRadiusAttack());
	}
	
	public void move() {
		this.stats.getCoordinates().setPointXY(this.stats.getCoordinates().getX() + this.directionMovement.getOffsetX(), this.stats.getCoordinates().getY() + this.directionMovement.getOffsetY());
		this.getThisCoordZone().updateCoordinates(new Coordinates(this.stats.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - Constants.SIZE_TILE / 2));
		this.initPursuitZone();
		this.initAttackZone();
	}

	public void changeDirection() {
		if (this.target == null) {	// если у нас нет таргета, то просто ходим по карте
			this.directionMovement = DirectionRandomizer.rand();
		} else {					// если у нас есть таргет, то преследуем его
			this.directionMovement = DirectionPursuit.chase(this, target);
		}
	}

	public void attack() {
		target.stats().setCurrentHealthPoints(target.stats().getCurrentHealthPoints() - this.stats().getDamage());
	}

	public void controlAttackTimer() {
		if (!canAttack) {
			attackTimer.stopAttackTimer();
		} else {
			attackTimer.startAttackTimer();
		}
	}

	public void updateAnimation() {
			switch(this.directionMovement) {
				case NORTH: {
					this.animUP.update();
					this.image = this.animUP.getCurrentImage();
					break;
				}
					
				case SOUTH: {
					this.animDOWN.update();
					this.image = this.animDOWN.getCurrentImage();
					break;
				}
				
				case WEST:
				case NORTH_WEST:
				case SOUTH_WEST: {
					this.animLEFT.update();
					this.image = this.animLEFT.getCurrentImage();
					break;
				}
				
				case EAST: 
				case NORTH_EAST:
				case SOUTH_EAST: {
					this.animRIGHT.update();
					this.image = this.animRIGHT.getCurrentImage();
					break;
				}
			} 
	}

	public void paint(Graphics g) {
		healthPointsBar.paint(g);
		g.setColor(Color.BLACK);
		if(this.isTarget()) {
			g.drawImage(ImageStorage.TARGET, this.stats.getCoordinates().getX() - Constants.SIZE_TILE, this.stats.getCoordinates().getY() - Constants.SIZE_TILE, null);
		}
		g.drawImage(this.image, this.stats.getCoordinates().getX() - this.image.getWidth() / 2, this.stats.getCoordinates().getY() - this.image.getWidth() / 2, null);

	}
}
