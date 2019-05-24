package myTestPackage.utils;

import myTestPackage.entity.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackTimer {
    private Timer attackTimer;
    private Integer attackSpeed;
    private boolean isStart;

    public AttackTimer(Integer attackSpeed, Entity entity) {
        this.attackSpeed = attackSpeed;
        this.startAttackSpeed(entity);
        this.isStart = false;
    }

    private void startAttackSpeed(final Entity entity) {
        this.attackTimer = new Timer(attackSpeed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                entity.attack();
            }
        });
    }

    public void startAttackTimer() {
        if (!this.isStart) {
            attackTimer.start();
        }

        isStart = true;
    }
    public void stopAttackTimer() {
        if (this.isStart) {
            attackTimer.stop();
        }
        isStart = false;
    }

}
