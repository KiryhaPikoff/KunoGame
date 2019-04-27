package myTestPackage.utils;

import java.awt.image.BufferedImage;

import myTestPackage.renderer.Animation;

public abstract class ImageStorage {
	public static final BufferedImage PLAYER_TS_UP = ImageLoader.loadImage("resources/images/player_up.png");
	public static final BufferedImage PLAYER_TS_DOWN = ImageLoader.loadImage("resources/images/player_down.png");
	public static final BufferedImage PLAYER_TS_LEFT = ImageLoader.loadImage("resources/images/player_left.png");
	public static final BufferedImage PLAYER_TS_RIGHT = ImageLoader.loadImage("resources/images/player_right.png");
	
	
	public static final BufferedImage MONSTER_DODYA_TS_UP = ImageLoader.loadImage("resources/images/dodya_up.png");
	public static final BufferedImage MONSTER_DODYA_TS_DOWN = ImageLoader.loadImage("resources/images/dodya_down.png");
	public static final BufferedImage MONSTER_DODYA_TS_LEFT = ImageLoader.loadImage("resources/images/dodya_left.png");
	public static final BufferedImage MONSTER_DODYA_TS_RIGHT = ImageLoader.loadImage("resources/images/dodya_right.png");
	
	public static final BufferedImage MONSTER_MUSCULE_FEAR_TS_UP = ImageLoader.loadImage("resources/images/musculeFear_up.png");
	public static final BufferedImage MONSTER_MUSCULE_FEAR_TS_DOWN = ImageLoader.loadImage("resources/images/musculeFear_down.png");
	public static final BufferedImage MONSTER_MUSCULE_FEAR_TS_LEFT = ImageLoader.loadImage("resources/images/musculeFear_left.png");
	public static final BufferedImage MONSTER_MUSCULE_FEAR_TS_RIGHT = ImageLoader.loadImage("resources/images/musculeFear_right.png");

	public static final BufferedImage TARGET = ImageLoader.loadImage("resources/images/target.png");
}
