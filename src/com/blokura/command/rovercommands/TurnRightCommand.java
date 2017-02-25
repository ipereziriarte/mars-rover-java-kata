package com.blokura.command.rovercommands;

import com.blokura.model.Coordinates;
import com.blokura.model.Heading;
import com.blokura.model.Rover;

public class TurnRightCommand implements RoverCommand {

    @Override
    public void execute(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        Heading nextHeading = turnRight(coordinates);
        coordinates.setHeading(nextHeading);
        rover.setCoordinates(coordinates);
    }

    private Heading turnRight(Coordinates coordinates) {
        switch (coordinates.getHeading()) {
            case N:
                return Heading.E;
            case E:
                return Heading.S;
            case S:
                return Heading.W;
            case W:
                return Heading.N;
            default:
                return coordinates.getHeading();
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof TurnRightCommand;
    }
}
