package myTestPackage.utils;

public abstract class Constants {
	public static final int WINDOW_POZITION_X = 0;		// На сколько окно с игрой смещено по Х от левого верхнего угла моника
	public static final int WINDOW_POZITION_Y = 0;		// На сколько окно с игрой смещено по У от левого верхнего угла моника
	public static final int WINDOW_WIDTH = 1024;		// Ширина окна
	public static final int WINDOW_HEIGHT = 795;	    // Высота окна
	
	public static final int ANIMATION_SPEED = 100;      // чем ближе к нулю - тем быстрее тикает таймер задаёт скорость анимациям
	public static final int DRAWER_SPEED = 1;           // чем ближе к нулю - тем быстрее тикает таймер задёт скорость перерисовки окна
	public static final int PHYSIC_SPEED = 50;          // чем ближе к нулю - тем быстрее тикает таймер задёт скорость движения всех объектов
	
	
	public static final int SIZE_TILE = 64;    			// размер тайла на экране в пикс
	public static final int RESOLUTION_TILE = 64;       // размер тайла в картинке *.png т.е разрешение картинки в пикс
	
	public static final int WIDTH_CHUNK = 16;			// Количество тайлов в чанке по ширине
	public static final int HEIGHT_CHUNK = 12;			// Количество тайлов в чанке по высоте
}
