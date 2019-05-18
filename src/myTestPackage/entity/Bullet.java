package myTestPackage.entity;

import myTestPackage.Coordinates;
import myTestPackage.utils.Constants;

import java.awt.*;

public class Bullet {
    private Coordinates coordinates;
    private Entity startEntity;
    private Entity finishEntity;
    private Integer speed;
    private Integer sizeBullet;

    public Bullet(Entity startEntity, Entity finishEntity, Integer speed) {
        this.startEntity = startEntity;
        this.finishEntity = finishEntity;
        this.coordinates = new myTestPackage.Coordinates(startEntity.getCoordinates().getX(), startEntity.getCoordinates().getY());
        this.speed = speed;
        this.sizeBullet = 10;
    }

    public void move() {
        if (finishEntity != null) {
            Integer dx = finishEntity.getCoordinates().getX() + Constants.SIZE_TILE / 2 - startEntity.getCoordinates().getX();
            Integer dy = finishEntity.getCoordinates().getY() + Constants.SIZE_TILE / 2 - startEntity.getCoordinates().getY();

            this.getCoordinates().setX((int) (this.getCoordinates().getX() + (this.speed * dx) / Math.sqrt(Double.valueOf(dx * dx + dy * dy))));
            this.getCoordinates().setY((int) (this.getCoordinates().getY() + (this.speed * dy) / Math.sqrt(Double.valueOf(dx * dx + dy * dy))));
        }
    }

    public void paint(Graphics g) {
        g.fillOval(this.getCoordinates().getX() - sizeBullet / 2, this.getCoordinates().getY() - sizeBullet / 2,
                sizeBullet, sizeBullet);
    }

    public myTestPackage.Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(myTestPackage.Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Entity getStartEntity() {
        return startEntity;
    }

    public void setStartEntity(Entity startEntity) {
        this.startEntity = startEntity;
    }

    public Entity getFinishEntity() {
        return finishEntity;
    }

    public void setFinishEntity(Entity finishEntity) {
        this.finishEntity = finishEntity;
    }
}
