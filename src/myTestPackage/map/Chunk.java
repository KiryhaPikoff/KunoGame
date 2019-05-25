package myTestPackage.map;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import myTestPackage.utils.Constants;
import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.components.direction.DirectionMovement;
import myTestPackage.utils.ExcelLoader;
import myTestPackage.utils.ImageLoader;

public final class Chunk implements Drawable, Serializable {
	private Tile[][] arrayTiles;
	private Coordinates coords = new Coordinates();
	private BufferedImage renderedChunk = ImageLoader.loadImage("resources/images/default.png");
	private Graphics bufferChunk = renderedChunk.getGraphics();
	
	public Chunk(String nameFirstChunk) {
		this.arrayTiles = new Tile[Constants.HEIGHT_CHUNK][Constants.WIDTH_CHUNK];
		ExcelLoader.loadChunkInArray(nameFirstChunk, this.arrayTiles);
		this.coords = this.deCode(nameFirstChunk);

		this.render();
	}
	
	public Chunk(int hashCode, DirectionMovement direct) {
		this.arrayTiles = new Tile[Constants.HEIGHT_CHUNK][Constants.WIDTH_CHUNK];
		int newChunkI = (hashCode - 10000000 + direct.getOffsetY() * 10000) / 10000;
		int newChunkJ = hashCode % 1000 + direct.getOffsetX();

		this.coords.setPointIJ(newChunkI, newChunkJ);
		ExcelLoader.loadChunkInArray(String.valueOf(this.hashCode()), this.arrayTiles);
		
		this.render();
	}

	public void setChunk(Chunk chunk) {
		this.arrayTiles = chunk.getArrayTiles();
		this.coords = chunk.getCoords();

		this.render();
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

	public void render() {
		for (int i = 0; i < Constants.HEIGHT_CHUNK; i++) {
			for (int j = 0; j < Constants.WIDTH_CHUNK; j++) {
				this.arrayTiles[i][j].paint(this.bufferChunk);
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.renderedChunk, 0, 0, null);
	}
	
	private Coordinates deCode(String nameFile) {
		int hashCode = Integer.parseInt(nameFile);
		int newChunkI = (hashCode - 10000000) / 10000;
		int newChunkJ = hashCode % 1000;
		return new Coordinates(newChunkI, newChunkJ, true);
	}
	
	public BufferedImage getRenderedChunk() {
		return this.renderedChunk;
	}
	
	public int hashCode() {
		return 10000000 + this.coords.getI() * 10000 + this.coords.getJ();
	}

	public Tile[][] getArrayTiles() {
		return arrayTiles;
	}

	public void setArrayTiles(Tile[][] arrayTiles) {
		this.arrayTiles = arrayTiles;
	}
}
