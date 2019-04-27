package entity;

import components.Condition;
import components.DirectionMove;

public class InteractionMonsterPlayer {
	public static void interaction(Entity monster, Entity player) {
		if (monster.getZone().getPursuit().contains(player.getCurrentCoordinate().getX(), player.getCurrentCoordinate().getY())) {
			monster.setPursuit(true);
		}
		
		if (monster.getZone().getVisibility().contains(player.getCurrentCoordinate().getX(), player.getCurrentCoordinate().getY())) {
			monster.setVisibility(true);
		}
		
		if (monster.getZone().getAttack().contains(player.getCurrentCoordinate().getX(), player.getCurrentCoordinate().getY())) {
			//monster.setCondition(Condition.ATTACK);
		}
		
		if (monster.isPursuit && monster.isVisibility) {
			Pursuit.move(monster, player);
		} else {
			monster.setDirectionMove(DirectionMove.STAND);
		}
	}
}
