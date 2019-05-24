package myTestPackage.components.GameInteface;

import myTestPackage.Drawable;
import myTestPackage.entity.Entity;
import myTestPackage.utils.Constants;

import java.awt.*;

public class HealthPointsBar extends Bar implements Drawable{

    public HealthPointsBar(Entity entity) {
        this.target = entity;
        this.shift = Constants.SIZE_TILE;
        this.height = 10;
        this.width = 100;
        this.color = Color.RED;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(target.getCoordinates().getX() - shift / 2 ,
                target.getCoordinates().getY() - shift, width, height);
        g.setColor(color);
        g.fillRect(target.getCoordinates().getX() - shift / 2 + 1,
                target.getCoordinates().getY() - shift + 1,
                (target.getStats().getCurrentHealthPoints() * (width - 1) / target.getStats().getMaxHealthPoints()),
                height - 1);
    }
}
