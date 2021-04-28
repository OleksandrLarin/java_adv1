package com.alevel.lesson18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExample {


    public static final String INPUT = "src/main/resources/input.txt";
    public static final String OUTPUT = "src/main/resources/output.txt";

    public static void main(String[] args) {
        IOExample ioExample = new IOExample();
        String text = ioExample.readFromFile(INPUT);
        System.out.println("Text from input.txt " + text);
        String outputText = text.toUpperCase();
        System.out.println("Text int output.txt " + outputText);
        ioExample.writeToFile(OUTPUT, outputText);
    }

    public String readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            int i;
            while ((i = inputStream.read()) != -1) {
                String s = String.valueOf((char) i);
                stringBuilder.append(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }

    public void writeToFile(String fileName, String text) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)){
            outputStream.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
