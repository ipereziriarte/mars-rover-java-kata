package com.blokura;

import com.blokura.command.CommandSequenceExecutor;
import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.command.rovercommands.RoverCommandCollectionBuilder;
import com.blokura.command.rovercommands.RoverCommandParser;
import com.blokura.data.CommandFactory;
import com.blokura.data.FileReader;
import com.blokura.data.InputType;
import com.blokura.data.ConsoleOutPut;
import com.blokura.model.Coordinates;
import com.blokura.model.Plateau;
import com.blokura.model.Rover;
import com.blokura.parser.DeployParser;
import com.blokura.parser.MovementParser;
import com.blokura.parser.PlateauParser;
import com.blokura.utils.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATA_PATH = "example.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        CommandFactory commandFactory = new CommandFactory();
        PlateauParser plateauParser = new PlateauParser();
        DeployParser deployParser = new DeployParser();
        MovementParser movementParser = new MovementParser();
        RoverCommandParser roverCommandParser = new RoverCommandParser(new RoverCommandCollectionBuilder());
        CommandSequenceExecutor sequenceExecutor = new CommandSequenceExecutor(new ConsoleOutPut());
        RoverInstructionFactory roverInstructionFactory = new RoverInstructionFactory();
        String path;
        if (args.length == 1) {
            path = args[0];
        } else {
            path = DATA_PATH;
        }

        try {
            List<String> input = fileReader.getStringFromFile(path);
            InputType inputType;
            Coordinates coordinates;
            Plateau plateau = null;
            List<Coordinates> coordinatesList = new ArrayList<>();
            List<List<RoverCommand>> commandList = new ArrayList<>();
            List<Pair<Rover, List<RoverCommand>>> instructions = new ArrayList<>();
            for (String line : input) {
                inputType = commandFactory.make(line);
                if (inputType == InputType.PLATEAU) {
                    plateau = plateauParser.parse(line);
                } else if (inputType == InputType.DEPLOY_ZONE) {
                    coordinates = deployParser.parse(line);
                    coordinatesList.add(coordinates);
                } else if (inputType == InputType.MOVEMENT) {
                    List<RoverCommand> commands = roverCommandParser.parse(movementParser.parse(line));
                    commandList.add(commands);
                }
            }
            instructions = roverInstructionFactory.make(coordinatesList, commandList, plateau);

            sequenceExecutor.execute(instructions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
