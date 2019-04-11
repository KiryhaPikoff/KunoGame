package utils;

public final class Coordinates {
	private int x;
	private int y;
	private int i;
	private int j;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		this.calculateIJ();
	}
	
	private void calculateIJ() {
		this.i = this.y / Constants.SIZE_TILE;
		this.j = this.x / Constants.SIZE_TILE;
	}
	
	public void setX(int x) {
		this.x = x;
		this.calculateIJ();
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
		this.calculateIJ();
	}
	
	public int getY() {
		return this.x;
	}
	
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
		this.calculateIJ();
	}
	
	public int getI() {
		return this.x;
	}
	
	public int getJ() {
		return this.x;
	}
}
