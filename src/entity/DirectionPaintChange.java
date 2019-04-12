package entity;

import components.DirectionMove;
import components.DirectionPaint;

public class DirectionPaintChange {
	public static void paintChange(Entity entity) {
		if(entity.getButtonsMove().get(0).isPressed() == false && entity.getButtonsMove().get(1).isPressed() == false &&
				entity.getButtonsMove().get(2).isPressed() == false && entity.getButtonsMove().get(3).isPressed() == false) {
			//entity.setDirectionPaint(DirectionPaint.STAND);
			entity.setStopAnimation(true);
		} else {
			entity.setStopAnimation(false);
		}
		
		if(entity.getButtonsMove().get(0).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.NORTH);
		}
		
		if(entity.getButtonsMove().get(1).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.WEST);
		}
		
		if(entity.getButtonsMove().get(2).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.SOUTH);
		}
		
		if(entity.getButtonsMove().get(3).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.EAST);
		}
		
		if(entity.getButtonsMove().get(0).isPressed() && entity.getButtonsMove().get(1).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.WEST);
		}
		
		if(entity.getButtonsMove().get(0).isPressed() && entity.getButtonsMove().get(3).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.EAST);
		}

		if(entity.getButtonsMove().get(2).isPressed() && entity.getButtonsMove().get(1).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.WEST);
		}
		if(entity.getButtonsMove().get(2).isPressed() && entity.getButtonsMove().get(3).isPressed()) {
			entity.setDirectionPaint(DirectionPaint.EAST);
		}
	}
}
