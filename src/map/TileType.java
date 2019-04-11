package map;

public enum TileType {
	ground("ground"),
	water("water"),
	road("road"),
	door("door");
	
	private String type;
	
	TileType(String type) {
		this.type = type;
	}
}
