package myTestPackage.entity;

import myTestPackage.Coordinates;
import myTestPackage.utils.Constants;

import java.awt.*;

/*
 * Bullet пуля, наносящая урон врагам
 * 
 * Author: Syaman Sergey
 */

public class Bullet {
    private Coordinates coordinates;
    private Entity startEntity;
    private Entity finishEntity;
    private Integer speed;
    private Integer sizeBullet;

    public Bullet(Entity startEntity, Entity finishEntity, Integer speed) {
        this.startEntity = startEntity;
        this.finishEntity = finishEntity;
        this.coordinates = new Coordinates(startEntity.stats().getCoordinates().getX(), startEntity.stats().getCoordinates().getY());
        this.speed = speed;
        this.sizeBullet = 10;
    }

    public void move() {
        if (finishEntity != null) {
            Integer dx = (finishEntity.stats().getCoordinates().getX() + (Constants.SIZE_TILE / 2))
            		- startEntity.stats().getCoordinates().getX();
            Integer dy = (finishEntity.stats().getCoordinates().getY() + (Constants.SIZE_TILE / 2))
            		- startEntity.stats().getCoordinates().getY();

            this.getCoordinates().setX((int) (this.getCoordinates().getX() + 
            		(this.speed * dx) / Math.sqrt((double) (dx * dx + dy * dy))));
            this.getCoordinates().setY((int) (this.getCoordinates().getY() + 
            		(this.speed * dy) / Math.sqrt((double) (dx * dx + dy * dy))));
        }
    }

    public void paint(Graphics g) {
        g.fillOval(this.getCoordinates().getX() - sizeBullet / 2, this.getCoordinates().getY() - sizeBullet / 2,
                sizeBullet, sizeBullet);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(myTestPackage.Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
