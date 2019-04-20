package myTestPackage;

import myTestPackage.entity.Entity;
import myTestPackage.map.Chunk;

public abstract class CollisionChecker {
	public static boolean canMove(Entity movableObject, Chunk chunk) {
		if(movableObject.getMovableZone().inZone(movableObject.getCoordinates().getX() + movableObject.getDirectionMovement().getOffsetX(), /* чувак вообще в зоне движения? */
		                                         movableObject.getCoordinates().getY() + movableObject.getDirectionMovement().getOffsetY() ) ) {
			if(chunk.getTileXY(movableObject.getCoordinates().getX() + movableObject.getDirectionMovement().getOffsetX(), 
						       movableObject.getCoordinates().getY() + movableObject.getDirectionMovement().getOffsetY() ).getTileType().isPassable() ) /* будет ли тайл проходимым? на негомогу наступит? */{
			
				return true;
			}
		}
		return false;
	}
}
