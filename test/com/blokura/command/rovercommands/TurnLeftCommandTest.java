package com.blokura.command.rovercommands;

import com.blokura.TestRover;
import com.blokura.model.Coordinates;
import com.blokura.model.Heading;
import com.blokura.model.Rover;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnLeftCommandTest {

    @Test
    public void shouldHeadSouth_whenTurningLeftFromWest() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00WCoordinates();
        RoverCommand command = new TurnLeftCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert (roverCoordinates.getHeading()).equals(Heading.S);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldHeadEast_whenTurningLeftFromSouth() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00SCoordinates();
        RoverCommand command = new TurnLeftCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert (roverCoordinates.getHeading()).equals(Heading.E);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldHeadNorth_whenTurningLeftFromE() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00ECoordinates();
        RoverCommand command = new TurnLeftCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert (roverCoordinates.getHeading()).equals(Heading.N);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldHeadWest_whenTurningLeftFromNorth() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00NCoordinates();
        RoverCommand command = new TurnLeftCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert (roverCoordinates.getHeading()).equals(Heading.W);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }
}
