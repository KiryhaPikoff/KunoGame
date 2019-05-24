package myTestPackage.entity.monster;

import myTestPackage.Action;
import myTestPackage.entity.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class MonsterAction {

    public static void interaction(Entity monster, Entity player) {
        if (monster.getPursuitZone().contains(player.getCoordinates().getX(), player.getCoordinates().getY())) {
            monster.setTarget(player);
        } else {
            monster.setTarget(null);
        }

        if (monster.getAttackZone().contains(player.getCoordinates().getX(), player.getCoordinates().getY()) &&
                monster.getTarget() != null &&
                monster.getAction() != Action.DEAD) {
            monster.setCanAttack(true);
        } else {
            monster.setCanAttack(false);
        }
    }

}
