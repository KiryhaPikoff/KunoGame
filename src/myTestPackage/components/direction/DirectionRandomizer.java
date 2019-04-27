package myTestPackage.components.direction;

public abstract class DirectionRandomizer {
	public static DirectionMovement rand() {
		int temp = (int) ((Math.random() * 100) % 9);
		
		switch(temp) {
			case 0: return DirectionMovement.NORTH;
			case 1: return DirectionMovement.NORTH_WEST;
			case 2: return DirectionMovement.NORTH_EAST;
			case 3: return DirectionMovement.WEST;
			case 4: return DirectionMovement.EAST;
			case 5: return DirectionMovement.SOUTH;
			case 6: return DirectionMovement.SOUTH_WEST;
			case 7: return DirectionMovement.SOUTH_EAST;
			case 8: return DirectionMovement.STAND;
		}
		
		return DirectionMovement.STAND;
	}
}
