package com.blokura;

import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.data.OutPut;
import com.blokura.model.Rover;
import com.blokura.utils.Pair;
import java.util.List;

public class RoverProcessor {

    private final OutPut outPut;

    public RoverProcessor(OutPut outPut) {
        this.outPut = outPut;
    }

    public void process(List<Pair<Rover, List<RoverCommand>>> instructions) {
        for (Pair<Rover, List<RoverCommand>> pair : instructions) {
            Rover rover = pair.getElement0();
            List<RoverCommand> execution = pair.getElement1();

            for (RoverCommand command : execution) {
                command.execute(rover);
            }

            outPut.export(rover);
        }
    }
}
