package com.yarosevych;

import java.util.List;

public class Printer {

    private static final String HELP_MESSAGE = "--help\n" +
            "Print a usage message briefly summarizing these command-line " +
            "options and the bug-reporting address, then exit.\n" +
            "-v, --invert-match\n" +
            "Invert the sense of matching, to select non-matching lines.\n" +
            "-i, --ignore-case\n" +
            "Ignore case distinctions in both the PATTERN and the input files.\n" +
            "-c, --count\n" +
            "Suppress normal output; instead print a count of matching lines for " +
            "each input file. With the -v, --invert-match option (see below), count " +
            "non-matching lines.\n" +
            "-e PATTERN\n" +
            "Use PATTERN as the pattern.";

    public static void printHelp() {
        System.out.println(HELP_MESSAGE);
    }

    /** no arguments */
    public static void printMatchingRows(List<String> input, String pattern) {
        for (String s : input) {
            if (s.contains(pattern)) {
                System.out.println(s);
            }
        }
    }

    /** -v */
    public static void printRowsInvertMatch(List<String> input, String pattern) {
        for (String s : input) {
            if (!s.contains(pattern)) {
                System.out.println(s);
            }
        }
    }

    /** -i */
    public static void printRowsIgnoreCase(List<String> input, String pattern) {
        String lowerCasePattern = pattern.toLowerCase();
        for (String s : input) {
            String lowerCaseString = s.toLowerCase();
            if (lowerCaseString.contains(lowerCasePattern)) {
                System.out.println(s);
            }
        }
    }

    /** -c */
    public static void printRowsCount(List<String> input, String pattern) {
        int rowsCount = 0;
        for (String s : input) {
            if (s.contains(pattern)) {
                rowsCount++;
            }
        }
        System.out.println(rowsCount);
    }

    /** -c -i */
    public static void printRowsCountIgnoreCase(List<String> input, String pattern) {
        String lowerCasePattern = pattern.toLowerCase();
        int rowsCount = 0;
        for (String s : input) {
            String lowerCaseString = s.toLowerCase();
            if (lowerCaseString.contains(lowerCasePattern)) {
                rowsCount++;
            }
        }
        System.out.println(rowsCount);
    }

    /** -i -v */
    public static void printInvertMatchIgnoreCase(List<String> input, String pattern) {
        String lowerCasePattern = pattern.toLowerCase();
        for (String s : input) {
            String lowerCaseString = s.toLowerCase();
            if (!lowerCaseString.contains(lowerCasePattern)) {
                System.out.println(s);
            }
        }
    }

    /** -c -v */
    public static void printInvertMatchRowsCount(List<String> input, String pattern) {
        int rowsCount = 0;
        for (String s : input) {
            if (!s.contains(pattern)) {
                rowsCount++;
            }
        }
        System.out.println(rowsCount);
    }

    /** -c -v -i */
    public static void printInvertMatchIgnoreCaseRowsCount(List<String> input, String pattern) {
        String lowerCasePattern = pattern.toLowerCase();
        int rowsCount = 0;
        for (String s : input) {
            String lowerCaseString = s.toLowerCase();
            if (!lowerCaseString.contains(lowerCasePattern)) {
                rowsCount++;
            }
        }
        System.out.println(rowsCount);
    }

    /** no pattern */
    public static void printAllLines(List<String> input) {
        for (String s : input) {
            System.out.println(s);
        }
    }

    /** -c & no pattern */
    public static void printRowsCountNoPattern(List<String> input) {
        System.out.println(input.size());
    }

    public static void printFileLocationError() {
        System.out.println("Cannot find file using the location you specified. " +
                "Please check if the specified file location is correct");
    }
}
