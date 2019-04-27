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

public abstract class Mover {
	private static List<Entity> entityList = new ArrayList<Entity>();
	
	public static void moveObject(Movable object) {
		object.move();
	}
	
	public static void startRandomizeDirectionsForMonsters() {
		Timer randTimer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Entity entity : entityList) {
					entity.changeDirection();
				}
			}
		});
		randTimer.start();
	}
	
	public static void addEntityToChangeDirectionList(Entity entity) {
		if(!entityList.contains(entity)) {			
			entityList.add(entity);
		}
	}
	
	public static void deleteEntity(Entity entity) {
		if(entityList.contains(entity)) {			
			entityList.remove(entity);
		}
	}
}
