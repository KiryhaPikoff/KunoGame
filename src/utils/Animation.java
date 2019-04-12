package utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import components.Coordinates;

public class Animation {
	private Timer timer;			// Таймер, отсчитывающий время смены кадра 
	private Coordinates tilesetCoords;		// координаты на тайлсете
	private Image imageSet;					// сам тайлсет для анимации
	private int currentFrame;		// текущий кадр у анимации 0 1 2 3...
	private Image currentImage;
	private boolean isStoped;
	
	public Animation(Image image) {
		this.imageSet = image;
		this.tilesetCoords = new Coordinates(0, 0);
		this.currentFrame = 0;		// начинаем с нулевого кадра
		this.timer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(!isStoped) {
					currentFrame++;  	// по таймеру кадры инкрементятся
					if(currentFrame >= imageSet.getWidth(null) / Constants.RESOLUTION_TILE) { // если вышли за тайлсет, то надо бы вернуться на 0
						currentFrame = 0;
					}				
					tilesetCoords.setPointXY(currentFrame * Constants.RESOLUTION_TILE, tilesetCoords.getY());  // находим левую верхнюю точку у нашего кадра
				 }
			}
		});
		this.timer.start();
	}
	
	public Integer getTilesetCoordX() {
		return this.tilesetCoords.getX();
	}
	
	public Integer getTilesetCoordY() {
		return this.tilesetCoords.getY();
	}
	
	public void setCoordinateInMap(Coordinates newCoords) {
		this.tilesetCoords = newCoords;
	}
	
	public void setIsStoped(boolean isStoped) {
		this.isStoped = isStoped;
	}
	
 	public void paint(Graphics g, int x, int y) {
		g.drawImage(this.imageSet, x, y, 
					x + Constants.SIZE_TILE, y + Constants.SIZE_TILE, 
					this.tilesetCoords.getX(), this.tilesetCoords.getY(), this.tilesetCoords.getX() + Constants.RESOLUTION_TILE, this.tilesetCoords.getY() + Constants.RESOLUTION_TILE, 
					null, null); 
	}
}
