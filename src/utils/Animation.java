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
			
			changeFrameGo(entity);
			
			if (entity.getCondition() == Condition.Attack) {
				chaneFrameAttack(entity);
			}
			
			entity.setImage(entity.getTileset().getSubimage(entity.getSubImageCoordinate().getX(), entity.getSubImageCoordinate().getY(), Constants.SIZE_TILE, Constants.SIZE_TILE));
			entity.setCurrentFrame(entity.getCurrentFrame() + 1);
		}
	}
	
	private static void changeFrameGo(Entity entity) {
		// если анимация должна быть остановлена, то выбираем стоячую позу направления
		if(entity.isStopAnimation() == true) {
			entity.setCurrentFrame(1);
		}
		
		// я тут указал номер последнего кадра, после которого анимация начинается заново
		if(entity.getCurrentFrame() > 2) {
			entity.setCurrentFrame(0);
		}
		
		// выбор отрисовки направления 
		switch(entity.getDirectionPaint()) {
		case NORTH: 
			entity.setSubImageCoordinate(new Coordinates(entity.getCurrentFrame() * Constants.SIZE_TILE, 3 * Constants.SIZE_TILE));
			break;
		case EAST:
			entity.setSubImageCoordinate(new Coordinates(entity.getCurrentFrame() * Constants.SIZE_TILE,  2 * Constants.SIZE_TILE));
			break;
		case SOUTH:
			entity.setSubImageCoordinate(new Coordinates(entity.getCurrentFrame() * Constants.SIZE_TILE, 0 * Constants.SIZE_TILE));
			break;
		case WEST:
			entity.setSubImageCoordinate(new Coordinates(entity.getCurrentFrame() * Constants.SIZE_TILE, 1 * Constants.SIZE_TILE));
			break;
		}
		
	}
	
	private static void chaneFrameAttack(Entity entity) {
		if (entity.isStopAnimation() == true) {
			entity.setCurrentFrame(1);
		}
		
		if (entity.getCurrentFrame() == 1) {
			entity.setCurrentFrame(3);
		}
		
		if (entity.getCurrentFrame() > 5) {
			entity.setCurrentFrame(1);
		}
		
		switch(entity.getAttack()) {
		case HIT:
			entity.getSubImageCoordinate().setX(4);
			break;
		case RETURN:
			entity.getSubImageCoordinate().setX(5);
			break;
		case SWING:
			entity.getSubImageCoordinate().setX(3);
			break;
		default:
			break;
		
		}
		
	}
}
