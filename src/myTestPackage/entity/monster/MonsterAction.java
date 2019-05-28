package myTestPackage.entity.monster;

import myTestPackage.entity.Entity;

public abstract class MonsterAction {
    public static void interaction(Entity monster, Entity player) {
        if (monster.getPursuitZone().contains(player.stats().getCoordinates().getX(), player.stats().getCoordinates().getY())) {
            monster.setTarget(player);
        } else {
            monster.setTarget(null);
        }

        if (monster.getAttackZone().contains(player.stats().getCoordinates().getX(), player.stats().getCoordinates().getY())) {
            monster.setCanAttack(true);
        } else {
            monster.setCanAttack(false);
        }
    }

}
