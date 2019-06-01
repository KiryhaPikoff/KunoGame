package myTestPackage.components.GameInteface;

import myTestPackage.entity.Entity;

import java.awt.*;

/*
 * Bar класс, который характеризует все наследуемы классы, что они являются барами
 * 
 * Author: Syaman Sergey
 */

public class Bar {
    protected Entity target;
    protected int currentValue;
    protected int maxValue;
    protected Color color;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int shift;

    public void updateValue(int value) {
        this.currentValue = value;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
