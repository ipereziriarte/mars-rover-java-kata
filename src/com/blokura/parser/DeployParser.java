package com.blokura.parser;

import com.blokura.Coordinates;
import com.blokura.Heading;

public class DeployParser {

    public DeployParser() {
        //Empty used for injection
    }

    public Coordinates parse(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Invalid coordinates: should match format 1 2 N");
        }
        String upperCaseInput = input.toUpperCase();
        String[] parts = upperCaseInput.split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid coordinates: should match format 1 2 N");
        }
        try {
            Integer x = Integer.valueOf(parts[0]);
            Integer y = Integer.valueOf(parts[1]);
            Heading heading = Heading.valueOf(parts[2]);

            return new Coordinates(x, y, heading);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid coordinates: should match format 1 2 N");
        }
    }
}
