package com.blokura.data;

public class CommandFactory {

    public CommandFactory() {
        //Empty used for injection
    }

    public InputType make(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("You must provide a valid input");
        }
        if (isPlateau(input)) {
            return InputType.PLATEAU;
        } else if (isDeploy(input)) {
            return InputType.DEPLOY_ZONE;
        } else {
            return InputType.MOVEMENT;
        }
    }

    private boolean isPlateau(final String input) {
        String[] parts = input.toUpperCase().split("X");
        return parts.length == 2;
    }

    private boolean isDeploy(final String input) {
        String[] parts = input.toUpperCase().split("\\s+");
        return parts.length == 3;
    }
}
