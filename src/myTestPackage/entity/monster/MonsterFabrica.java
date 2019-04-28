package myTestPackage.entity.monster;

import myTestPackage.Coordinates;
import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageStorage;

public abstract class MonsterFabrica {
	public static Monster createDodya() {
		Monster dodya = new Monster();
		dodya.initGraphics(
				ImageStorage.MONSTER_DODYA_TS_DOWN.getSubimage(Constants.RESOLUTION_TILE, 0, Constants.RESOLUTION_TILE, Constants.RESOLUTION_TILE),
				ImageStorage.MONSTER_DODYA_TS_UP,
				ImageStorage.MONSTER_DODYA_TS_DOWN,
				ImageStorage.MONSTER_DODYA_TS_LEFT,
				ImageStorage.MONSTER_DODYA_TS_RIGHT);
		dodya.setName("dodya");
		
		dodya.getStats().setMaxHealthPoints(16);
		dodya.getStats().setCurrentHealthPoints(16);
		dodya.getStats().setDamage(2);
		
		return dodya;
	}
	
	public static Monster createMuskuleFear() {
		Monster muskuleFear = new Monster();
		muskuleFear.initGraphics(
				ImageStorage.MONSTER_MUSCULE_FEAR_TS_DOWN.getSubimage(Constants.RESOLUTION_TILE, 0, Constants.RESOLUTION_TILE, Constants.RESOLUTION_TILE),
				ImageStorage.MONSTER_MUSCULE_FEAR_TS_UP,
				ImageStorage.MONSTER_MUSCULE_FEAR_TS_DOWN,
				ImageStorage.MONSTER_MUSCULE_FEAR_TS_LEFT,
				ImageStorage.MONSTER_MUSCULE_FEAR_TS_RIGHT);
		muskuleFear.setName("muskuleFear");
		
		muskuleFear.getStats().setMaxHealthPoints(12);
		muskuleFear.getStats().setCurrentHealthPoints(12);
		muskuleFear.getStats().setDamage(4);
		
		return muskuleFear;
	}
}
