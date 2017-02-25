package com.blokura.data;

import com.blokura.model.Rover;

public class ConsoleOutPut implements OutPut {

    public ConsoleOutPut() {
    }

    public void export(Rover rover) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rover ");
        sb.append(rover.getId()).append(" ");
        sb.append(rover.getCoordinates().toString());

        System.out.println(sb.toString());
    }
}