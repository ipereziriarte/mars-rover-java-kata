package com.blokura.command.rovercommands;

import java.util.HashMap;
import java.util.Map;

public class RoverCommandCollectionBuilder {

    private final Map<String, RoverCommand> roverCommands;

    public RoverCommandCollectionBuilder() {
        this.roverCommands = new HashMap<>(3);
        roverCommands.put("M", new MoveCommand());
        roverCommands.put("L", new TurnLeftCommand());
        roverCommands.put("R", new TurnRightCommand());
    }

    public Map<String, RoverCommand> getAvailableCommands() {
        return roverCommands;
    }
}
