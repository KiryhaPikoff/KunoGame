package myTestPackage.panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Buttons {
    public static JButton getButtonSave(int x, int y) {
        JButton button = new JButton("Save game");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Save game btn");
            }
        });
        button.setBounds(x, y, 100, 25);

        return button;
    }

    public static JButton getButtonLoad(int x, int y) {
        JButton button = new JButton("Load game");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Load game btn");
            }
        });
        button.setBounds(x, y, 100, 25);

        return button;
    }
}
