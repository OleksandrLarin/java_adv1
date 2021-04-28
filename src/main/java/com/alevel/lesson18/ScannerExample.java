package com.alevel.lesson18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/scan.txt"))) {
//            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter any text:");
            String value = scanner.nextLine();
            while (!value.equals("end")){
                System.out.println(value);
                value = scanner.nextLine();
            }
        }
    }
}
