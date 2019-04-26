package myTestPackage.renderer;

import java.awt.image.BufferedImage;

import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageLoader;

public final class Animation {
	private BufferedImage tileSet;
	private BufferedImage currentImage;
	private int currentFrame;
	private int maxFrames;
	
	public Animation(String tileSetFilePath) {
		this.tileSet = ImageLoader.loadImage(tileSetFilePath);
		this.maxFrames = tileSet.getWidth() / Constants.RESOLUTION_TILE;
	}
	
	public void update() {
		this.currentFrame++;
		if(this.currentFrame >= this.maxFrames) {
			this.currentFrame = 0;
		}
		
		this.currentImage = tileSet.getSubimage(this.currentFrame * Constants.RESOLUTION_TILE, 0, Constants.RESOLUTION_TILE, Constants.RESOLUTION_TILE);
	}
	
	public BufferedImage getCurrentImage() {
		return this.currentImage;
	}
}
