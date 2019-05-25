package myTestPackage;

import myTestPackage.entity.Entity;
import myTestPackage.entity.monster.Monster;
import myTestPackage.entity.monster.MonsterFabrica;
import myTestPackage.map.Chunk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SaveLoadGame {
    public  SaveLoadGame() {

    }

    public static void saveMonster(List<Monster> monsterList, Chunk currentChunk) {
        try {
            List<Coordinates> coordMonsterList = new ArrayList<Coordinates>();

            for (Monster monster : monsterList) {
                coordMonsterList.add(monster.getCoordinates());
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("resources/saves/tempSave/" + currentChunk.hashCode() + ".txt")));
            objectOutputStream.writeObject(coordMonsterList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadMonster(List<Monster> monsterList, Chunk currentChunk) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream;

        objectInputStream = new ObjectInputStream(new FileInputStream(new File("resources/saves/tempSave/" + currentChunk.hashCode() + ".txt")));


        List<Coordinates> coordMonsterList = ((List<Coordinates>) objectInputStream.readObject());

        for (Coordinates coordMonster : coordMonsterList) {
            Monster monster = MonsterFabrica.createDodya();
            monster.setCoordinates(coordMonster);
            monsterList.add(monster);
        }

    }

    public static void saveAllGame(Entity player, List<Monster> monsterList, Chunk currentChunk) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        File file;

        file = new File("resources/saves/globalSave/player.txt");
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(player.getCoordinates());

        file = new File("resources/saves/globalSave/currentChunk.txt");
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(String.valueOf(currentChunk.hashCode()));

        file = new File("resources/saves/globalSave/monsterCoordList.txt");
        List<Coordinates> coordMonsterList = new ArrayList<Coordinates>();
        for (Monster monster : monsterList) {
            coordMonsterList.add(monster.getCoordinates());
        }
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(coordMonsterList);

    }

    public static void loadAllGame(Entity player, List<Monster> monsterList, Chunk currentChunk) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        File file;

        file = new File("resources/saves/globalSave/player.txt");
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        player.setCoordinates((Coordinates) objectInputStream.readObject());

        file = new File("resources/saves/globalSave/currentChunk.txt");
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Chunk tempChunk = new Chunk((String) objectInputStream.readObject());
        currentChunk.setChunk(tempChunk);

        monsterList.clear();
        file = new File("resources/saves/globalSave/monsterCoordList.txt");
        objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<Coordinates> coordMonsterList = ((List<Coordinates>) objectInputStream.readObject());
        for (Coordinates coordMonster : coordMonsterList) {
            Monster monster = MonsterFabrica.createDodya();
            monster.setCoordinates(coordMonster);
            monsterList.add(monster);
        }

    }

}
