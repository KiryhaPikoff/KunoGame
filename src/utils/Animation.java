package utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import components.Condition;
import components.Coordinates;
import entity.Entity;
import entity.TilesetChange;

public class Animation {
	
	public static void animation(Entity entity) {
		if(entity instanceof Drawable) {
			if (entity.getCondition() == Condition.GO) {
				switch(entity.getDirectionPaint()) {
					case NORTH: 
						entity.setImage(entity.getTileset().getSubimage(0, 0, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					case EAST:
						entity.setImage(entity.getTileset().getSubimage(0, 1, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					case SOUTH:
						entity.setImage(entity.getTileset().getSubimage(0, 0, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					case WEST:
						entity.setImage(entity.getTileset().getSubimage(0, 0, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					default:
						break;
				}
			}
			
			if (entity.getCondition() == Condition.Strike) {
				//считаем нужный кадр
			}
		}
	}
	
}
