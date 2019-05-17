package myTestPackage.renderer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import myTestPackage.Drawable;
import myTestPackage.entity.player.Player;
import myTestPackage.map.Chunk;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageLoader;

public abstract class Renderer extends JPanel {
	transient public static Image canvas = ImageLoader.loadImage("resources/images/default.png");  // холст 2ой буферизации, он в итоге отрис. на экран
	transient public static Graphics bufferCanvas = canvas.getGraphics();

	transient public static Image chunkImage;  // срендереная картинка чанка
	transient public static List<Object> entitysList = new ArrayList<Object>();
	
	public static void start() {
		Timer drawTimer = new Timer(Constants.DRAWER_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) { /* здесь можно задать порядок отрисовки объектов(по классам) */
				bufferCanvas.drawImage(chunkImage, 0, 0, null);
				for (Object object : entitysList) {
					((Drawable) object).paint(bufferCanvas);
				}
			}
		});
		drawTimer.start();
	}
	
	public static void addObject(Object object) { 
		if(object instanceof Chunk) {
			chunkImage = ((Chunk) object).getRenderedChunk();
			return;
		}
		if(object instanceof Drawable) {
			entitysList.add(object);
		}
	}
	public static void deleteObject(Object object) {
		if(object instanceof Drawable) {
			entitysList.remove(object);
		}
	}
	/*
	public static void deleteObjects(List<Object> objects) {
		for (Object object : objects) {			
			if(object instanceof Drawable) {
				entitysList.remove(object);
			}
		}
	}*/
}
