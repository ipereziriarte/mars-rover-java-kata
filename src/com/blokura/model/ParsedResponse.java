package com.blokura.model;

import com.blokura.command.rovercommands.RoverCommand;
import java.util.List;

// This can be replaced by google autovalues
public class ParsedResponse {

    private final List<Coordinates> coordinates;
    private final List<List<RoverCommand>> commandList;
    private final Plateau plateau;

    public ParsedResponse(List<Coordinates> coordinateList, List<List<RoverCommand>> commandList,
                          Plateau plateau) {
        this.coordinates = coordinateList;
        this.commandList = commandList;
        this.plateau = plateau;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public List<List<RoverCommand>> getCommandList() {
        return commandList;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
