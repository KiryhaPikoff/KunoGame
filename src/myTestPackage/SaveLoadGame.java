package myTestPackage;

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

        ObjectInputStream objectInputStream = null;

        objectInputStream = new ObjectInputStream(new FileInputStream(new File("resources/saves/tempSave/" + currentChunk.hashCode() + ".txt")));


        List<Coordinates> coordMonsterList = ((List<Coordinates>) objectInputStream.readObject());

        for (Coordinates coordMonster : coordMonsterList) {
            Monster monster = MonsterFabrica.createDodya();
            monster.setCoordinates(coordMonster);
            monsterList.add(monster);
        }

    }

}
