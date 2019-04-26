package myTestPackage.renderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import myTestPackage.entity.Entity;
import myTestPackage.utils.Constants;

public abstract class AnimationUpdater {
	private static List<Entity> animList;
	
	public static void startUpdAllAnimations() {
		animList = new ArrayList<Entity>();
		
		Timer timer = new Timer(Constants.ANIMATION_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Entity entity : animList) {
					entity.updateAnimation();
				}		
			}
		});
		timer.start();
	}
	
	public static void addEntity(Entity entity) {
		if(!animList.contains(entity)) {
			animList.add(entity);
		}
	}
}
