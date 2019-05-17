package myTestPackage.components.direction;

import myTestPackage.entity.Entity;
import myTestPackage.entity.monster.Monster;

public abstract class DirectionPursuit {
    public static DirectionMovement chase(Entity monster,Entity target) {


        if (target.getCoordinates().getY() < monster.getCoordinates().getY() &&
                target.getCoordinates().getX() < monster.getCoordinates().getY()) { return DirectionMovement.NORTH_WEST; }
        if (target.getCoordinates().getY() < monster.getCoordinates().getY() &&
                target.getCoordinates().getX() > monster.getCoordinates().getY()) { return DirectionMovement.NORTH_EAST; }

        if (target.getCoordinates().getY() > monster.getCoordinates().getY() &&
                target.getCoordinates().getX() < monster.getCoordinates().getY()) { return DirectionMovement.SOUTH_WEST; }
        if (target.getCoordinates().getY() > monster.getCoordinates().getY() &&
                target.getCoordinates().getX() > monster.getCoordinates().getY()) { return DirectionMovement.SOUTH_EAST; }

        if (target.getCoordinates().getX() < monster.getCoordinates().getX()) { return DirectionMovement.WEST; }
        if (target.getCoordinates().getX() > monster.getCoordinates().getX()) { return DirectionMovement.EAST; }
        if (target.getCoordinates().getY() < monster.getCoordinates().getY()) { return DirectionMovement.NORTH; }
        if (target.getCoordinates().getY() > monster.getCoordinates().getY()) { return DirectionMovement.SOUTH; }



        return DirectionMovement.STAND;
    }
}
