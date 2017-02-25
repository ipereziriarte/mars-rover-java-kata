package com.blokura.parser;

import com.blokura.utils.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlateauParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputIsEmpty() {
        PlateauParser plateauParser = new PlateauParser();

        plateauParser.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputDoesNotContainSeparator() {
        PlateauParser plateauParser = new PlateauParser();

        plateauParser.parse("5262");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputDoesNotContainNumbers() {
        PlateauParser plateauParser = new PlateauParser();

        plateauParser.parse("ABCxFFF");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputDoesNotContainNumbersInWidth() {
        PlateauParser plateauParser = new PlateauParser();

        plateauParser.parse("ABCX12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_shouldThrowIllegalArgumentException_whenInputDoesNotContainNumbersInHeight() {
        PlateauParser plateauParser = new PlateauParser();

        plateauParser.parse("3xjsjs");
    }

    @Test
    public void parse_shouldReturnAPair_whenInputContainsDownCaseNumbers() {
        PlateauParser plateauParser = new PlateauParser();

        Pair<Integer, Integer> result = plateauParser.parse("3x5");

        assertEquals(3, (int) result.getElement0());
        assertEquals(5, (int) result.getElement1());
    }
}