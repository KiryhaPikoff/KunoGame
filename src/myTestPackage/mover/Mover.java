package myTestPackage.mover;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import myTestPackage.Drawable;
import myTestPackage.entity.Entity;
import myTestPackage.map.Chunk;
import myTestPackage.utils.Constants;

public class Mover {
	private List<Entity> entityList = new ArrayList<Entity>();
	public void moveObject(Movable object) {
		object.move();
	}
    Timer randTimer;

	public Mover() {
	    this.initRandTimer();
    }

	private void initRandTimer() {
        randTimer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Entity entity : entityList) {
                    entity.changeDirection();
                }
            }
        });
    }
	
	public void start() {
		randTimer.start();
	}

	public void stop() {
	    randTimer.stop();
    }
	
	public void addEntityToChangeDirectionList(Entity entity) {
		if(!entityList.contains(entity)) {			
			entityList.add(entity);
		}
	}
	
	public void deleteEntity(Entity entity) {
		if(entityList.contains(entity)) {			
			entityList.remove(entity);
		}
	}
}
