package com.blokura;

import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.model.Coordinates;
import com.blokura.model.Plateau;
import com.blokura.model.Rover;
import com.blokura.utils.Pair;
import java.util.ArrayList;
import java.util.List;

public class RoverInstructionFactory {

    public List<Pair<Rover, List<RoverCommand>>> make(List<Coordinates> coordinatesList,
                                                      List<List<RoverCommand>> commandList, Plateau plateau) {
        Coordinates coordinates;
        Pair<Rover, List<RoverCommand>> roverInstruction;
        List<Pair<Rover, List<RoverCommand>>> instructions = new ArrayList<>();
        for (int i = 0; i < coordinatesList.size(); i++) {
            coordinates = coordinatesList.get(i);
            int roverId = i + 1;
            Rover rover =
                new Rover.RoverBuilder().withPlateau(plateau).withCoordinates(coordinates).withId(roverId).build();
            if (commandList.size() > i) {
                List<RoverCommand> com = commandList.get(i);

                roverInstruction = new Pair<>(rover, com);
                instructions.add(roverInstruction);
            }
        }

        return instructions;
    }
}
