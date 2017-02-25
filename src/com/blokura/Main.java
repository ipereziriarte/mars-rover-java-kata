package com.blokura;

import com.blokura.command.RoverCommand;
import com.blokura.command.RoverCommandCollectionBuilder;
import com.blokura.command.RoverCommandParser;
import com.blokura.data.CommandFactory;
import com.blokura.data.FileReader;
import com.blokura.data.InputType;
import com.blokura.data.OutPut;
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
        OutPut outPut = new OutPut();
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
                    plateau = new PlateauCreator().create(plateauParser.parse(line));
                } else if (inputType == InputType.DEPLOY_ZONE) {
                    coordinates = deployParser.parse(line);
                    coordinatesList.add(coordinates);

                } else if (inputType == InputType.MOVEMENT) {
                    List<RoverCommand> commands = roverCommandParser.parse(movementParser.parse(line));
                    commandList.add(commands);
                }
            }
            Pair<Rover, List<RoverCommand>> roverInstruction;
            for (int i = 0; i < coordinatesList.size(); i ++) {
                coordinates = coordinatesList.get(i);
                int roverId = i + 1;
                Rover rover = new Rover.RoverBuilder().withPlateau(plateau)
                    .withCoordinates(coordinates).withId(roverId).build();
                if (commandList.size() > i) {
                    List<RoverCommand> com = commandList.get(i);

                    roverInstruction = new Pair<>(rover, com);
                    instructions.add(roverInstruction);
                }
            }

            for (Pair<Rover, List<RoverCommand>> pair : instructions) {
                Rover rover = pair.getElement0();
                List<RoverCommand> execution = pair.getElement1();

                for (RoverCommand command : execution) {
                    command.execute(rover);
                }
                outPut.print(rover);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
