package utils;

public final class Coordinates {
	private int x;	// координата х в окне (в пикселях)
	private int y;	// координата y в окне (в пикселях)
	private int i;	// координата i (высота в тайлах)
	private int j;	// координата j (ширина в тайлах)
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		this.calculateIJ();
	}
	
	public Coordinates(int i, int j, boolean flag) { //бесполезный флаг для различной сигнатуры
		this.i = i;
		this.j = j;
		this.calculateXY();
	}
	
	private void calculateIJ() {
		this.i = this.y / Constants.SIZE_TILE;
		this.j = this.x / Constants.SIZE_TILE;
	}
	
	private void calculateXY() {
		this.x = this.j * Constants.SIZE_TILE;
		this.y = this.i * Constants.SIZE_TILE;
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
		return this.y;
	}
	
	public void setPointXY(int x, int y) {
		this.x = x;
		this.y = y;
		this.calculateIJ();
	}
	
	public void setI(int i) {
		this.i = i;
		this.calculateXY();
	}
	
	public int getI() {
		return this.i;
	}
	
	public void setJ(int j) {
		this.j = j;
		this.calculateXY();
	}
	
	public int getJ() {
		return this.j;
	}
	
	public void setPointIJ(int i, int j) {
		this.i = i;
		this.j = j;
		this.calculateXY();
	}
}
