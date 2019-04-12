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
			switch(e.getKeyCode()) {
				case KeyEvent.VK_W: { 
					entity.getButtons().setPressedW(false);
					break;
				}

				case KeyEvent.VK_A: {
					//buttons.setPressedA(false);
					break;
				}

				case KeyEvent.VK_S: {
					//buttons.setPressedS(false);
					break;
				}

				case KeyEvent.VK_D: {
					//buttons.setPressedD(false);
					break;
				}
				
				case KeyEvent.VK_1: {
					//buttons.setPressed_1(true);
					break;
				}
			}
		}
		
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_W: {
					entity.getButtons().setPressedW(true); 
					System.out.println("123");
					break;
				}

				case KeyEvent.VK_A: {
					//buttons.setPressedA(true);
					break;
				}

				case KeyEvent.VK_S: {
					//buttons.setPressedS(true);
					break;
				}

				case KeyEvent.VK_D: {
					//buttons.setPressedD(true);
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
