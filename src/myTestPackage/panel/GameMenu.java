package myTestPackage.panel;

import myTestPackage.Coordinates;
import myTestPackage.Drawable;
import myTestPackage.entity.Entity;
import myTestPackage.entity.monster.Monster;
import myTestPackage.map.Chunk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameMenu extends JPanel implements Drawable {
    private Coordinates coordinates;
    private int widthPanel;
    private int heightPanel;
    private Buttons buttons;

    public GameMenu(Coordinates coordinates) {
        this.widthPanel = 200;
        this.heightPanel = 200;
        this.coordinates = coordinates;
        this.buttons = new Buttons();
        this.initLoginScreen();
        this.addButtons();
    }

    private void initLoginScreen() {
        this.setLocation(coordinates.getX(), coordinates.getY());
        this.setSize(widthPanel + 200, heightPanel + 200);
        this.setLayout(null);
    }

    public void addButtons() {
        this.add(buttons.getButtonNewGame(10, 10));
        this.add(buttons.getButtonSave(10, 50));
        this.add(buttons.getButtonLoad(10, 90));
        this.add(buttons.getButtonHelp(10, 130));
    }
    public void setGameObject(Entity player, List<Monster> monsterList, Chunk currentChunk, Frame frame) {
        buttons.setGameObject(player, monsterList, currentChunk, frame);
    }

    public void paint(Graphics g) {
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        for (Component button : this.getComponents()) {
            g.setColor(Color.RED);
            g.fillRect(button.getX() + this.getX(), button.getY() + this.getY(),
                    button.getWidth(), button.getHeight());
            g.setColor(Color.BLACK);
            g.drawString( ((JButton) button).getText(), button.getX() + this.getY(), button.getY() + this.getY() + 10);
        }
    }

    public Buttons getButtons() {
        return buttons;
    }

    public void setButtons(Buttons buttons) {
        this.buttons = buttons;
    }
}
