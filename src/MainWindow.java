import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Entity;
import entity.control.Control;
import entity.player.Player;
import map.Chunk;
import map.TileType;
import utils.Constants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private Chunk testChunk;
	
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new Renderer();
		setResizable(false);
		setContentPane(contentPane);
		setVisible(true);
		
		
		testChunk = new Chunk("10000000");
		Entity testPlayer = new Player();
		
		Control control = new Control();
		control.addListener(testPlayer);
		this.addKeyListener(control.getKeyListener());
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Renderer.drawObject(testChunk);
		g.drawImage(Renderer.canvas, 10, 32, null);
	}
	
	
}
