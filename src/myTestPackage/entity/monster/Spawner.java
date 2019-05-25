package myTestPackage.entity.monster;

import myTestPackage.Coordinates;
import myTestPackage.map.Chunk;
import myTestPackage.utils.Constants;

public class Spawner {
	
	private static int numOfMonsters = 2;
	private static int numOfBoss = 3;
	private static int bossChances = 0; // чем больше число тем меньше шансов спавна босса
	
	public static Monster spawnMonster(Chunk chunk) {
		int type = (int) ((Math.random() * 100) % (numOfBoss + bossChances));
		Monster monster = null;
		
		switch(type) { // рарный спавн
			case 0: {
				monster = MonsterFabrica.createGrifon();	
				break;
			}
			
			case 1: {
				monster = MonsterFabrica.createOgr();	
				break;
			}
			
			case 2: {
				monster = MonsterFabrica.createMetalBoss();	
				break;
			}
			
			default: { // обычный спавн
				switch(type % numOfMonsters) {			
					case 0: {
						monster = MonsterFabrica.createDodya();	
						break;
					}
					case 1: {
						monster = MonsterFabrica.createMuskuleFear();	
						break;
					}
				}
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
