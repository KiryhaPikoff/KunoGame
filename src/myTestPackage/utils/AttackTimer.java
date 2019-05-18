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
        this.startAttackSpeed(entity, attackSpeed);
        this.isStart = false;
    }

    private void startAttackSpeed(final Entity entity, Integer attackSpeed) {
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
    }
    public void stopAttackTimer() {
        if (this.isStart) {
            attackTimer.stop();
        }
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }
}