package myTestPackage.map;

import java.awt.Graphics;

import components.Coordinates;
import utils.Constants;
import utils.Drawable;

public final class Tile implements Drawable {
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
	
	public TileType getTileType() {
		return this.type;
	}

	public void paint(Graphics g) {
		g.drawImage(this.type.getImage(), this.coords.getX(), this.coords.getY(), Constants.SIZE_TILE, Constants.SIZE_TILE, null);
	}
}
