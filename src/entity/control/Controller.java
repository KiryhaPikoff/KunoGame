package entity.control;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.Entity;

public class Controller {

	private static KeyListener keyListener;
	private static MouseListener mouseListener;
		
	public Controller() {
		
	}
		
	public static void setKeyListener(final Entity entity) {
		keyListener = new KeyListener() {
			public void keyReleased(KeyEvent e) {
				int keyButton = e.getKeyCode();
				for(Button button : entity.getButtonsMove()) {
					if(button.getKey() == keyButton) {
						button.actionReleased();
						break;
					}
				}
			}
			
			public void keyPressed(KeyEvent e) {
				int keyButton = e.getKeyCode();
				for(Button button : entity.getButtonsMove()) {
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
	
	public static void setMouseListener(Entity entity) {
		mouseListener = new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("Мышка нажата");
				
			}
		};
	}
	
	public static MouseListener getMouseListener() {
		return mouseListener;
	}

	public static KeyListener getKeyListener() {
		return keyListener;
	}
}
