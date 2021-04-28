package com.alevel.lesson18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleWriter {
    public static void main(String[] args) {
        File file = new File("src/main/resources/consoleOutput.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String line = reader.readLine();
            while (!line.equals("q")) {
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
