package myTestPackage.entity.player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import myTestPackage.Action;
import myTestPackage.CircleZone;
import myTestPackage.Coordinates;
import myTestPackage.RectangleZone;
import myTestPackage.components.GameInteface.HealthPointsBar;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.components.keyboard.ConditionMoveKeys;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.components.keyboard.KeyboardKeyAction;
import myTestPackage.entity.Bullet;
import myTestPackage.entity.Entity;
import myTestPackage.entity.components.Stats;
import myTestPackage.renderer.Animation;
import myTestPackage.utils.AttackTimer;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageStorage;

public final class Player extends Entity implements Serializable {

	private ConditionMoveKeys conditionMoveKeys;
	private List<KeyboardKey> conditionSpellKeys;
	private List<Bullet> bulletList;

	public Player(Coordinates coordinates) {
		this.name = "mainPlayer";
		this.scoreFont = new Font("TimesRoman", Font.BOLD, 18);


		this.bulletList = new ArrayList<Bullet>();

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
		this.setConditionSpellKeys(new ArrayList<KeyboardKey>());
		this.initKeyButtons();
		
		this.setThisCoordZone(new CircleZone(Constants.SIZE_TILE / 2, new Coordinates(this.stats.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - Constants.SIZE_TILE / 2)));
		
		this.initAnimations();
		this.initMoveKeys();
		this.movableZone = new RectangleZone(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SIZE_TILE / 2);
		this.setDirectionMovement(DirectionMovement.STAND);
	}



	private void initKeyButtons() {
		KeyboardKey key1 = new KeyboardKey(32/* клавиша 1 на клаве сверху */, new KeyboardKeyAction() {
			public void execute() {
				if (canAttack) {
					attack();
					canAttack = false;
				}
			}
		}); 
		
		this.getConditionSpellKeys().add(key1);
	}
	
	private void initAnimations() {
		this.image = ImageStorage.PLAYER_TS_DOWN.getSubimage(Constants.RESOLUTION_TILE, 0, Constants.RESOLUTION_TILE, Constants.RESOLUTION_TILE);
		animUP = new Animation(ImageStorage.PLAYER_TS_UP);
		animDOWN = new Animation(ImageStorage.PLAYER_TS_DOWN);
		animLEFT = new Animation(ImageStorage.PLAYER_TS_LEFT);
		animRIGHT = new Animation(ImageStorage.PLAYER_TS_RIGHT);
	}
	
	private void initMoveKeys() {
		this.conditionMoveKeys = new ConditionMoveKeys(
		new KeyboardKey(KeyEvent.VK_W),
		new KeyboardKey(KeyEvent.VK_S),
		new KeyboardKey(KeyEvent.VK_A),
		new KeyboardKey(KeyEvent.VK_D));
	}
	
	public void changeDirection() {
		if(conditionMoveKeys.getKeyboardKeyUP().isPressed()) this.setDirectionMovement(DirectionMovement.NORTH);
		if(conditionMoveKeys.getKeyboardKeyDOWN().isPressed()) this.setDirectionMovement(DirectionMovement.SOUTH);
		if(conditionMoveKeys.getKeyboardKeyLEFT().isPressed()) this.setDirectionMovement(DirectionMovement.WEST);
		if(conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.EAST);
		
		if(conditionMoveKeys.getKeyboardKeyUP().isPressed() && conditionMoveKeys.getKeyboardKeyLEFT().isPressed()) this.setDirectionMovement(DirectionMovement.NORTH_WEST);
		if(conditionMoveKeys.getKeyboardKeyUP().isPressed() && conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.NORTH_EAST);
		if(conditionMoveKeys.getKeyboardKeyDOWN().isPressed() && conditionMoveKeys.getKeyboardKeyLEFT().isPressed()) this.setDirectionMovement(DirectionMovement.SOUTH_WEST);
		if(conditionMoveKeys.getKeyboardKeyDOWN().isPressed() && conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.SOUTH_EAST);
	
		if( !conditionMoveKeys.getKeyboardKeyUP().isPressed() &&
			!conditionMoveKeys.getKeyboardKeyDOWN().isPressed() &&
			!conditionMoveKeys.getKeyboardKeyLEFT().isPressed() && 
			!conditionMoveKeys.getKeyboardKeyRIGHT().isPressed()) this.setDirectionMovement(DirectionMovement.STAND);
	}
	
	public void updateAnimation() {
		if(this.action == Action.MOVE) {	
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
	}

	public void paint(Graphics g) {
		if(this.isTarget()) {
			g.setColor(new Color(69, 200, 36));
			g.drawOval(this.stats.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - Constants.SIZE_TILE / 2, Constants.SIZE_TILE, Constants.SIZE_TILE);
		}

		for (Bullet elem : bulletList) {
			elem.paint(g);
		}

		healthPointsBar.paint(g);
		g.setFont(scoreFont);
		g.drawString("score: " + stats.getScore(), 20, 20);
		g.drawImage(this.image, this.stats.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - Constants.SIZE_TILE / 2, null);
	}
	
	public void move() {
		if(this.action == Action.MOVE) {			
			this.stats.getCoordinates().setPointXY(this.stats.getCoordinates().getX() + this.directionMovement.getOffsetX(), this.stats.getCoordinates().getY() + this.directionMovement.getOffsetY());
			this.getThisCoordZone().updateCoordinates(new Coordinates(this.stats.getCoordinates().getX() - Constants.SIZE_TILE / 2, this.stats.getCoordinates().getY() - Constants.SIZE_TILE / 2));
		}

		if (target != null) {
			int i = 0;
			while (i < bulletList.size()) {
				if (target.getAttackZone().contains(bulletList.get(i).getCoordinates().getX(), bulletList.get(i).getCoordinates().getY())) {
					target.stats().setCurrentHealthPoints(target.stats().getCurrentHealthPoints() - stats.getDamage());
					bulletList.remove(i);
				} else {
					if (target.stats().getCurrentHealthPoints() <= 0) {
						target.setAction(Action.DEAD);
					}
					bulletList.get(i).move();
					i++;
				}
			}
		}
	}

	public ConditionMoveKeys getConditionMoveKeys() {
		return conditionMoveKeys;
	}

	public List<KeyboardKey> getConditionSpellKeys() {
		return conditionSpellKeys;
	}

	private void setConditionSpellKeys(List<KeyboardKey> conditionSpellKeys) {
		this.conditionSpellKeys = conditionSpellKeys;
	}

	private Player getPlayer() {
		return this;
	}

	public void attack() {
		bulletList.add(new Bullet(getPlayer(), target, 10));
	}
}
