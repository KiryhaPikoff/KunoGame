package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {
	public static Image loadImage(String nameFile) {
		Image img = null;
		try {
			img = ImageIO.read(new File(nameFile));
			System.out.println(nameFile + ": was successfully loaded");
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image can`t loaded!");
		} 
		return img;
	}
}
