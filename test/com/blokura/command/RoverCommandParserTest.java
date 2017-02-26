package com.blokura.command;

import com.blokura.command.rovercommands.MoveCommand;
import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.command.rovercommands.RoverCommandCollectionBuilder;
import com.blokura.command.rovercommands.RoverCommandParser;
import com.blokura.command.rovercommands.TurnLeftCommand;
import com.blokura.command.rovercommands.TurnRightCommand;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverCommandParserTest {

    @Test
    public void parseShouldReturnEmptyList_whenInputIsEmpty() {
        RoverCommandParser parser = new RoverCommandParser(new RoverCommandCollectionBuilder());
        char[] values = {};

        assert (parser.parse(values)).isEmpty();
    }

    @Test
    public void parseShouldReturnEmptyList_whenInputIsUnknown() {
        RoverCommandParser parser = new RoverCommandParser(new RoverCommandCollectionBuilder());
        char[] values = {'J', 'x'};

        assert (parser.parse(values)).isEmpty();
    }

    @Test
    public void parseShouldSkipValues_whenInputHasInvalidValues() {
        RoverCommandParser parser = new RoverCommandParser(new RoverCommandCollectionBuilder());
        char[] values = {'J', 'l', 'M', 'x', 'r'};
        List<RoverCommand> expected = new ArrayList<>(2);
        expected.add(new TurnLeftCommand());
        expected.add(new MoveCommand());
        expected.add((new TurnRightCommand()));

        List<RoverCommand> result = parser.parse(values);
        assertThat(result, is(expected));
    }
}