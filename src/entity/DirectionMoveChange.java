package entity;

import components.DirectionMove;

public class DirectionMoveChange {
	public static void changeDirectionMove(Entity entity) {
		if(entity.getButtonsMove().get(0).isPressed() == false && entity.getButtonsMove().get(1).isPressed() == false &&
				entity.getButtonsMove().get(2).isPressed() == false && entity.getButtonsMove().get(3).isPressed() == false) {
			entity.setDirectionMove(DirectionMove.STAND);
		}
		
		if(entity.getButtonsMove().get(0).isPressed()) {
			entity.setDirectionMove(DirectionMove.NORTH);
		}
		
		if(entity.getButtonsMove().get(1).isPressed()) {
			entity.setDirectionMove(DirectionMove.WEST);
		}
		
		if(entity.getButtonsMove().get(2).isPressed()) {
			entity.setDirectionMove(DirectionMove.SOUTH);
			System.out.println("fefwef");
		}
		
		if(entity.getButtonsMove().get(3).isPressed()) {
			entity.setDirectionMove(DirectionMove.EAST);
		}
		
		if(entity.getButtonsMove().get(0).isPressed() && entity.getButtonsMove().get(1).isPressed()) {
			entity.setDirectionMove(DirectionMove.NORTH_WEST);
		}
		
		if(entity.getButtonsMove().get(0).isPressed() && entity.getButtonsMove().get(3).isPressed()) {
			entity.setDirectionMove(DirectionMove.NORTH_EAST);
		}

		if(entity.getButtonsMove().get(2).isPressed() && entity.getButtonsMove().get(1).isPressed()) {
			entity.setDirectionMove(DirectionMove.SOUTH_WEST);
		}
		if(entity.getButtonsMove().get(2).isPressed() && entity.getButtonsMove().get(3).isPressed()) {
			entity.setDirectionMove(DirectionMove.NORTH_EAST);
		}
	}
}
