package com.yarosevych;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<String> readFile(String filePath) {
        checkFilePath(filePath);
        FileReader reader = null;
        Scanner scanner = null;
        List<String> input = new ArrayList<>();
        try {
            reader = new FileReader(filePath);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;
    }

    public static void checkFilePath(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()){
            Printer.printFileLocationError();
            System.exit(1);
        }
    }
}
