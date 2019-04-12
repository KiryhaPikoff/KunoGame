package utils;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import map.Chunk;

public class Renderer extends JPanel {
	
	public static Image canvas = ImageLoader.loadImage("resources/images/default.png");
	public static Graphics bufferCanvas = canvas.getGraphics();
	
	public static Image chunkImage;
	
	public static List<Object> entitysList = new ArrayList<Object>();
	
	public static void start() {
		Timer drawTimer = new Timer(Constants.DRAWER_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCanvas.drawImage(chunkImage, 0, 0, null);
				for (Object object : entitysList) {
					((Drawable) object).paint(bufferCanvas);
				}
			}
		});
		drawTimer.start();
	}
	
	public static void addObject(Object obj) {
		if(obj instanceof Chunk) {
			chunkImage = ((Chunk) obj).renderedChunk;
			return;
		}
		if(obj instanceof Drawable) {
			entitysList.add(obj);
			return;
		}
	}
	
	public static void deleteObject(Object obj) {
		if(obj instanceof Drawable) {
			entitysList.remove(obj);
		}
	}
}
