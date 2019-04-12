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

import components.UI.PlayerInterface;
import entity.DirectionMoveChange;
import entity.Entity;
import entity.control.Controller;
import entity.player.Player;
import map.Chunk;
import map.TileType;
import utils.Constants;
import utils.Drawable;

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
		this.initTimer();
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
	
	private void initTimer() {
		Timer moveTimer = new Timer(Constants.PHYSIC_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectionMoveChange.changeDirectionMove(testPlayer);
				testPlayer.move();
			}
		});
		moveTimer.start();
	}
	
	public void paint(Graphics g) {
		g.drawImage(Renderer.canvas, 2, 26, null);
		repaint();
	}
}
