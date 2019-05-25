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
	
	private int resolutionTile;
	
	public Animation(BufferedImage tileSet) {
		this.tileSet = tileSet;
		this.resolutionTile = tileSet.getHeight();
		this.maxFrames = tileSet.getWidth() / resolutionTile;
	}
	
	public void update() {
		this.currentFrame++;
		if(this.currentFrame >= this.maxFrames) {
			this.currentFrame = 0;
		}
		
		this.currentImage = tileSet.getSubimage(this.currentFrame * resolutionTile, 0, resolutionTile, resolutionTile);
	}
	
	public BufferedImage getCurrentImage() {
		return this.currentImage;
	}
}
