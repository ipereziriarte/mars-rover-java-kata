package com.blokura;

public class Main {

    private static final String DATA_PATH = "example.txt";

    public static void main(String[] args) {
        String path;
        if (args.length == 1) {
            path = args[0];
        } else {
            path = DATA_PATH;
        }

        RoverProcessor roverProcessor = RoverProcessorFactory.make();
        roverProcessor.process(path);
    }
}
