package myTestPackage;

import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import myTestPackage.entity.monster.MonsterAction;
import myTestPackage.utils.Constants;
import myTestPackage.components.direction.DirectionChanger;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.entity.player.Player;
import myTestPackage.entity.monster.Monster;
import myTestPackage.entity.monster.Spawner;
import myTestPackage.map.Chunk;
import myTestPackage.mover.Mover;
import myTestPackage.renderer.AnimationUpdater;
import myTestPackage.renderer.Renderer;

public class GameWindow extends JFrame implements Serializable {
	private String nameFirstChunk = "10000000";
	private Chunk currentChunk;
	private Player testPlayer;
	private List<Monster> monsterList = new ArrayList<Monster>();
	private Collection<Integer> chunkHashCodeList = new HashSet<Integer>();
	
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
		this.initWindowListener();
		this.start();
	}

	private void initWindowListener() {
		this.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				for (Integer hashCode : chunkHashCodeList) {
					File file = new File("resources/saves/tempSave/" + hashCode + ".txt");
                    if(file.delete()){
                        System.out.println(file.getName() + " is deleted!");
                    }else{
                        System.out.println("Delete failed: File didn't delete");
                    }
				}
			}

			public void windowClosed(WindowEvent e) {

			}

			public void windowIconified(WindowEvent e) {

			}

			public void windowDeiconified(WindowEvent e) {

			}

			public void windowActivated(WindowEvent e) {

			}

			public void windowDeactivated(WindowEvent e) {

			}
		});
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
		monster.getAttackTimer().stopAttackTimer();
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void initGameComponents() {
		this.initFirstChunk();
		this.spawnPlayer();

		spawnMonster();
		spawnMonster();
		spawnMonster();
		spawnMonster();

	}
	
	private void initPhysicTimer() {
		Timer physicTimer = new Timer(Constants.PHYSIC_SPEED, new ActionListener() { /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */
			public void actionPerformed(ActionEvent e) {
				if(testPlayer.getStats().getCurrentHealthPoints() <= 0) {
					//System.exit(1);
				}
				if (CollisionChecker.canMove(testPlayer, currentChunk)) {
					Mover.moveObject(testPlayer);
				}

				if(ChunkChanger.canChangeChunk(currentChunk, testPlayer) != null) { /* типо если есть возможность поменять чанк */
					SaveLoadGame.saveMonster(monsterList, currentChunk);

					if (!chunkHashCodeList.contains(currentChunk.hashCode())) {
						chunkHashCodeList.add(currentChunk.hashCode());
						System.out.println("Save " + currentChunk.hashCode());
					}

					currentChunk = ChunkChanger.changeChunk(currentChunk, ChunkChanger.canChangeChunk(currentChunk, testPlayer), testPlayer);
					Renderer.addObject(currentChunk);

					while (0 < monsterList.size()) {
						deleteMonster(monsterList.get(0));
					}

					try {
						SaveLoadGame.loadMonster(monsterList, currentChunk);



						for (Monster monster : monsterList) {
							Mover.addEntityToChangeDirectionList(monster);
							AnimationUpdater.addEntity(monster);
							Renderer.addObject(monster);
						}
					} catch (Exception e1) {
						System.out.println("нет файла с монстрами на чанке " + currentChunk.hashCode());
						spawnMonster();
						spawnMonster();
						spawnMonster();
						spawnMonster();

					}


				}
				
				
				for (Monster monster : monsterList) {

					if(monster.getAction() == Action.DEAD) {
						System.out.println("OK!!");
						deleteMonster(monster);
						break;
					}
					
					if (CollisionChecker.canMove(monster, currentChunk)) {
						Mover.moveObject(monster);
					}

					MonsterAction.interaction(monster, testPlayer);
					monster.controlAttackTimer();
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

	//public void

	public void start() {	
		Renderer.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(Renderer.canvas, 2, 26, null);
		repaint();
	}

}
