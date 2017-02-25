package com.blokura.parser;

import org.junit.Test;

public class DeployParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputIsEmpty() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputIsNotSeparatedBySpaces() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("35n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputIsMissingValues() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("3 W");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputIsInvalid() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("3 Z W");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenHeadingIsInvalid() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("3 4 X");
    }

    @Test
    public void parse_returnValidCoords_whenCoordsMatchFormat() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("3 4 N");
    }

    @Test
    public void parse_returnValidCoords_whenCoordsAreDownCase() {
        DeployParser deployParser = new DeployParser();

        deployParser.parse("1 2 s");
    }
}