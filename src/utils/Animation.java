package utils;
/*
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import components.Condition;
import components.Coordinates;
import entity.DirectionPaintChange;
import entity.Entity;
import entity.TilesetChange;

public class Animation {
	
	public static void animation(Entity entity) {
		if(entity instanceof Drawable) {
			DirectionPaintChange.paintChange(entity);
			if (entity.getCondition() == Condition.GO) {
				if(entity.isStopAnimation() == true) {
					entity.setCurrentFrame(1);
				}
				
				if(entity.getCurrentFrame() >= 3) {
					// переписать условие getWidth / TILE_REZOLUT
					entity.setCurrentFrame(0);
				}
				
				switch(entity.getDirectionPaint()) {
					case NORTH: 
						entity.setImage(entity.getTileset().getSubimage(entity.getCurrentFrame() * Constants.SIZE_TILE, 3 * Constants.SIZE_TILE, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					case EAST:
						entity.setImage(entity.getTileset().getSubimage(entity.getCurrentFrame() * Constants.SIZE_TILE, 2 * Constants.SIZE_TILE, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					case SOUTH:
						entity.setImage(entity.getTileset().getSubimage(entity.getCurrentFrame() * Constants.SIZE_TILE, 0 * Constants.SIZE_TILE, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
					case WEST:
						entity.setImage(entity.getTileset().getSubimage(entity.getCurrentFrame() * Constants.SIZE_TILE, 1 * Constants.SIZE_TILE, Constants.SIZE_TILE, Constants.SIZE_TILE));
						break;
				}
				entity.setCurrentFrame(entity.getCurrentFrame() + 1);
			}
			
			if (entity.getCondition() == Condition.Strike) {
				//считаем нужный кадр
			}
		}
	}
	
}*/
