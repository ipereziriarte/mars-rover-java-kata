package com.blokura.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RoverCommandParser {

    private final Map<String, RoverCommand> availableCommands;

    public RoverCommandParser(RoverCommandCollectionBuilder builder) {
        this.availableCommands = builder.getAvailableCommands();
    }

    public List<RoverCommand> parse(char[] commandInput) {
        if (commandInput.length == 0) {
            return Collections.emptyList();
        }
        int numberOfCommands = commandInput.length;
        List<RoverCommand> result = new ArrayList<>(numberOfCommands);
        String value;
        for (int i = 0; i < numberOfCommands; i++) {
            value = String.valueOf(commandInput[i]).toUpperCase();
            if (availableCommands.containsKey(value)) {
                result.add(availableCommands.get(value));
            }
            // If the command is unknown we could throw an exception or whatever
            // I decided to silently manage the error and ignore unknown commands
        }

        return result;
    }
}
