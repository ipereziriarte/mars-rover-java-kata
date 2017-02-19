package com.blokura.command;

import com.blokura.Coordinates;
import com.blokura.Heading;
import com.blokura.Plateau;
import com.blokura.Rover;

public class MoveCommand implements RoverCommand {

    public MoveCommand() {
        // Empty
    }

    public void execute(Rover rover) {
        Coordinates nextCoordinates = moveToCoordinates(rover.getCoordinates(), rover.getPlateau());
        rover.setCoordinates(nextCoordinates);
    }

    private Coordinates moveToCoordinates(Coordinates currentCoordinates, Plateau plateau) {
        Heading heading = currentCoordinates.getHeading();
        int x = currentCoordinates.getX();
        int y = currentCoordinates.getY();

        int nextX = moveX(x, heading);
        int nextY = moveY(y, heading);

        if (plateau.includes(nextX, nextY)) {
            return new Coordinates(nextX, nextY, heading);
        }

        return currentCoordinates;
    }

    private int moveX(final int x, Heading heading) {
        switch (heading) {
            case N:
                return x;
            case E:
                return x + 1;
            case S:
                return x;
            case W:
                return x - 1;
            default:
                return x;
        }
    }

    private int moveY(final int y, final Heading heading) {
        switch (heading) {
            case N:
                return y + 1;
            case E:
                return y;
            case S:
                return y - 1;
            case W:
                return y;
            default:
                return y;
        }
    }
}
