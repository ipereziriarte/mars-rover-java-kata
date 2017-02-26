package com.blokura;

import com.blokura.command.rovercommands.MoveCommand;
import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.command.rovercommands.TurnLeftCommand;
import java.util.ArrayList;
import java.util.List;

public class TestCommandList {

    public static List<RoverCommand> givenTheRover1CommandSecuence() {
        List<RoverCommand> commands = new ArrayList<>(9);
        commands.add(new TurnLeftCommand());
        commands.add(new MoveCommand());
        commands.add(new TurnLeftCommand());
        commands.add(new MoveCommand());
        commands.add(new TurnLeftCommand());
        commands.add(new MoveCommand());
        commands.add(new TurnLeftCommand());
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        return commands;
    }
}
