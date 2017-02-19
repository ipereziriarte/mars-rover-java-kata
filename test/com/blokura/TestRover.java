package com.blokura;

public class TestRover {

    public static Rover givenARoverInA5x4PlateauAnd00NCoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given00NCoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd00SCoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given00SCoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd00WCoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given00WCoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd00ECoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given00ECoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd43ECoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given43ECoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd43SCoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given43SCoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd43WCoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given43WCoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }

    public static Rover givenARoverInA5x4PlateauAnd43NCoordinates() {
        return new Rover.RoverBuilder().withCoordinates(TestCoordinates.given43NCoordinates())
            .withPlateau(TestPlateau.givenA5x4Plateau())
            .build();
    }
}
