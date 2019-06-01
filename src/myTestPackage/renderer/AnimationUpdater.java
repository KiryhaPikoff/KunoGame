package myTestPackage.renderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import myTestPackage.entity.Entity;
import myTestPackage.utils.Constants;

/*
 * Animation система для обновления анимации по таймеру
 * 
 * Author: Pikov Kirill
 */

public class AnimationUpdater {
	private List<Entity> animList;
	Timer animTimer;

	public AnimationUpdater() {
		this.animList = new ArrayList<Entity>();
		this.initAnimTimer();
	}

	public void initAnimTimer() {
		animTimer = new Timer(Constants.ANIMATION_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Entity entity : animList) {
					entity.updateAnimation();
				}		
			}
		});

	}

	public void start() {
		animTimer.start();
	}

	public void stop() {
		animTimer.stop();
	}
	
	public void addEntity(Entity entity) {
		if(!animList.contains(entity)) {
			animList.add(entity);
		}
	}
	
	public void deleteEntity(Entity entity) {
		if(animList.contains(entity)) {
			animList.remove(entity);
		}
	}
}
