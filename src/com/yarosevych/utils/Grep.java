package com.yarosevych.utils;

import com.yarosevych.io.Reader;

import java.util.List;

public class Grep {
    private ArgumentsParser arguments;
    private String filePath;
    private String pattern;
    private List<String> input;

    public void startGrep(String[] args) {
        initializeGrep(args);

        if (arguments.containHelp()) {
            Printer.printHelp();
        } else if (pattern == null &&
                arguments.containCount()) {
            Printer.printRowsCountNoPattern(input);
        } else if (pattern == null || pattern.isEmpty()) {
            Printer.printAllLines(input);
        } else if (arguments.containCount() &&
                arguments.containIgnoreCase() &&
                arguments.containInvertMatch()) {
            Printer.printInvertMatchIgnoreCaseRowsCount(input, pattern);
        } else if (arguments.containCount() &&
                arguments.containInvertMatch()) {
            Printer.printInvertMatchRowsCount(input, pattern);
        } else if (arguments.containCount() &&
                arguments.containIgnoreCase()) {
            Printer.printRowsCountIgnoreCase(input, pattern);
        } else if (arguments.containIgnoreCase() &&
                arguments.containInvertMatch()) {
            Printer.printInvertMatchIgnoreCase(input, pattern);
        } else if (arguments.containCount()) {
            Printer.printRowsCount(input, pattern);
        } else if (arguments.containInvertMatch()) {
            Printer.printRowsInvertMatch(input, pattern);
        } else if (arguments.containIgnoreCase()) {
            Printer.printRowsIgnoreCase(input, pattern);
        } else {
            Printer.printMatchingRows(input, pattern);
        }
    }

    public void initializeGrep(String[] args) {
        arguments = new ArgumentsParser(args);
        filePath = arguments.getFilePath();
        pattern = arguments.getPattern();
        input = Reader.readFile(filePath);
    }
}
