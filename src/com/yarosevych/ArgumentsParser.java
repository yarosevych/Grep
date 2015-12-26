package com.yarosevych;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArgumentsParser {

    private boolean invertMatch;
    private boolean ignoreCase;
    private boolean count;
    private boolean help;
    private String pattern;
    private String filePath;

    public ArgumentsParser(String[] args) {
        parseArgs(args);
        this.getFilePath(args);
        this.getPattern(args);
    }

    public void parseArgs(String [] args) {
        List<String> argsList = Arrays.asList(args);
        if (argsList.contains("--help")){
            help = true;
            return;
        }
        if (argsList.contains("-v") || argsList.contains("--invert-match")) {
            invertMatch = true;
        }
        if (argsList.contains("-i") || argsList.contains("--ignore-case")) {
            ignoreCase = true;
        }
        if (argsList.contains("-c") || argsList.contains("--count")) {
            count = true;
        }
    }

    public void getFilePath(String[] args) {
        List<String> argsList = Arrays.asList(args);
        Iterator<String> iterator = argsList.iterator();
        while (iterator.hasNext()) {
            String argument = iterator.next();
            if (argument.charAt(0) == '-' &&
                    argument.charAt(1) == 'f') {
                if (iterator.hasNext()) {
                    filePath = iterator.next();
                }
            }
        }
    }

    public void getPattern(String[] args) {
        List<String> argsList = Arrays.asList(args);
        Iterator<String> iterator = argsList.iterator();
        while (iterator.hasNext()) {
            String argument = iterator.next();
            if (argument.charAt(0) == '-' &&
                    argument.charAt(1) == 'e') {
                if (iterator.hasNext()) {
                    pattern = iterator.next();
                }
            }
        }
    }

    public boolean containInvertMatch() {
        return invertMatch;
    }

    public boolean containIgnoreCase() {
        return ignoreCase;
    }

    public boolean containCount() {
        return count;
    }

    public boolean containHelp() {
        return help;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFilePath() {
        return filePath;
    }
}
