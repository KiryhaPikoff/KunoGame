import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle.Control;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.Coordinates;
import components.DirectionMove;
import components.UI.PlayerInterface;
import entity.DirectionMoveChange;
import entity.Entity;
import entity.control.Controller;
import entity.player.Player;
import map.Chunk;
import map.ChunkChanger;
import map.TileType;
import utils.Animation;
import utils.Constants;
import utils.Drawable;
import utils.Renderer;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private Chunk testChunk;
	private Player testPlayer;
	
	private PlayerInterface playerInterface;
	
	public MainWindow() {
		this.initWindow();
		this.initEntitys();
		this.initController();
		this.initRenderer();
		this.initMoveTimer();
		this.initAnimTimer();
	}
	
	public void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new Renderer();
		setContentPane(contentPane);
		setResizable(false);
		setVisible(true);
	}
	
	private void initEntitys() {
		testChunk = new Chunk("10000000");
		testPlayer = new Player();
		playerInterface = new PlayerInterface(testPlayer);
	}
	
	private void initController() {
		Controller.setKeyListener(testPlayer);
		this.addKeyListener(Controller.getKeyListener());
	}
	
	private void initRenderer() {
		Renderer.addObject(testChunk);
		Renderer.addObject(testPlayer);
		Renderer.addObject(playerInterface);
	//	Renderer.addObject(testPlayer.getInventory());
		Renderer.start();
	}
	
	private void initMoveTimer() {
		Timer moveTimer = new Timer(Constants.PHYSIC_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectionMoveChange.changeDirectionMove(testPlayer);
				testPlayer.move(testChunk);
			/*	ChunkChanger.changeChunk(testChunk, testPlayer);
				System.out.println(testChunk.hashCode());*/
				if(testChunk.getTileXY(testPlayer.getCurrentCoordinate().getX(), testPlayer.getCurrentCoordinate().getY()).getTileType() == TileType.door) {
					if(testPlayer.getCurrentCoordinate().getX() >= Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 5) {
						testChunk = new Chunk(testChunk.hashCode(), DirectionMove.EAST);
						testPlayer.setCurrentCoordinate(new Coordinates(30, testPlayer.getCurrentCoordinate().getY()));
						Renderer.addObject(testChunk);
						return;
					}
					if(testPlayer.getCurrentCoordinate().getX() <= 5) {
						testChunk = new Chunk(testChunk.hashCode(), DirectionMove.WEST);
						testPlayer.setCurrentCoordinate(new Coordinates(Constants.SIZE_TILE * Constants.WIDTH_CHUNK - 30, testPlayer.getCurrentCoordinate().getY()));
						Renderer.addObject(testChunk);
						return;
					}
					if(testPlayer.getCurrentCoordinate().getY() <= 25) {
						testChunk = new Chunk(testChunk.hashCode(), DirectionMove.NORTH);
						testPlayer.setCurrentCoordinate(new Coordinates(testPlayer.getCurrentCoordinate().getX(), Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 30));
						Renderer.addObject(testChunk);
						return;
					}
					if(testPlayer.getCurrentCoordinate().getY() >= Constants.SIZE_TILE * Constants.HEIGHT_CHUNK - 5) {
						testChunk = new Chunk(testChunk.hashCode(), DirectionMove.SOUTH);
						testPlayer.setCurrentCoordinate(new Coordinates(testPlayer.getCurrentCoordinate().getX(), 30));
						Renderer.addObject(testChunk);
						return;
					}	
				}
			}
		});
		moveTimer.start();
	}
	
	private void initAnimTimer() {
		Timer animationTimer = new Timer(Constants.ANIMATION_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animation.animation(testPlayer);
			}
		});
		animationTimer.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(Renderer.canvas, 2, 26, null);
		repaint();
	}
}
