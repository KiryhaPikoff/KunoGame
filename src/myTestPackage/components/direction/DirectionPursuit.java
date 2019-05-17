package myTestPackage.components.direction;

import myTestPackage.entity.Entity;
import myTestPackage.entity.monster.Monster;

public abstract class DirectionPursuit {


    public static DirectionMovement chase(Entity monster,Entity target) {
        DirectionMovement directionMovement = DirectionMovement.STAND;

        if (target.getCoordinates().getX() < monster.getCoordinates().getX()) { directionMovement = DirectionMovement.WEST; }
        if (target.getCoordinates().getX() > monster.getCoordinates().getX()) { directionMovement = DirectionMovement.EAST; }
        if (target.getCoordinates().getY() < monster.getCoordinates().getY()) { directionMovement = DirectionMovement.NORTH; }
        if (target.getCoordinates().getY() > monster.getCoordinates().getY()) { directionMovement = DirectionMovement.SOUTH; }

        if (target.getCoordinates().getY() < monster.getCoordinates().getY() &&
                target.getCoordinates().getX() < monster.getCoordinates().getX()) { directionMovement = DirectionMovement.NORTH_WEST; }
        if (target.getCoordinates().getY() < monster.getCoordinates().getY() &&
                target.getCoordinates().getX() > monster.getCoordinates().getX()) { directionMovement = DirectionMovement.NORTH_EAST; }
        if (target.getCoordinates().getY() > monster.getCoordinates().getY() &&
                target.getCoordinates().getX() < monster.getCoordinates().getX()) { directionMovement = DirectionMovement.SOUTH_WEST; }
        if (target.getCoordinates().getY() > monster.getCoordinates().getY() &&
                target.getCoordinates().getX() > monster.getCoordinates().getX()) { directionMovement = DirectionMovement.SOUTH_EAST; }





        return directionMovement;
    }
}
