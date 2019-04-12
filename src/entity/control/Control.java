package entity.control;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Entity;

public class Control {
	Entity entity;
	
	public Control() {
		
	}
	
	private KeyListener KL = new KeyListener() {
		
		public void keyTyped(KeyEvent e) {
			
		}
		
		public void keyReleased(KeyEvent e) {
			int keyButton = e.getKeyCode();
			for(Button button : entity.getButtons()) {
				if(button.getKey() == keyButton) {
					button.actionReleased();
					break;
				}
			}
		}
		
		public void keyPressed(KeyEvent e) {
			int keyButton = e.getKeyCode();
			for(Button button : entity.getButtons()) {
				if(button.getKey() == keyButton) {
					button.actionPressed();
					break;
				}
			}
		}
	};
	
	public KeyListener getKeyListener() {
		return KL;
	}
	
	public void addListener(Entity entity) {
		this.entity = entity;
	}
}
