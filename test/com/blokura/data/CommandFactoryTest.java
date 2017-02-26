package com.blokura.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void make_shouldReturnPlateau_whenInputMatchesPlateauDowncasePattern() {
        CommandFactory commandFactory = new CommandFactory();

        InputType plateau = commandFactory.make("5x5");

        assertEquals(InputType.PLATEAU, plateau);
    }

    @Test
    public void make_shouldReturnPlateau_whenInputMatchesPlateauPattern() {
        CommandFactory commandFactory = new CommandFactory();

        InputType plateau = commandFactory.make("5X5");

        assertEquals(InputType.PLATEAU, plateau);
    }

    @Test
    public void make_shouldReturnDeploy_whenInputMatchesDeploy() {
        CommandFactory commandFactory = new CommandFactory();

        InputType deploy = commandFactory.make("1 2 N");

        assertEquals(InputType.DEPLOY_ZONE, deploy);
    }

    @Test
    public void make_shouldReturnMovement_whenInputMatchesMovementPattern() {
        CommandFactory commandFactory = new CommandFactory();

        InputType  movement = commandFactory.make("LLMRRM");

        assertEquals(InputType.MOVEMENT, movement);
    }
}