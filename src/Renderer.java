import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import utils.Drawable;
import utils.ImageLoader;

public class Renderer extends JPanel {
	
	public static Image canvas = ImageLoader.loadImage("resources/images/default.png");
	public static Graphics bufferCanvas = canvas.getGraphics();
	
	public static void drawObject(Object obj) {
		if(obj instanceof Drawable) {
			((Drawable) obj).paint(bufferCanvas);
		}
	}
}
