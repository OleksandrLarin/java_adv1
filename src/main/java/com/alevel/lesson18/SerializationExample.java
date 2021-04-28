package com.alevel.lesson18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

    private static final String DATA_FILE = "src/main/resources/player.data";

    public static void main(String[] args) {
        SerializationExample sirializator = new SerializationExample();
        Player player = new Player("Vasya", 15);
        sirializator.serialize(player);


        Player newPlayer = sirializator.deserialize();
        System.out.println(newPlayer);
    }

    public void serialize(Player player) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player deserialize() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (Player) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
