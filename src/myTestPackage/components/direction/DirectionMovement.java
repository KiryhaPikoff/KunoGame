package myTestPackage.components.direction;

public enum DirectionMovement {
	STAND(0, 0),
	
	NORTH(0, -1),
	NORTH_EAST(1, -1),
	EAST(1, 0),
	SOUTH_EAST(1, 1),
	SOUTH(0, 1),
	SOUTH_WEST(-1, 1),
	WEST(-1, 0),
	NORTH_WEST(-1, -1);
	
	private final Integer offsetX;  // сдвиг по Х
	private final Integer offsetY;  // сдвиг по У
	
	DirectionMovement(Integer offsetX, Integer offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	public Integer getOffsetX() {
		return this.offsetX;
	}
	
	public Integer getOffsetY() {
		return this.offsetY;
	}
}
