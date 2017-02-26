package com.blokura;

import com.blokura.command.CommandSequenceExecutor;
import com.blokura.command.rovercommands.RoverCommandCollectionBuilder;
import com.blokura.command.rovercommands.RoverCommandParser;
import com.blokura.data.CommandFactory;
import com.blokura.data.ConsoleOutPut;
import com.blokura.data.FileReader;
import com.blokura.parser.DeployParser;
import com.blokura.parser.InputParser;
import com.blokura.parser.MovementParser;
import com.blokura.parser.PlateauParser;

public class Main {

    private static final String DATA_PATH = "example.txt";

    public static void main(String[] args) {
        RoverCommandParser roverCommandParser = new RoverCommandParser(new RoverCommandCollectionBuilder());

        String path;
        if (args.length == 1) {
            path = args[0];
        } else {
            path = DATA_PATH;
        }

        InputParser inputParser =
            new InputParser(new CommandFactory(), new DeployParser(), new MovementParser(), new PlateauParser(),
                            new RoverCommandParser(new RoverCommandCollectionBuilder()));

        RoverProcessor roverProcessor =
            new RoverProcessor(new CommandSequenceExecutor(new ConsoleOutPut()), new FileReader(), inputParser,
                               new RoverInstructionFactory());

        roverProcessor.process(path);
    }
}
