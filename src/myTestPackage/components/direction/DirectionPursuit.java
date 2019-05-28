package myTestPackage.components.direction;

import myTestPackage.entity.Entity;

public abstract class DirectionPursuit {


    public static DirectionMovement chase(Entity monster,Entity target) {
        DirectionMovement directionMovement = DirectionMovement.STAND;

        if (target.stats().getCoordinates().getX() < monster.stats().getCoordinates().getX()) { directionMovement = DirectionMovement.WEST; }
        if (target.stats().getCoordinates().getX() > monster.stats().getCoordinates().getX()) { directionMovement = DirectionMovement.EAST; }
        if (target.stats().getCoordinates().getY() < monster.stats().getCoordinates().getY()) { directionMovement = DirectionMovement.NORTH; }
        if (target.stats().getCoordinates().getY() > monster.stats().getCoordinates().getY()) { directionMovement = DirectionMovement.SOUTH; }

        if (target.stats().getCoordinates().getY() < monster.stats().getCoordinates().getY() &&
                target.stats().getCoordinates().getX() < monster.stats().getCoordinates().getX()) { directionMovement = DirectionMovement.NORTH_WEST; }
        if (target.stats().getCoordinates().getY() < monster.stats().getCoordinates().getY() &&
                target.stats().getCoordinates().getX() > monster.stats().getCoordinates().getX()) { directionMovement = DirectionMovement.NORTH_EAST; }
        if (target.stats().getCoordinates().getY() > monster.stats().getCoordinates().getY() &&
                target.stats().getCoordinates().getX() < monster.stats().getCoordinates().getX()) { directionMovement = DirectionMovement.SOUTH_WEST; }
        if (target.stats().getCoordinates().getY() > monster.stats().getCoordinates().getY() &&
                target.stats().getCoordinates().getX() > monster.stats().getCoordinates().getX()) { directionMovement = DirectionMovement.SOUTH_EAST; }





        return directionMovement;
    }
}
