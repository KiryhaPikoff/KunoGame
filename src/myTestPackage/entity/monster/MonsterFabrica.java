package myTestPackage.entity.monster;

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
		dodya.setName("Dodya");

		dodya.getStats().setRadiusAttack(100);
		dodya.getStats().setRadiusPursuit(200);
		dodya.getStats().setMaxHealthPoints(16);
		dodya.getStats().setCurrentHealthPoints(16);
		dodya.getStats().setDamage(2);
		dodya.setScore(5);
		
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

		muskuleFear.getStats().setRadiusAttack(100);
		muskuleFear.getStats().setRadiusPursuit(200);
		muskuleFear.getStats().setMaxHealthPoints(12);
		muskuleFear.getStats().setCurrentHealthPoints(12);
		muskuleFear.getStats().setDamage(4);
		muskuleFear.setScore(5);
		
		return muskuleFear;
	}
	
	public static Monster createGrifon() {
		Monster grifon = new Monster();
		grifon.initGraphics(
				ImageStorage.GRIFON_TS_DOWN.getSubimage(0, 0, Constants.RESOLUTION_TILE * 2, Constants.RESOLUTION_TILE * 2),
				ImageStorage.GRIFON_TS_UP,
				ImageStorage.GRIFON_TS_DOWN,
				ImageStorage.GRIFON_TS_LEFT,
				ImageStorage.GRIFON_TS_RIGHT);
		grifon.setName("Grifon");

		grifon.getStats().setRadiusAttack(200);
		grifon.getStats().setRadiusPursuit(400);
		grifon.getStats().setMaxHealthPoints(300);
		grifon.getStats().setCurrentHealthPoints(300);
		grifon.getStats().setDamage(15);
		grifon.setScore(20);
		
		return grifon;
	}

	public static Monster createOgr() {
		Monster ogr = new Monster();
		ogr.initGraphics(
				ImageStorage.OGR_TS_DOWN.getSubimage(0, 0, Constants.RESOLUTION_TILE * 2, Constants.RESOLUTION_TILE * 2),
				ImageStorage.OGR_TS_UP,
				ImageStorage.OGR_TS_DOWN,
				ImageStorage.OGR_TS_LEFT,
				ImageStorage.OGR_TS_RIGHT);
		ogr.setName("Ogr");

		ogr.getStats().setRadiusAttack(200);
		ogr.getStats().setRadiusPursuit(400);
		ogr.getStats().setMaxHealthPoints(300);
		ogr.getStats().setCurrentHealthPoints(300);
		ogr.getStats().setDamage(15);
		ogr.setScore(20);
		
		return ogr;
	}
	
	public static Monster createMetalBoss() {
		Monster metalBoss = new Monster();
		metalBoss.initGraphics(
				ImageStorage.METAL_BOSS_TS_DOWN.getSubimage(0, 0, Constants.RESOLUTION_TILE * 2, Constants.RESOLUTION_TILE * 2),
				ImageStorage.METAL_BOSS_TS_UP,
				ImageStorage.METAL_BOSS_TS_DOWN,
				ImageStorage.METAL_BOSS_TS_LEFT,
				ImageStorage.METAL_BOSS_TS_RIGHT);
		metalBoss.setName("MetalBoss");

		metalBoss.getStats().setRadiusAttack(200);
		metalBoss.getStats().setRadiusPursuit(400);
		metalBoss.getStats().setMaxHealthPoints(300);
		metalBoss.getStats().setCurrentHealthPoints(300);
		metalBoss.getStats().setDamage(15);
		metalBoss.setScore(20);
		
		return metalBoss;
	}
}
