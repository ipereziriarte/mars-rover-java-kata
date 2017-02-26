package com.blokura;

import com.blokura.command.rovercommands.RoverCommandCollectionBuilder;
import com.blokura.command.rovercommands.RoverCommandParser;
import com.blokura.data.CommandFactory;
import com.blokura.parser.DeployParser;
import com.blokura.parser.InputParser;
import com.blokura.parser.MovementParser;
import com.blokura.parser.PlateauParser;

public final class InputParserFactory {

    private InputParserFactory() {
        // Enforce the static factory pattern
    }

    public static InputParser make() {
        return new InputParser(new CommandFactory(), new DeployParser(), new MovementParser(), new PlateauParser(),
                               new RoverCommandParser(new RoverCommandCollectionBuilder()));
    }
}
