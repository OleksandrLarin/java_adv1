package com.alevel.lesson18;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        File dir = new File("src/main/resources");
        System.out.println("isDirectory " + dir.isDirectory());
        System.out.println("isFile " + dir.isFile());
        System.out.println("Absolute path " + dir.getAbsolutePath());
        File testFile = new File(dir, "test");
        boolean isCreated = false;
        try {
            isCreated = testFile.createNewFile();
        } catch (IOException e) {
            System.out.println("File can not be created!!!");;
        } finally {
            System.out.println("Is file created " + isCreated);
        }

        File currentDir = new File("src");

        FileExample fileExample = new FileExample();
        fileExample.listFiles(currentDir);
    }

    public void listFiles(File currentDir) {
        if (currentDir.isDirectory()) {
            for (File file : currentDir.listFiles()) {
                if (file.isDirectory()){
                    System.out.println(file.getName() + " directory");
                    listFiles(file);
                } else {
                    System.out.println(file.getName() + " file");
                }
            }
        }
    }
}
