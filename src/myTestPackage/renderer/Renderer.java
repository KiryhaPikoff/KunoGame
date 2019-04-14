package myTestPackage.renderer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import myTestPackage.map.Chunk;
import utils.Constants;
import utils.Drawable;
import utils.ImageLoader;

public class Renderer {
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
	
	public static void addObject(Object object) { /* здесь можно задать порядок отрисовки оюъектов(по классам) */
		if(object instanceof Chunk) {
			chunkImage = ((Chunk) object).renderedChunk;
			return;
		}
		if(object instanceof Drawable) {
			entitysList.add(object);
			return;
		}
	}
	
	public static void deleteObject(Object object) {
		if(object instanceof Drawable) {
			entitysList.remove(object);
		}
	}
	
	public static void deleteObjects(List<Object> objects) {
		for (Object object : objects) {			
			if(object instanceof Drawable) {
				entitysList.remove(object);
			}
		}
	}
}
