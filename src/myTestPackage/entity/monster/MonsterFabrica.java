package myTestPackage.entity.monster;

import myTestPackage.utils.Constants;
import myTestPackage.utils.ImageStorage;

/*
 * MonsterFabrica создание экземпляров класса монстр с уже конкретными параметрами
 * 
 * Author: Pikov Kirill
 */

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

		dodya.stats().setTypeMonsters(TypeMonsters.DODYA);
		dodya.stats().setRadiusAttack(100);
		dodya.stats().setRadiusPursuit(200);
		dodya.stats().setMaxHealthPoints(20);
		dodya.stats().setCurrentHealthPoints(21);
		dodya.stats().setDamage(2);
		dodya.getStats().setScore(7);
		
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

		muskuleFear.stats().setTypeMonsters(TypeMonsters.MUSKULEFEARE);
		muskuleFear.stats().setRadiusAttack(100);
		muskuleFear.stats().setRadiusPursuit(200);
		muskuleFear.stats().setMaxHealthPoints(12);
		muskuleFear.stats().setCurrentHealthPoints(12);
		muskuleFear.stats().setDamage(4);
		muskuleFear.getStats().setScore(5);
		
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

		grifon.stats().setTypeMonsters(TypeMonsters.GRIFON);
		grifon.stats().setRadiusAttack(250);
		grifon.stats().setRadiusPursuit(400);
		grifon.stats().setMaxHealthPoints(100);
		grifon.stats().setCurrentHealthPoints(100);
		grifon.stats().setDamage(8);
		grifon.getStats().setScore(20);
		
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

		ogr.stats().setTypeMonsters(TypeMonsters.OGR);
		ogr.stats().setRadiusAttack(150);
		ogr.stats().setRadiusPursuit(300);
		ogr.stats().setMaxHealthPoints(150);
		ogr.stats().setCurrentHealthPoints(150);
		ogr.stats().setDamage(10);
		ogr.getStats().setScore(25);
		
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

		metalBoss.stats().setTypeMonsters(TypeMonsters.METALLBOSS);
		metalBoss.stats().setRadiusAttack(200);
		metalBoss.stats().setRadiusPursuit(400);
		metalBoss.stats().setMaxHealthPoints(200);
		metalBoss.stats().setCurrentHealthPoints(200);
		metalBoss.stats().setDamage(9);
		metalBoss.getStats().setScore(30);
		
		return metalBoss;
	}
}
