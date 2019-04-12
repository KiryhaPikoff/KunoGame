package entity.control;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Entity;

public class Controller {

	private static KeyListener keyListener;
		
	public Controller() {
		
	}
		
	public static void setKeyListener(final Entity entity) {
		keyListener = new KeyListener() {
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
			
			public void keyTyped(KeyEvent e) {
				
			}
		};
	}
	
	public static KeyListener getKeyListener() {
		return keyListener;
	}
}
