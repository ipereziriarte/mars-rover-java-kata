package com.blokura.parser;

public class MovementParser {

    public MovementParser() {
        //Empty, used for injection
    }

    public char[] parse(String input) {
        if (input.isEmpty()) {
            return new char[] {};
        } else {
            return input.toUpperCase().toCharArray();
        }
    }
}
