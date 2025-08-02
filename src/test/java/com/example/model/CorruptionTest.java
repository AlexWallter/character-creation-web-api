package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.model.Corruption;

public class CorruptionTest {
    Corruption corruption = new Corruption();

    @Test
    @DisplayName("Should get the totalCorruption based on the TemporaryCorruption and the PermanentCorrution")
    void testTotalCorruption() {
        corruption.setTemporaryCorruption(2);
        corruption.setPermanentCorrution(3);
        corruption.setTotalCorruption();

        assertEquals(5, corruption.getTotalCorruption());

        corruption.setTemporaryCorruption(7);
        corruption.setPermanentCorrution(5);
        corruption.setTotalCorruption();

        assertEquals(12, corruption.getTotalCorruption());
    }
}
