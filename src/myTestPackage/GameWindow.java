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
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import myTestPackage.entity.components.Stats;
import myTestPackage.entity.monster.MonsterAction;
import myTestPackage.utils.Constants;
import myTestPackage.components.direction.DirectionChanger;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.entity.player.Player;
import myTestPackage.entity.Entity;
import myTestPackage.entity.monster.Monster;
import myTestPackage.entity.monster.MonsterFabrica;
import myTestPackage.entity.monster.Spawner;
import myTestPackage.map.Chunk;
import myTestPackage.mover.Movable;
import myTestPackage.mover.Mover;
import myTestPackage.renderer.AnimationUpdater;
import myTestPackage.renderer.Renderer;

import static javax.swing.text.html.HTML.Tag.HEAD;

public class GameWindow extends JFrame implements Serializable {
	private String nameFirstChunk = "10000000";
	private Chunk currentChunk;
	private Player testPlayer;
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
	
	private void deleteMonster(Monster monster) {
		Renderer.deleteObject(monster);
		Mover.deleteEntity(monster);
		AnimationUpdater.deleteEntity(monster);
		this.monsterList.remove(monster);
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
                    MonsterAction.interaction(monster, testPlayer);
					if(monster.getAction() == Action.DEAD) {
						System.out.println("OK!!");
						deleteMonster(monster);

						break;

					}
					
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
					if(numPressedKey == playerKey.getID()) {
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
					if(numPressedKey == playerKey.getID()) {
						playerKey.setPressed(false);
						DirectionChanger.changeObjectDirection(testPlayer);
					}
				}
				
				for (KeyboardKey playerKey : testPlayer.getConditionSpellKeys()) {
					if(numPressedKey == playerKey.getID()) {
						playerKey.execute();
					}
				}

				if(e.getKeyCode() == 112) {
					saveGame();
				}

				if(e.getKeyCode() == 113) {
					loadGame();
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
					for (Monster monster : monsterList) {
						if(monster.getThisCoordZone().inZone(e.getX() - Constants.SIZE_TILE / 2, e.getY() - Constants.SIZE_TILE / 2 - 26)) {
							if(testPlayer.getTarget() != null) {
								testPlayer.getTarget().setTarget(false);
							}
							monster.setTarget(true);
							testPlayer.setTarget(monster);
							break;
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

	public void saveGame() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("save.txt")));
			objectOutputStream.writeObject(testPlayer.getCoordinates());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadGame() {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(new File("save.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			testPlayer.setCoordinates((Coordinates)objectInputStream.readObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
