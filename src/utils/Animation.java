package utils;

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
			
			if (entity.getCurrentFrame() > entity.getFinishFrameCondition()) {
				entity.setCurrentFrame(entity.getStartFrameCondition());
			}
			
			
			
			switch(entity.getCondition()) {
			case ATTACK:
				entity.setStartFrameCondition(3);
				entity.setFinishFrameCondition(5);
				break;
			case GO:
				entity.setStartFrameCondition(0);
				entity.setFinishFrameCondition(2);
				break;
			default:
				break;
			}
			
			if (entity.isStopAnimation()) {
				entity.setCurrentFrame(entity.getStartFrameCondition());
			}
			
			entity.setImage(entity.getTileset().getSubimage(entity.getCurrentFrame() * Constants.SIZE_TILE, 0, Constants.SIZE_TILE, Constants.SIZE_TILE));
			entity.setCurrentFrame(entity.getCurrentFrame() + 1);
		}
	}
}
