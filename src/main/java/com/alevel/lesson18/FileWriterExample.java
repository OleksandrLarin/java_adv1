package com.alevel.lesson18;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        FileWriterExample writer = new FileWriterExample();
        File file = new File("src/main/resources/writerOutput.txt");
        writer.writeText("Some text!!", file);
    }

    public void writeText(String text, File file) {
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
            fileWriter.append("\n");

            fileWriter.append("the end");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
