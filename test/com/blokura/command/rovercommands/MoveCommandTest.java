package com.blokura.command.rovercommands;

import com.blokura.TestRover;
import com.blokura.model.Coordinates;
import com.blokura.model.Heading;
import com.blokura.model.Rover;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveCommandTest {

    @Test
    public void shouldMoveUp_whenRoverIsHeadingNorthInBottomLeftCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00NCoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.N);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(1, roverCoordinates.getY());
    }

    @Test
    public void shouldMoveEast_whenRoverIsHeadingEastInBottomLeftCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00ECoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.E);
        assertEquals(1, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldStayStill_whenRoverIsHeadingSouthInBottomLeftCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00SCoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.S);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldStayStill_whenRoverIsHeadingWestInBottomLeftCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd00WCoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.W);
        assertEquals(0, roverCoordinates.getX());
        assertEquals(0, roverCoordinates.getY());
    }

    @Test
    public void shouldStayStill_whenRoverIsHeadingEastInTopRightCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd43ECoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert (roverCoordinates.getHeading()).equals(Heading.E);
        assertEquals(4, roverCoordinates.getX());
        assertEquals(3, roverCoordinates.getY());
    }

    @Test
    public void shouldStayStill_whenRoverIsHeadingNorthInTopRightCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd43NCoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.N);
        assertEquals(4, roverCoordinates.getX());
        assertEquals(3, roverCoordinates.getY());
    }

    @Test
    public void shouldMoveSouth_whenRoverIsHeadingSouthInTopRightCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd43SCoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.S);
        assertEquals(4, roverCoordinates.getX());
        assertEquals(2, roverCoordinates.getY());
    }

    @Test
    public void shouldMoveWest_whenRoverIsHeadingWestInTopRightCorner() {
        Rover rover = TestRover.givenARoverInA5x4PlateauAnd43WCoordinates();
        RoverCommand command = new MoveCommand();

        command.execute(rover);
        Coordinates roverCoordinates = rover.getCoordinates();

        assert(roverCoordinates.getHeading()).equals(Heading.W);
        assertEquals(3, roverCoordinates.getX());
        assertEquals(3, roverCoordinates.getY());
    }

}
