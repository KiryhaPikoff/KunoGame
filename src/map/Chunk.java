package map;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import utils.Constants;
import utils.Coordinates;
import utils.Direction;
import utils.Drawable;
import utils.ExcelLoader;

public final class Chunk implements Drawable {
	private Tile[][] arrayTiles;
	private Coordinates coords;
	
	
	public Chunk(String nameFirstChunk) {
		this.arrayTiles = new Tile[Constants.HEIGHT_CHUNK][Constants.WIDTH_CHUNK];
		ExcelLoader.loadChunkInArray(nameFirstChunk, this.arrayTiles);
		this.coords = this.deCode(nameFirstChunk);
	}
	
	public Chunk(int hashCode, Direction direct) {
		int newChunkI = (hashCode - 10000000 + direct.getOffsetY() * 10000) / 10000;
		int newChunkJ = hashCode % 1000 + direct.getOffsetX();
		this.coords.setPointIJ(newChunkI, newChunkJ);
		ExcelLoader.loadChunkInArray(String.valueOf(this.hashCode()), this.arrayTiles);
	}
	
	public Tile getTileIJ(int i, int j) {
		return this.arrayTiles[i][j];
	}
	
	public Tile getTileXY(int x, int y) {
		return this.arrayTiles[y / Constants.SIZE_TILE][x / Constants.SIZE_TILE];
	}
	
	public Coordinates getCoords() {
		return this.coords;
	}

	
	public void paint(Graphics g) {
		for (int i = 0; i < Constants.HEIGHT_CHUNK; i++) {
			for (int j = 0; j < Constants.WIDTH_CHUNK; j++) {
				this.arrayTiles[i][j].paint(g);
			}
		}
	}
	
	private Coordinates deCode(String nameFile) {
		int hashCode = Integer.parseInt(nameFile);
		int newChunkI = (hashCode - 10000000) / 10000;
		int newChunkJ = hashCode % 1000;
		return new Coordinates(newChunkI, newChunkJ, true);
	}
	
	public int hashCode() {
		return 10000000 + this.coords.getI() * 10000 + this.coords.getJ();
	}
}
