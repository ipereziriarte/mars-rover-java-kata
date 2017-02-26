package com.blokura;

import com.blokura.model.Plateau;

public class TestPlateau {

    public static Plateau givenA5x4Plateau() {
        return new Plateau.PlateauBuilder().withHeight(4).withWidth(5).build();
    }

    public static Plateau givenA5x5Plateau() {
        return new Plateau.PlateauBuilder().withHeight(5).withWidth(5).build();
    }
}
