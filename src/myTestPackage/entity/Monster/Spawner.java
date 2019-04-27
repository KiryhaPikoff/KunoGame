package myTestPackage.entity.Monster;

import myTestPackage.Coordinates;
import myTestPackage.map.Chunk;
import myTestPackage.utils.Constants;

public class Spawner {
	public static Monster spawnMonster(Chunk chunk) {
		int type = (int) ((Math.random() * 100) % 2);
		Monster monster = null;
		
		switch(type) {
			case 0: {
				monster = MonsterFabrica.createDodya();	
				break;
			}
			case 1: {
				monster = MonsterFabrica.createMuskuleFear();	
				break;
			}
		}
		
		int x;
		int y;
		do {
			x = (int) ((Math.random() * 10000) % (Constants.WINDOW_WIDTH - 100 ) + 50);
			y = (int) ((Math.random() * 10000) % (Constants.WINDOW_HEIGHT - 100) + 50);
		} while (x % Constants.SIZE_TILE != 0 && y % Constants.SIZE_TILE != 0 && !chunk.getTileXY(x, y).getTileType().isPassable());
		
		monster.setCoordinates(new Coordinates(x, y));
		
		return monster;
	}
}
