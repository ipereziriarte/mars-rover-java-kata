package com.blokura.data;

import com.blokura.model.Rover;

/**
 * Output implementation to console io
 */
public class ConsoleOutPut implements OutPut {

    public ConsoleOutPut() {
        // Empty. Used to inject
    }

    public void export(Rover rover) {
        StringBuilder sb = new StringBuilder().append("Rover ")
            .append(rover.getId())
            .append(" ")
            .append("position:")
            .append(" ")
            .append(rover.getCoordinates().toString());

        System.out.println(sb.toString());
    }
}
