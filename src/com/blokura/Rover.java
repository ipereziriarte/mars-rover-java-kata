package com.blokura;

/**
 * Created by imanol on 19/02/2017.
 */
public class Rover {

    private final int id;
    private Coordinates coordinates;
    private final Plateau plateau;

    public Rover(int id, final Coordinates coordinates, final Plateau plateau) {
        this.id = id;
        this.coordinates = coordinates;
        this.plateau = plateau;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public int getId() {
        return id;
    }

    public static class RoverBuilder {
        private int id;
        private Coordinates coordinates;
        private Plateau plateau;

        public RoverBuilder withCoordinates(final Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public RoverBuilder withPlateau(final Plateau plateau) {
            this.plateau = plateau;
            return this;
        }

        public RoverBuilder withId(final int id) {
            this.id = id;
            return this;
        }

        public Rover build() {
            return new Rover(id, coordinates, plateau);
        }
    }
}
