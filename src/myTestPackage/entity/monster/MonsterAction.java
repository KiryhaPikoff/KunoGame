package myTestPackage.entity.monster;

import myTestPackage.entity.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class MonsterAction {
    private static List<Entity> entityList = new ArrayList<Entity>();

    public static void interaction(Entity monster, Entity player) {
        if (monster.getPursuitZone().contains(player.getCoordinates().getX(), player.getCoordinates().getY())) {
            monster.setTarget(player);
        } else {
            monster.setTarget(null);
        }
    }

}
