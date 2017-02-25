package com.blokura.command;

import com.blokura.Coordinates;
import com.blokura.Heading;
import com.blokura.Rover;

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
