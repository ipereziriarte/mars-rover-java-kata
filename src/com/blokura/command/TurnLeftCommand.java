package com.blokura.command;

import com.blokura.Coordinates;
import com.blokura.Heading;
import com.blokura.Rover;

public class TurnLeftCommand implements RoverCommand {

    @Override
    public void execute(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        Heading nextHeading = turnLeft(coordinates);
        coordinates.setHeading(nextHeading);
        rover.setCoordinates(coordinates);
    }

    private Heading turnLeft(Coordinates coordinates) {
        switch (coordinates.getHeading()) {
            case N:
                return Heading.W;
            case E:
                return Heading.N;
            case S:
                return Heading.E;
            case W:
                return Heading.S;
            default:
                return coordinates.getHeading();
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof TurnLeftCommand;
    }
}
