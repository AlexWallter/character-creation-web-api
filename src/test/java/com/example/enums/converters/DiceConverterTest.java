package com.example.enums.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.converters.DiceConverter;

public class DiceConverterTest {
    DiceConverter diceConverter = new DiceConverter();
    
    @Test
    @DisplayName("should return the Dice value as a String")
    void testConvertToDatabaseColumn() {
        assertEquals("d4", diceConverter.convertToDatabaseColumn(Dice.D4));
        assertEquals("d6", diceConverter.convertToDatabaseColumn(Dice.D6));
        assertEquals("d8", diceConverter.convertToDatabaseColumn(Dice.D8));
        assertEquals("d10", diceConverter.convertToDatabaseColumn(Dice.D10));
        assertEquals("d12", diceConverter.convertToDatabaseColumn(Dice.D12));
        assertEquals("d20", diceConverter.convertToDatabaseColumn(Dice.D20));
        assertEquals("d100", diceConverter.convertToDatabaseColumn(Dice.D100));
        
    }
    
    @Test
    @DisplayName("should return the Dice value as a enum value")
    void testConvertToEntityAttribute() {
        assertEquals(Dice.D4, diceConverter.convertToEntityAttribute("d4"));
        assertEquals(Dice.D6, diceConverter.convertToEntityAttribute("d6"));
        assertEquals(Dice.D8, diceConverter.convertToEntityAttribute("d8"));
        assertEquals(Dice.D10, diceConverter.convertToEntityAttribute("d10"));
        assertEquals(Dice.D12, diceConverter.convertToEntityAttribute("d12"));
        assertEquals(Dice.D20, diceConverter.convertToEntityAttribute("d20"));
        assertEquals(Dice.D100, diceConverter.convertToEntityAttribute("d100"));
    }
}
