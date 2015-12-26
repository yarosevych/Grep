package com.yarosevych.io;

import com.yarosevych.utils.Printer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<String> readFile(String filePath) {
        checkFilePath(filePath);
        List<String> input = new ArrayList<>();
        BufferedReader reader = null;
        try {
            File file = new File(filePath);
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
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
