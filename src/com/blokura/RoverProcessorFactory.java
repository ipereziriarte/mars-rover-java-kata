package com.blokura;

import com.blokura.command.CommandSequenceExecutor;
import com.blokura.data.ConsoleOutPut;
import com.blokura.data.FileReader;
import com.blokura.parser.InputParser;

public final class RoverProcessorFactory {

    private RoverProcessorFactory() {
        // Enforce the static factory pattern
    }

    public static RoverProcessor make() {
        InputParser inputParser = InputParserFactory.make();
        return new RoverProcessor(new CommandSequenceExecutor(new ConsoleOutPut()), new FileReader(), inputParser,
                                  new RoverInstructionFactory());
    }
}
