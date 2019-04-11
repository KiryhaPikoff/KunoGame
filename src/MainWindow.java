import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import map.Chunk;
import map.TileType;
import utils.Constants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.WINDOW_POZITION_X, Constants.WINDOW_POZITION_Y,
				  Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new Renderer();
		setContentPane(contentPane);
		setVisible(true);
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Renderer.drawObject(new Chunk("10010000"));
		g.drawImage(Renderer.canvas, 10, 32, null);
	}
}
