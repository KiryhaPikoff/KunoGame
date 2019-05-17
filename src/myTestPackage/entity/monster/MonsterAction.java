package myTestPackage.entity.monster;

import myTestPackage.Action;
import myTestPackage.entity.Entity;
import myTestPackage.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class MonsterAction {
    public static void interaction(Entity monster, Entity player) {
        if (monster.getAttackZone().contains(player.getCoordinates().getX(), player.getCoordinates().getY())) {
            monster.setTarget(player);
            monster.setAction(Action.PURSUIT);
        } else {
            monster.setAction(Action.MOVE);
            monster.setTarget(null);
        }
    }
}
