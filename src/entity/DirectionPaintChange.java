package entity;

import components.DirectionMove;
import components.DirectionPaint;

public class DirectionPaintChange {
	public static void paintChange(Entity entity) {
		if(entity.getDirectionMove() == DirectionMove.STAND) {
			entity.setStopAnimation(true);
		} else {
			entity.setStopAnimation(false);
		}
		
		if(entity.getDirectionMove() == DirectionMove.NORTH) {
			entity.setDirectionPaint(DirectionPaint.NORTH);
		}
		
		if(entity.getDirectionMove() == DirectionMove.WEST) {
			entity.setDirectionPaint(DirectionPaint.WEST);
		}
		
		if(entity.getDirectionMove() == DirectionMove.SOUTH) {
			entity.setDirectionPaint(DirectionPaint.SOUTH);
		}
		
		if(entity.getDirectionMove() == DirectionMove.EAST) {
			entity.setDirectionPaint(DirectionPaint.EAST);
		}
		
		if(entity.getDirectionMove() == DirectionMove.NORTH_WEST) {
			entity.setDirectionPaint(DirectionPaint.WEST);
		}
		
		if(entity.getDirectionMove() == DirectionMove.NORTH_EAST) {
			entity.setDirectionPaint(DirectionPaint.EAST);
		}

		if(entity.getDirectionMove() == DirectionMove.SOUTH_WEST) {
			entity.setDirectionPaint(DirectionPaint.WEST);
		}
		if(entity.getDirectionMove() == DirectionMove.SOUTH_EAST) {
			entity.setDirectionPaint(DirectionPaint.EAST);
		}
	}
}
