package com.example.enums.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.Race;
import com.example.character_creator.enums.converters.RaceConverter;

public class RaceConverterTest {
    RaceConverter raceConverter = new RaceConverter();

    @Test
    @DisplayName("should return the Race value as a String")
    void testConvertToDatabaseColumn() {
        assertEquals("cambiante", raceConverter.convertToDatabaseColumn(Race.CAMBIANTE));
        assertEquals("goblin", raceConverter.convertToDatabaseColumn(Race.GOBLIN));
        assertEquals("humano", raceConverter.convertToDatabaseColumn(Race.HUMANO));
        assertEquals("ogro", raceConverter.convertToDatabaseColumn(Race.OGRO));
    }
    
    @Test
    @DisplayName("should return the Race value as a enum value")
    void testConvertToEntityAttribute() {
        assertEquals(Race.CAMBIANTE, raceConverter.convertToEntityAttribute("cambiante"));
        assertEquals(Race.GOBLIN, raceConverter.convertToEntityAttribute("goblin"));
        assertEquals(Race.HUMANO, raceConverter.convertToEntityAttribute("humano"));
        assertEquals(Race.OGRO, raceConverter.convertToEntityAttribute("ogro"));
    }
}
