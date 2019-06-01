package myTestPackage;

import myTestPackage.entity.Entity;
import myTestPackage.entity.components.Stats;
import myTestPackage.entity.monster.Monster;
import myTestPackage.entity.monster.MonsterFabrica;
import myTestPackage.map.Chunk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * SaveLoadGame сохранение и загрузка игры
 * 
 * Author: Syaman Sergey
 */

public abstract class SaveLoadGame {
    public  SaveLoadGame() {

    }

    public static void saveMonster(List<Monster> monsterList, Chunk currentChunk) {
        try {
            List<Stats> statsMonster = new ArrayList<Stats>();
            for (Monster monster : monsterList) {
                statsMonster.add(monster.getStats());
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("resources/saves/tempSave/" + currentChunk.hashCode() + ".txt")));
            objectOutputStream.writeObject(statsMonster);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadMonster(List<Monster> monsterList, Chunk currentChunk) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        objectInputStream = new ObjectInputStream(new FileInputStream(new File("resources/saves/tempSave/" + currentChunk.hashCode() + ".txt")));
        List<Stats> statsList = ((List<Stats>) objectInputStream.readObject());
        for (Stats stats : statsList) {
            Monster monster = null;
            switch (stats.getTypeMonsters()) {
                case GRIFON:
                    monster = MonsterFabrica.createGrifon();
                    break;
                case OGR:
                    monster = MonsterFabrica.createOgr();
                    break;
                case METALLBOSS:
                    monster = MonsterFabrica.createMetalBoss();
                    break;
                case DODYA:
                    monster = MonsterFabrica.createDodya();
                    break;
                case MUSKULEFEARE:
                    monster = MonsterFabrica.createMuskuleFear();
                    break;
            }
            monster.setStats(stats);
            monsterList.add(monster);
        }

    }

    public static void saveAllGame(Entity player, List<Monster> monsterList, Chunk currentChunk) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        File file;

        file = new File("resources/saves/globalSave/player.txt");
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(player.getStats());

        file = new File("resources/saves/globalSave/currentChunk.txt");
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(String.valueOf(currentChunk.hashCode()));

        file = new File("resources/saves/globalSave/monsterStatsList.txt");
        List<Stats> monsterStatsList = new ArrayList<Stats>();
        for (Monster monster : monsterList) {
            monsterStatsList.add(monster.getStats());
        }
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(monsterStatsList);

    }

    public static void loadAllGame(Entity player, List<Monster> monsterList, Chunk currentChunk) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        File file;

        file = new File("resources/saves/globalSave/player.txt");
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        player.setStats((Stats) objectInputStream.readObject());

        file = new File("resources/saves/globalSave/currentChunk.txt");
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Chunk tempChunk = new Chunk((String) objectInputStream.readObject());
        currentChunk.setChunk(tempChunk);

        monsterList.clear();
        file = new File("resources/saves/globalSave/monsterStatsList.txt");
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<Stats> monsterStatsList = ((List<Stats>) objectInputStream.readObject());
        for (Stats stats : monsterStatsList) {
            Monster monster = null;
            switch (stats.getTypeMonsters()) {

                case GRIFON:
                    monster = MonsterFabrica.createGrifon();
                    break;
                case OGR:
                    monster = MonsterFabrica.createOgr();
                    break;
                case METALLBOSS:
                    monster = MonsterFabrica.createMetalBoss();
                    break;
                case DODYA:
                    monster = MonsterFabrica.createDodya();
                    break;
                case MUSKULEFEARE:
                    monster = MonsterFabrica.createMuskuleFear();
                    break;
            }

            monster.setStats(stats);
            monsterList.add(monster);
        }

    }

}
