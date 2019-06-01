package myTestPackage.map;

import java.awt.Image;

import myTestPackage.utils.ImageLoader;

/*
 * TileType типы тайлов
 * 
 * Author: Pikov Kirill
 */

public enum TileType {
	ground("ground", ImageLoader.loadImage("resources/images/ground64.png"), true),
	water("water", ImageLoader.loadImage("resources/images/water64.png"), false),
	road("road", ImageLoader.loadImage("resources/images/road64.png"), true),
	door("door", ImageLoader.loadImage("resources/images/road64.png"), true),
	treeLi("treeLi", ImageLoader.loadImage("resources/images/treeListv_1_64_ch.png"), false),
	treeEl("treeEl", ImageLoader.loadImage("resources/images/treeEl_1_64_ch.png"), false);
	
	private String type;
	transient Image image;
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
