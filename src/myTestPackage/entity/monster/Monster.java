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

public class Monster extends Entity {

	public Monster() {
		this.coordinates = new Coordinates();
		this.stats = new Stats();
		this.target = null;
		this.action = Action.MOVE;

		this.attackTimer = new AttackTimer(2000, this);

		this.healthPointsBar = new HealthPointsBar(this);

		this.initPursuitZone();
		this.initAttackZone();

		this.initCoordinates();
		
		this.setThisCoordZone(new CircleZone(Constants.SIZE_TILE / 2, new Coordinates(this.coordinates.getX() - Constants.SIZE_TILE / 2, this.coordinates.getY() - Constants.SIZE_TILE / 2)));
		
		this.initMovableZone();
		this.setDirectionMovement(DirectionMovement.STAND);
	}
	
	public void initGraphics(BufferedImage stand, BufferedImage up, BufferedImage down, BufferedImage left, BufferedImage right) {
		this.image = stand;
		
		animUP = new Animation(up);
		animDOWN = new Animation(down);
		animLEFT = new Animation(left);
		animRIGHT = new Animation(right);
	}
	
	private void initCoordinates() {
		this.coordinates = new Coordinates(450, 500);
	}
	
	private void initMovableZone() {
		this.movableZone = new RectangleZone(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SIZE_TILE / 2);
	}

	private void initPursuitZone() {
		this.pursuitZone = new Ellipse2D.Float(this.getCoordinates().getX() - this.getStats().getRadiusPursuit() / 2,
												this.getCoordinates().getY() - this.getStats().getRadiusPursuit() / 2,
													this.getStats().getRadiusPursuit(),
													this.getStats().getRadiusPursuit());
	}
	private void initAttackZone() {
		this.attackZone = new Ellipse2D.Float(this.getCoordinates().getX() - this.getStats().getRadiusAttack() / 2,
												this.getCoordinates().getY() - this.getStats().getRadiusAttack() / 2,
													this.getStats().getRadiusAttack(),
													this.getStats().getRadiusAttack());
	}
	
	public void move() {
		this.getCoordinates().setPointXY(this.getCoordinates().getX() + this.directionMovement.getOffsetX(), this.getCoordinates().getY() + this.directionMovement.getOffsetY());
		this.getThisCoordZone().updateCoordinates(new Coordinates(this.coordinates.getX() - Constants.SIZE_TILE / 2, this.coordinates.getY() - Constants.SIZE_TILE / 2));
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
		target.getStats().setCurrentHealthPoints(target.getStats().getCurrentHealthPoints() - this.getStats().getDamage());
	}

	public void controlAttackTimer() {
		if (this.action == Action.DEAD) {
			attackTimer.stopAttackTimer();
			return;
		}

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
		if(this.isTarget()) {
			g.drawImage(ImageStorage.TARGET, this.coordinates.getX() - Constants.SIZE_TILE / 2, this.coordinates.getY() - Constants.SIZE_TILE / 2, null);
		}
		healthPointsBar.paint(g);
		g.setColor(Color.BLACK);
		g.drawOval(this.getCoordinates().getX() - this.getStats().getRadiusPursuit() / 2,
				this.getCoordinates().getY() - this.getStats().getRadiusPursuit() / 2,
				this.getStats().getRadiusPursuit(),
				this.getStats().getRadiusPursuit());
		g.drawOval(this.getCoordinates().getX() - this.getStats().getRadiusAttack() / 2,
				this.getCoordinates().getY() - this.getStats().getRadiusAttack() / 2,
				this.getStats().getRadiusAttack(),
				this.getStats().getRadiusAttack());

		g.drawImage(this.image, this.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.getCoordinates().getY() - Constants.SIZE_TILE / 2, null);
	}
}
