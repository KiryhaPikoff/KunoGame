package myTestPackage.utils;

import myTestPackage.entity.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * AttackTimer создание таймера атаки
 * 
 * Author: Syaman Sergey
 */

public class AttackTimer {
    private Timer attackTimer;
    private Integer attackSpeed;
    private boolean isStart;

    public AttackTimer(Integer attackSpeed) {
        this.attackSpeed = attackSpeed;
        this.isStart = false;
    }

    public void initAttackSpeed(final Entity entity) {
        this.attackTimer = new Timer(attackSpeed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                entity.setCanAttack(true);
            }
        });
    }

    public void initAttackMonster(final Entity monster) {
        this.attackTimer = new Timer(attackSpeed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monster.attack();
            }
        });
    }

    public void startAttackTimer() {
        if (!this.isStart) {
            attackTimer.start();
            isStart = true;
        }
    }
    public void stopAttackTimer() {
        if (this.isStart) {
            attackTimer.stop();
            isStart = false;
        }
    }

}
