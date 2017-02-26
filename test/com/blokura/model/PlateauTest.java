package com.blokura.model;

import com.blokura.TestPlateau;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlateauTest {

    @Test
    public void includes_shouldReturnTrue_whenCoordinatesAreInitial() {
        Plateau plateau = TestPlateau.givenA5x4Plateau();

        assertTrue(plateau.includes(0, 0));
    }

    @Test
    public void includes_shouldReturnTrue_whenCoordinatesAreTopMost() {
        Plateau plateau = TestPlateau.givenA5x4Plateau();

        assertTrue(plateau.includes(5, 4));
    }

    @Test
    public void includes_shouldReturnFalse_whenBothCoordinatesAreNegative() {
        Plateau plateau = TestPlateau.givenA5x4Plateau();

        assertFalse(plateau.includes(-1, -1));
    }

    @Test
    public void includes_shouldReturnFalse_whenBothCoordinatesAreOutSide() {
        Plateau plateau = TestPlateau.givenA5x4Plateau();

        assertFalse(plateau.includes(6, 5));
    }

    @Test
    public void includes_shouldReturnFalse_whenWidthIsOutSide() {
        Plateau plateau = TestPlateau.givenA5x4Plateau();

        assertFalse(plateau.includes(6, 3));
    }

    @Test
    public void includes_shouldReturnFalse_whenHeightIsOutSide() {
        Plateau plateau = TestPlateau.givenA5x4Plateau();

        assertFalse(plateau.includes(4, 5));
    }
}