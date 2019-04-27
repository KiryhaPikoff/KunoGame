package myTestPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import myTestPackage.utils.Constants;
import myTestPackage.components.direction.DirectionChanger;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.entity.player.Player;
import myTestPackage.entity.Entity;
import myTestPackage.entity.Monster.Monster;
import myTestPackage.entity.Monster.MonsterFabrica;
import myTestPackage.entity.Monster.Spawner;
import myTestPackage.map.Chunk;
import myTestPackage.mover.Mover;
import myTestPackage.renderer.AnimationUpdater;
import myTestPackage.renderer.Renderer;

public class GameWindow extends JFrame {	
	private String nameFirstChunk = "10000000";
	private Chunk currentChunk;
	private Player testPlayer;
	private Monster testMonster;
	private List<Monster> monsterList = new ArrayList<Monster>();
	
	private KeyListener playerKeyListener;
	private MouseListener playerMouseListener;

	public GameWindow() {
		this.initWindow();
		AnimationUpdater.startUpdAllAnimations();
		Mover.startRandomizeDirectionsForMonsters();
		this.initGameComponents();
		this.initKeyListener();
		this.initMouseListener();
		this.initPhysicTimer();
		
	}
	
	private void spawnMonster() {
		Monster tempMonster = Spawner.spawnMonster(currentChunk);
		monsterList.add(tempMonster);
		Mover.addEntityToChangeDirectionList(tempMonster);
		AnimationUpdater.addEntity(tempMonster);
		Renderer.addObject(tempMonster);
	}
	
	private void spawnPlayer() {
		this.testPlayer = new Player(new Coordinates(500, 500));
		Renderer.addObject(testPlayer);
		AnimationUpdater.addEntity(this.testPlayer);
	}
	
	private void initFirstChunk() {
		this.currentChunk = new Chunk(this.nameFirstChunk);
		Renderer.addObject(currentChunk);
	}
	
	private void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
	}
	
	public void initGameComponents() {
		this.initFirstChunk();
		this.spawnPlayer();
		this.spawnMonster();
		this.spawnMonster();
		this.spawnMonster();
		this.spawnMonster();
		this.spawnMonster();
		this.spawnMonster();		
	}
	
	private void initPhysicTimer() {
		Timer physicTimer = new Timer(Constants.PHYSIC_SPEED, new ActionListener() { /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */
			public void actionPerformed(ActionEvent e) {
				if (CollisionChecker.canMove(testPlayer, currentChunk)) {
					Mover.moveObject(testPlayer);
				}
				
				for (Monster monster : monsterList) {
					if (CollisionChecker.canMove(monster, currentChunk)) {
						Mover.moveObject(monster);
					}
				}

				if(ChunkChanger.canChangeChunk(currentChunk, testPlayer) != null) { /* типо если есть возможность поменять чанк */
					currentChunk = ChunkChanger.changeChunk(currentChunk, ChunkChanger.canChangeChunk(currentChunk, testPlayer), testPlayer);
					Renderer.addObject(currentChunk);
				}
			}
		});
		physicTimer.start();
	}
	
	private void initKeyListener() { /* Система прослушивания клавиш */
		this.playerKeyListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int numPressedKey = e.getKeyCode();
				for (KeyboardKey playerKey : testPlayer.getConditionMoveKeys().getKeyboardKeys()) {
					if(numPressedKey == playerKey.getKey()) {
						if(!playerKey.isPressed()) {
							playerKey.setPressed(true);
							DirectionChanger.changeObjectDirection(testPlayer);
						} 
					}
				}
			}
			public void keyReleased(KeyEvent e) {
				int numPressedKey = e.getKeyCode();
				for (KeyboardKey playerKey : testPlayer.getConditionMoveKeys().getKeyboardKeys()) {
					if(numPressedKey == playerKey.getKey()) {
						playerKey.setPressed(false);
						DirectionChanger.changeObjectDirection(testPlayer);
					}
				}
			}
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}	
			
		};
		this.addKeyListener(this.playerKeyListener);
	}
	
	private void initMouseListener() {
		this.playerMouseListener = new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) { // ПКМ
					System.out.println(e.getX() + " " + e.getY());
					System.out.println();
					for (Monster monster : monsterList) {
						System.out.println(monster.getCoordinates().getX() + " " + monster.getCoordinates().getY());
						if(monster.getThisCoordZone().inZone(e.getX() - Constants.SIZE_TILE / 2, e.getY() - Constants.SIZE_TILE / 2 - 26)) {
							if(testPlayer.getTarget() != null) {
								testPlayer.getTarget().setTarget(false);
							}
							monster.setTarget(true);
							testPlayer.setTarget(monster);
						}
					}
				}
			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addMouseListener(this.playerMouseListener);
	}

	public void start() {	
		Renderer.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(Renderer.canvas, 2, 26, null);
		repaint();
	}
}
