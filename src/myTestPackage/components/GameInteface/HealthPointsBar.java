package myTestPackage.components.GameInteface;

import myTestPackage.Drawable;
import myTestPackage.entity.Entity;
import myTestPackage.utils.Constants;

import java.awt.*;

public class HealthPointsBar {

    private Entity target;
    private int heightBar;

    public HealthPointsBar(Entity entity) {
        this.target = entity;
        this.heightBar = 10;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(target.getCoordinates().getX() - Constants.SIZE_TILE / 2,
                    target.getCoordinates().getY() - Constants.SIZE_TILE,
                        target.getStats().getMaxHealthPoints(), heightBar);
        g.setColor(Color.RED);
        g.fillRect(target.getCoordinates().getX() - Constants.SIZE_TILE / 2,
                target.getCoordinates().getY() - Constants.SIZE_TILE,
                    target.getStats().getCurrentHealthPoints(), heightBar);
    }
}
