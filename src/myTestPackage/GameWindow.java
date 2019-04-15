package myTestPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import myTestPackage.utils.Constants;
import myTestPackage.components.direction.DirectionChanger;
import myTestPackage.components.keyboard.KeyboardKey;
import myTestPackage.entity.player.Player;
import myTestPackage.entity.Entity;
import myTestPackage.map.Chunk;
import myTestPackage.mover.Mover;
import myTestPackage.renderer.Renderer;

public class GameWindow extends JFrame {	
	private String firstChunk = "10000000";
	private Chunk currentChunk;
	private Player testPlayer;
	
	private KeyListener keyListener;

	public GameWindow() {
		this.initWindow();
		this.initGameComponents();
		this.initKeyListener();
		this.initMover();
		this.initRender();
	}
	
	private void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
	}
	
	public void initGameComponents() {
		this.currentChunk = new Chunk(this.firstChunk);
		this.testPlayer = new Player();
	}
	
	private void initRender() {
		Renderer.addObject(currentChunk);
		Renderer.addObject(testPlayer);
	}
	
	private void initMover() {
		Timer moveTimer = new Timer(Constants.DRAWER_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) { /* здесь можно задать порядок отрисовки объектов(по классам) */
				Mover.moveObject(testPlayer);
			}
		});
		moveTimer.start();
	}
	
	private void initKeyListener() { /* Система прослушивания клавиш */
		this.keyListener = new KeyListener() {
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
		this.addKeyListener(this.keyListener);
	}
	
	public void start() {	
		Renderer.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(Renderer.canvas, 2, 26, null);
		repaint();
	}
}
