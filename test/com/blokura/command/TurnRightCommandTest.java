package com.blokura.command;

import com.blokura.Coordinates;
import com.blokura.Heading;
import com.blokura.Rover;
import com.blokura.TestRover;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnRightCommandTest {

    @Test
    public void shouldHeadSouth_whenTurningRightFromEast() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00ECoordinates();
        RoverCommand command = new TurnRightCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.S);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldHeadEast_whenTurningRightFromNorth() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00NCoordinates();
        RoverCommand command = new TurnRightCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.E);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldHeadNorth_whenTurningRightFromWest() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00WCoordinates();
        RoverCommand command = new TurnRightCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.N);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldHeadWest_whenTurningLeftFromSouth() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00SCoordinates();
        RoverCommand command = new TurnRightCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.W);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

}