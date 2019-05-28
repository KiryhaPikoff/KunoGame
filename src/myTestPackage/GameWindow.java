package myTestPackage;

import myTestPackage.components.direction.DirectionChanger;
import myTestPackage.components.keyboard.KeyboardKey;

import myTestPackage.entity.monster.Monster;
import myTestPackage.entity.monster.MonsterAction;
import myTestPackage.entity.monster.Spawner;
import myTestPackage.entity.player.Player;
import myTestPackage.map.Chunk;
import myTestPackage.mover.Mover;
import myTestPackage.panel.GameMenu;
import myTestPackage.panel.StartMenu;
import myTestPackage.renderer.AnimationUpdater;
import myTestPackage.renderer.Renderer;
import myTestPackage.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class GameWindow extends JFrame implements Serializable {
	private String nameFirstChunk;
	private Chunk currentChunk;
	private Player testPlayer;
	private List<Monster> monsterList;
	private Collection<Integer> chunkHashCodeList;

	private Renderer renderer;
	private Mover mover;
	private AnimationUpdater animationUpdater;
    private Timer physicTimer;

    private GameMenu gameMenu;
    private StartMenu startMenu;

	private KeyListener playerKeyListener;
	private MouseListener playerMouseListener;

	private boolean isOpenMenu = false;
	private boolean isStartMenu = true;

	public GameWindow() {
		renderer = new Renderer();
		renderer.start();
		mover = new Mover();
		animationUpdater = new AnimationUpdater();

        monsterList = new ArrayList<Monster>();
        chunkHashCodeList = new HashSet<Integer>();
        nameFirstChunk = "10000000";

        gameMenu = new GameMenu(new Coordinates(200, 200));
        this.getContentPane().add(gameMenu);
        gameMenu.setVisible(false);

        startMenu = new StartMenu(new Coordinates(200, 200));
        this.getContentPane().add(startMenu);
        startMenu.setVisible(true);
        renderer.addObject(startMenu);

        this.initWindow();

		this.initKeyListener();
		this.initMouseListener();

		this.initWindowListener();
		//this.startGame();
	}

	private void initWindowListener() {
		this.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				for (Integer hashCode : chunkHashCodeList) {
					File file = new File("resources//saves//tempSave//" + hashCode + ".txt");
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
		mover.addEntityToChangeDirectionList(tempMonster);
		animationUpdater.addEntity(tempMonster);
		renderer.addObject(tempMonster);
	}
	
	private void deleteMonster(Monster monster) {
		renderer.deleteObject(monster);
		mover.deleteEntity(monster);
		animationUpdater.deleteEntity(monster);
		monster.getAttackTimer().stopAttackTimer();
		testPlayer.getStats().setScore(testPlayer.getStats().getScore() + monster.getStats().getScore());
		this.monsterList.remove(monster);
	}

	private void deleteMonsterInAllComponent(Monster monster) {
		renderer.deleteObject(monster);
		mover.deleteEntity(monster);
		animationUpdater.deleteEntity(monster);
		monster.getAttackTimer().stopAttackTimer();
	}
	
	private void spawnPlayer() {
		this.testPlayer = new Player(new Coordinates(500, 500));
		renderer.addObject(testPlayer);
		animationUpdater.addEntity(this.testPlayer);
	}
	
	private void initFirstChunk() {
		this.currentChunk = new Chunk(this.nameFirstChunk);
		renderer.addObject(currentChunk);
	}
	
	private void initWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setLayout(null);
		this.setResizable(true);
		this.setVisible(true);
	}

	private void initGameComponents() {
		this.initFirstChunk();
		this.spawnPlayer();

		spawnMonster();
		spawnMonster();
		spawnMonster();
		spawnMonster();

	}
	
	private void initPhysicTimer() {
		physicTimer = new Timer(Constants.PHYSIC_SPEED, new ActionListener() { /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */
			public void actionPerformed(ActionEvent e) {
				if(testPlayer.stats().getCurrentHealthPoints() <= 0 || testPlayer.getStats().getScore() == 500) {
					System.exit(1);
				}
				if (CollisionChecker.canMove(testPlayer, currentChunk)) {
					mover.moveObject(testPlayer);
				}

				if(ChunkChanger.canChangeChunk(currentChunk, testPlayer) != null) { /* типо если есть возможность поменять чанк */
					SaveLoadGame.saveMonster(monsterList, currentChunk);

					if (!chunkHashCodeList.contains(currentChunk.hashCode())) {
						chunkHashCodeList.add(currentChunk.hashCode());
						System.out.println("Save " + currentChunk.hashCode());
					}

					currentChunk = ChunkChanger.changeChunk(currentChunk, ChunkChanger.canChangeChunk(currentChunk, testPlayer), testPlayer);
					renderer.addObject(currentChunk);

					while (0 < monsterList.size()) {
						deleteMonster(monsterList.get(0));
					}

					try {
						SaveLoadGame.loadMonster(monsterList, currentChunk);



						for (Monster monster : monsterList) {
							mover.addEntityToChangeDirectionList(monster);
							animationUpdater.addEntity(monster);
							renderer.addObject(monster);
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
						mover.moveObject(monster);
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

                /*if (e.getKeyCode() == 112) {
					System.out.println(e.getKeyCode());
                    start();

                }

                if (e.getKeyCode() == 113) {
					System.out.println(e.getKeyCode());
					finish();
                }*/

                if (e.getKeyCode() == 27) {
                	if (!isOpenMenu) {
                		finish();
                		isOpenMenu = true;
					} else {
                		start();
                		isOpenMenu = false;
					}

                	if (isStartMenu) {
                		initGameComponents();
                		initPhysicTimer();
                		startGame();
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

	private void startGame() {
		mover.start();
		physicTimer.start();
		animationUpdater.start();
	}

	private void start() {
		gameMenu.setVisible(false);
		renderer.deleteObject(gameMenu);

		for (Monster monster : monsterList) {
			mover.addEntityToChangeDirectionList(monster);
			animationUpdater.addEntity(monster);
			renderer.addObject(monster);
		}

		mover.start();
		physicTimer.start();
		animationUpdater.start();
	}

	private void finish() {
	    gameMenu.setGameObject(testPlayer, monsterList, currentChunk, this);
	    gameMenu.setVisible(true);
	    renderer.addObject(gameMenu);

		for (Monster monster : monsterList) {
			deleteMonsterInAllComponent(monster);
		}

		mover.stop();
		physicTimer.stop();
		animationUpdater.stop();
    }
	
	public void paint(Graphics g) {
		g.drawImage(renderer.canvas, 2, 26, null);
		repaint();
	}

}
