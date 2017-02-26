package com.blokura.command;

import com.blokura.TestCommandList;
import com.blokura.TestRover;
import com.blokura.command.rovercommands.RoverCommand;
import com.blokura.data.ConsoleOutPut;
import com.blokura.model.Rover;
import com.blokura.utils.Pair;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandSequenceExecutorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void export_shouldPrintARoverIn13NPosition_whenRunningExampleCode() {
        Rover rover = TestRover.givenARover1InA5x5PlateauAnd12NCoordinates();
        List<RoverCommand> sequence = TestCommandList.givenTheRover1CommandSecuence();
        Pair<Rover, List<RoverCommand>> rover1 = new Pair<>(rover, sequence);
        List<Pair<Rover, List<RoverCommand>>> input = new ArrayList<>(1);
        input.add(rover1);
        CommandSequenceExecutor sequenceExecutor = new CommandSequenceExecutor(new ConsoleOutPut());

        sequenceExecutor.execute(input);

        assertEquals("Rover 1 position: 1 3 N\n", outContent.toString());
    }
}