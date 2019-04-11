import map.Chunk;
import map.TileType;

public class Main {
	public static void main(String[] args) {
		System.out.println("Work!");
		//TileType tilet = TileType.valueOf("ground");
		Chunk ch = new Chunk("10010002");
		System.out.println(String.valueOf(ch.hashCode()));
	}
}
