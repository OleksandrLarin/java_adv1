package com.alevel.lesson18;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JsonCreator {

    public static final String DELIMITER = "=";
    public static final String PAIR = "\"%s\":\"%s\"";

    public static void main(String[] args) {
        JsonCreator jsonCreator = new JsonCreator();

        System.out.println("Enter pairs <key>=<value> OR 'end' for finish");
        Map<String, String> pairs = jsonCreator.readFromConsole();

        jsonCreator.writeToJson(pairs, new File("src/main/resources/output.json"));

    }

    public Map<String, String> readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> pairs = new HashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] pair = line.split(DELIMITER); // abc = qwe {"abc", "qwe"}
            pairs.put(pair[0].trim(), pair[1].trim());
            line = scanner.nextLine();
        }
        return pairs;
    }

    public void writeToJson(Map<String, String> pairs, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("{");
            int counter = 0;
            for (Map.Entry<String, String> entry : pairs.entrySet()) {
                counter++;
                fileWriter.append(String.format(PAIR, entry.getKey(), entry.getValue()));
                if (counter < pairs.size()) {
                    fileWriter.append(",");
                }
            }
            fileWriter.append("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
