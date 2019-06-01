package myTestPackage;

import myTestPackage.entity.Entity;
import myTestPackage.map.Chunk;

/*
 * CollisionChecker проверка на соприкосновение с непроходимым тайлом
 * 
 * Author: Pikov Kirill
 */

public abstract class CollisionChecker {
	public static boolean canMove(Entity movableObject, Chunk chunk) {
		if(movableObject.getMovableZone().inZone(movableObject.stats().getCoordinates().getX() + movableObject.getDirectionMovement().getOffsetX(), /* чувак вообще в зоне движения? */
		                                         movableObject.stats().getCoordinates().getY() + movableObject.getDirectionMovement().getOffsetY() ) ) {
			if(chunk.getTileXY(movableObject.stats().getCoordinates().getX() + movableObject.getDirectionMovement().getOffsetX(),
						       movableObject.stats().getCoordinates().getY() + movableObject.getDirectionMovement().getOffsetY() ).getTileType().isPassable() ) /* будет ли тайл проходимым? на негомогу наступит? */{
			
				return true;
			}
		}
		return false;
	}
}
