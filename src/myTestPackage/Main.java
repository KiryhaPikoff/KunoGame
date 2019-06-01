package myTestPackage;
import javax.swing.*;
import java.awt.*;

/*
 * Main класс запуска игры
 * 
 * Author: Pikov Kirill && Syaman Sergey
 */

public class Main {

	public Main() {
		JFrame frame = new JFrame();
		frame = new GameWindow();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
