package map;

public enum TileType {
	ground(0),
	water(1),
	road(2),
	door(3);
	
	private Integer type;
	
	TileType(int type) {
		this.type = type;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
}
