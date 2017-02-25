package com.blokura;

public class PlateauCreator {

    public PlateauCreator() {
        // Empty I'll usually inject this with dagger 2
    }

    public Plateau create(int height, int width) {
        return new Plateau(height, width);
    }
}
