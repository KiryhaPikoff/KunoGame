package map;

import utils.Coordinates;

public final class Tile {
	private TileType type;
	private Coordinates coords;
	
	public Tile(TileType type, Coordinates coords) {
		this.type = type;
		this.coords = coords;
	}
	
	public void setType(TileType type) {
		this.type = type;
	}
	
	public void setCoordinates(Coordinates coords) {
		this.coords = coords;
	}
}
