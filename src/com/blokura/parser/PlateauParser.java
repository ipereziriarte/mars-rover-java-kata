package com.blokura.parser;

import com.blokura.utils.Pair;

public class PlateauParser {

    public PlateauParser() {
        //Empty, used for injection
    }

    public Pair<Integer, Integer> parse(final String input) {
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
            return new Pair<>(x, y);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid plateau: should match format 5x5");
        }
    }
}
