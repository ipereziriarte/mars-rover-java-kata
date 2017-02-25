package com.blokura;

import com.blokura.model.Plateau;

public class TestPlateau {

    public static Plateau givenA5x4Plateau() {
        return new Plateau.PlateauBuilder().withHeight(4).withWidth(5).build();
    }
}
