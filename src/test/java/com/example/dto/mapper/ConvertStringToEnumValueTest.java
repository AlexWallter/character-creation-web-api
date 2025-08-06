package com.example.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.character_creator.dto.mapper.ConvertStringToEnumValue;
import com.example.character_creator.enums.Dice;

public class ConvertStringToEnumValueTest {

    @Test
    void testConvertDiceToValue() {
        Assertions.assertAll(
            ()->assertEquals(Dice.D4, ConvertStringToEnumValue.convertDiceToValue("d4")),
            ()->assertEquals(Dice.D6, ConvertStringToEnumValue.convertDiceToValue("d6")),
            ()->assertEquals(Dice.D8, ConvertStringToEnumValue.convertDiceToValue("d8")),
            ()->assertEquals(Dice.D10, ConvertStringToEnumValue.convertDiceToValue("d10")),
            ()->assertEquals(Dice.D12, ConvertStringToEnumValue.convertDiceToValue("d12")),
            ()->assertEquals(Dice.D20, ConvertStringToEnumValue.convertDiceToValue("d20")),
            ()->assertEquals(Dice.D100, ConvertStringToEnumValue.convertDiceToValue("d100"))
        );
    }
}
