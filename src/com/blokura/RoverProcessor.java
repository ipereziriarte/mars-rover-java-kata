package com.blokura;

import com.blokura.command.CommandSequenceExecutor;
import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.data.FileReader;
import com.blokura.model.ParsedResponse;
import com.blokura.model.Rover;
import com.blokura.parser.InputParser;
import com.blokura.utils.Pair;
import java.io.IOException;
import java.util.List;

public class RoverProcessor {

    private final CommandSequenceExecutor sequenceExecutor;
    private final FileReader fileReader;
    private final InputParser inputParser;
    private final RoverInstructionFactory roverInstructionFactory;

    public RoverProcessor(final CommandSequenceExecutor executor,
                          final FileReader fileReader, final InputParser inputParser,
                          RoverInstructionFactory roverInstructionFactory) {
        this.sequenceExecutor = executor;
        this.fileReader = fileReader;
        this.inputParser = inputParser;
        this.roverInstructionFactory = roverInstructionFactory;
    }

    public void process(String path) {
        try {
            List<String> input = fileReader.getStringFromFile(path);
            ParsedResponse response = inputParser.parse(input);
            List<Pair<Rover, List<RoverCommand>>> instructions =
                roverInstructionFactory.make(response.getCoordinates(), response.getCommandList(),
                                             response.getPlateau());
            sequenceExecutor.execute(instructions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
