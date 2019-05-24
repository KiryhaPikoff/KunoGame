package myTestPackage.panel;

import myTestPackage.Coordinates;
import myTestPackage.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreenPanel extends JPanel implements Drawable {
    Coordinates coordinates;
    int widthPanel;
    int heightPanel;

    public LoginScreenPanel(Coordinates coordinates) {
        this.widthPanel = 200;
        this.heightPanel = 200;
        this.coordinates = coordinates;
        this.initLoginScreen();
        this.addButtons();
    }

    private void initLoginScreen() {

        this.setBounds(coordinates.getX(), coordinates.getY(),
                coordinates.getX() + heightPanel, coordinates.getY() + widthPanel);
        System.out.printf("init Panel");
    }

    private void addButtons() {
        this.add(Buttons.getButtonSave(coordinates.getX() + 10, coordinates.getY() + 10));
        this.add(Buttons.getButtonLoad( Buttons.getButtonSave(0,0).getHeight() + 10,
                                            Buttons.getButtonSave(0,0).getWidth()));
    }
}
