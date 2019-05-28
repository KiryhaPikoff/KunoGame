package myTestPackage.panel;

import myTestPackage.Coordinates;
import myTestPackage.SaveLoadGame;
import myTestPackage.entity.Entity;
import myTestPackage.entity.monster.Monster;
import myTestPackage.entity.monster.Spawner;
import myTestPackage.entity.player.Player;
import myTestPackage.map.Chunk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class Buttons {
    private JButton saveGameBtn;
    private JButton loadGameBtn;
    private JButton newGameBtn;
    private JButton helpBtn;

    private Entity player;
    private List<Monster> monsterList;
    private Chunk currentChunk;
    private Frame focusFrame;

    public Buttons() {

    }

    public void setGameObject(Entity player, List<Monster> monsterList, Chunk currentChunk, Frame frame) {
        this.player = player;
        this.monsterList = monsterList;
        this.currentChunk = currentChunk;
        this.focusFrame = frame;
    }

    public JButton getButtonSave(int x, int y) {
        saveGameBtn = new JButton("Save game");
        saveGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    SaveLoadGame.saveAllGame(player, monsterList, currentChunk);
                    System.out.println("save");
                    focusFrame.requestFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        saveGameBtn.setBounds(x, y, 120, 25);

        return saveGameBtn;
    }

    public JButton getButtonLoad(int x, int y) {
        loadGameBtn = new JButton("Load game");
        loadGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    SaveLoadGame.loadAllGame(player, monsterList, currentChunk);
                    focusFrame.requestFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        loadGameBtn.setBounds(x, y, 120, 25);

        return loadGameBtn;
    }

    public JButton getButtonNewGame(int x, int y) {
        newGameBtn = new JButton("New game");
        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                currentChunk = new Chunk("10000000");

                for (int i = 0; i < 4; i++) {
                    Monster tempMonster = Spawner.spawnMonster(currentChunk);
                    monsterList.add(tempMonster);
                }

                player = new Player(new Coordinates(450, 500));
                focusFrame.requestFocus();
            }
        });
        newGameBtn.setBounds(x, y, 120, 25);
        return newGameBtn;
    }

    public JButton getButtonHelp(int x, int y) {
        helpBtn = new JButton("Help");
        helpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("QAE btn");
                focusFrame.requestFocus();
            }
        });
        helpBtn.setBounds(x, y, 120, 25);

        return helpBtn;
    }



    public void setMonsterList(List <Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public Chunk getCurrentChunk() {
        return currentChunk;
    }

    public void setCurrentChunk(Chunk currentChunk) {
        this.currentChunk = currentChunk;
    }

    public Entity getPlayer() {
        return player;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

    public boolean isEmptyMonsterList() {
        return monsterList.isEmpty();
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }
}
