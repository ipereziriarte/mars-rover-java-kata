package com.blokura;

public class TestCoordinates {

    public static Coordinates given00NCoordinates() {
        return new Coordinates(0, 0, Heading.N);
    }

    public static Coordinates given00SCoordinates() {
        return new Coordinates(0, 0, Heading.S);
    }

    public static Coordinates given00WCoordinates() {
        return new Coordinates(0, 0, Heading.W);
    }

    public static Coordinates given00ECoordinates() {
        return new Coordinates(0, 0, Heading.E);
    }

    public static Coordinates given43ECoordinates() {
        return new Coordinates(4, 3, Heading.E);
    }

    public static Coordinates given43NCoordinates() {
        return new Coordinates(4, 3, Heading.N);
    }

    public static Coordinates given43SCoordinates() {
        return new Coordinates(4, 3, Heading.S);
    }

    public static Coordinates given43WCoordinates() {
        return new Coordinates(4, 3, Heading.W);
    }
}
