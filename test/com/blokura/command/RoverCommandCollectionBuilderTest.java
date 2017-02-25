package com.blokura.command;

import java.util.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class RoverCommandCollectionBuilderTest {

    @Test
    public void commandCollection_shouldContainMoveCommand() {
        RoverCommandCollectionBuilder commandCollection = new RoverCommandCollectionBuilder();

        Map<String, RoverCommand> commands = commandCollection.getAvailableCommands();

        assert(commands).containsKey("M");
        assertThat(commands.get("M"), instanceOf(MoveCommand.class));
    }

    @Test
    public void commandCollection_shouldContainTurnLeftCommand() {
        RoverCommandCollectionBuilder commandCollection = new RoverCommandCollectionBuilder();

        Map<String, RoverCommand> commands = commandCollection.getAvailableCommands();

        assert(commands).containsKey("L");
        assertThat(commands.get("L"), instanceOf(TurnLeftCommand.class));
    }

    @Test
    public void commandCollection_shouldContainTurnRightCommand() {
        RoverCommandCollectionBuilder commandCollection = new RoverCommandCollectionBuilder();

        Map<String, RoverCommand> commands = commandCollection.getAvailableCommands();

        assert(commands).containsKey("R");
        assertThat(commands.get("R"), instanceOf(TurnRightCommand.class));

    }

}