package com.blokura.parser;

import com.blokura.model.Plateau;

public class PlateauParser {

    public PlateauParser() {
        //Empty, used for injection
    }

    public Plateau parse(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Invalid plateau: should match format 5x5");
        }
        String upperCaseInput = input.toUpperCase();
        String[] parts = upperCaseInput.split("X");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid plateau: should match format 5x5");
        }
        try {
            int x = Integer.valueOf(parts[0]);
            int y = Integer.valueOf(parts[1]);
            return new Plateau.PlateauBuilder().withHeight(y).withWidth(x).build();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid plateau: should match format 5x5");
        }
    }
}
