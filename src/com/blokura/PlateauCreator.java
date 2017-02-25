package com.blokura;

import com.blokura.utils.Pair;

public class PlateauCreator {

    public PlateauCreator() {
        // Empty I'll usually inject this with dagger 2
    }

    public Plateau create(int height, int width) {
        if (height > 0 && width > 0) {
            return new Plateau(height, width);
        } else {
            throw new IllegalArgumentException("A plateau minimum size must be 1x1");
        }

    }

    public Plateau create(Pair<Integer, Integer> input) {
        return create(input.getElement0(), input.getElement1());
    }
}
