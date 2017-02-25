package com.blokura.parser;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MovementParserTest {

    @Test
    public void parse_shouldReturnEmpty_whenInputIsEmpty() {
        MovementParser parser = new MovementParser();

        char[] result = parser.parse("");

        assertEquals(0, result.length);
    }

    @Test
    public void parse_shouldReturnExpectedResult_whenInputIsOk() {
        MovementParser parser = new MovementParser();

        char[] result = parser.parse("LMNJ");

        assertArrayEquals(new char[] {'L', 'M', 'N', 'J'}, result);
    }
}
