package myTestPackage.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {
	public static BufferedImage loadImage(String nameFile) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(nameFile));
			System.out.println(nameFile + ": was successfully loaded");
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image: " + nameFile + " can`t loaded!");
		} 
		return img;
	}
}
