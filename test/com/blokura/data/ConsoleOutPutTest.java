package com.blokura.data;

import com.blokura.TestRover;
import com.blokura.model.Rover;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleOutPutTest {

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
    public void export_shouldPrintValuesInConsole() {
        OutPut outPut = new ConsoleOutPut();
        Rover rover = TestRover.givenARover1InA5x5PlateauAnd12NCoordinates();

        outPut.export(rover);

        assertEquals("Rover 1 position: 1 2 N\n", outContent.toString());
    }

}