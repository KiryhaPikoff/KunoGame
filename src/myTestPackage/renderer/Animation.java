package myTestPackage.renderer;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageLoader;

public final class Animation implements Serializable {
	private transient BufferedImage tileSet;
	private transient BufferedImage currentImage;
	private int currentFrame;
	private int maxFrames;
	
	public Animation(BufferedImage tileSet) {
		this.tileSet = tileSet;
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
