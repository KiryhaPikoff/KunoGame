package entity;

import components.DirectionMove;

public class Pursuit {
	public static void move(Entity monster, Entity player) {
		if (player.getCurrentCoordinate().getX() > monster.getCurrentCoordinate().getX()) {
			monster.setDirectionMove(DirectionMove.EAST);
		}
		if (player.getCurrentCoordinate().getX() < monster.getCurrentCoordinate().getX()) {
			monster.setDirectionMove(DirectionMove.WEST);
		}
		if (player.getCurrentCoordinate().getY() > monster.getCurrentCoordinate().getY()) {
			monster.setDirectionMove(DirectionMove.SOUTH);
		}
		if (player.getCurrentCoordinate().getY() < monster.getCurrentCoordinate().getY()) {
			monster.setDirectionMove(DirectionMove.NORTH);
		}
		
		if (player.getCurrentCoordinate().getY() > monster.getCurrentCoordinate().getY() &&
			player.getCurrentCoordinate().getX() > monster.getCurrentCoordinate().getX()) {
			monster.setDirectionMove(DirectionMove.SOUTH_EAST);
		}
		if (player.getCurrentCoordinate().getY() > monster.getCurrentCoordinate().getY() &&
			player.getCurrentCoordinate().getX() < monster.getCurrentCoordinate().getX()) {
			monster.setDirectionMove(DirectionMove.SOUTH_WEST);
		}
		if (player.getCurrentCoordinate().getY() < monster.getCurrentCoordinate().getY() &&
			player.getCurrentCoordinate().getX() > monster.getCurrentCoordinate().getX()) {
			monster.setDirectionMove(DirectionMove.NORTH_EAST);
		}
		if (player.getCurrentCoordinate().getY() < monster.getCurrentCoordinate().getY() &&
			player.getCurrentCoordinate().getX() < monster.getCurrentCoordinate().getX()) {
			monster.setDirectionMove(DirectionMove.NORTH_WEST);
		}
	}
}
