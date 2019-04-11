package map;

import java.awt.Image;

import utils.ImageLoader;

public enum TileType {
	ground("ground", ImageLoader.loadImage("resources/images/ground64t.png")),
	water("water", ImageLoader.loadImage("resources/images/water64t.png")),
	road("road", ImageLoader.loadImage("resources/images/road64t.png")),
	door("door", ImageLoader.loadImage("resources/images/road64t.png"));
	
	private String type;
	private Image image;
	
	TileType(String type, Image image) {
		this.type = type;
		this.image = image;
	}
	
	public Image getImage() {
		return this.image;
	}
}
