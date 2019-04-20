package myTestPackage.map;

import java.awt.Image;

import myTestPackage.utils.ImageLoader;

public enum TileType {
	
	ground("ground", ImageLoader.loadImage("resources/images/ground64t.png"), true),
	water("water", ImageLoader.loadImage("resources/images/water64t.png"), false),
	road("road", ImageLoader.loadImage("resources/images/road64t.png"), true),
	door("door", ImageLoader.loadImage("resources/images/road64t.png"), true),
	treeLi("treeLi", ImageLoader.loadImage("resources/images/treeListv_1_64.png"), false),
	treeEl("treeEl", ImageLoader.loadImage("resources/images/treeEl_1_64.png"), false);
	
	private String type;
	private Image image;
	private boolean isPassable;
	
	TileType(String type, Image image, boolean isPassable) {
		this.type = type;
		this.image = image;
		this.isPassable = isPassable;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public boolean isPassable() {
		return this.isPassable;
	}
}
