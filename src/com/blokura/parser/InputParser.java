package com.blokura.parser;

import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.command.rovercommands.RoverCommandParser;
import com.blokura.data.CommandFactory;
import com.blokura.data.InputType;
import com.blokura.model.Coordinates;
import com.blokura.model.ParsedResponse;
import com.blokura.model.Plateau;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private final DeployParser deployParser;
    private final CommandFactory commandFactory;
    private final MovementParser movementParser;
    private final PlateauParser plateauParser;
    private final RoverCommandParser roverCommandParser;

    public InputParser(CommandFactory commandFactory,
                       DeployParser deployParser,
                       MovementParser movementParser,
                       PlateauParser plateauParser,
                       RoverCommandParser roverCommandParser) {
        this.commandFactory = commandFactory;
        this.deployParser = deployParser;
        this.movementParser = movementParser;
        this.plateauParser = plateauParser;
        this.roverCommandParser = roverCommandParser;
    }

    public ParsedResponse parse(List<String> input) {
        InputType inputType;
        Coordinates coordinates;
        Plateau plateau = null;
        List<Coordinates> coordinatesList = new ArrayList<>();
        List<List<RoverCommand>> commandList = new ArrayList<>();

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

        return new ParsedResponse(coordinatesList, commandList, plateau);
    }
}
