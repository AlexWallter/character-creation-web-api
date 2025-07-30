package com.example.character_creator.dto.mapper;

import com.example.character_creator.enums.Dice;

public class ConvertStringToValueEnum {
    static public Dice convertDiceToValue(String dice) {
        return switch (dice) {
            case "d4" -> Dice.D4;
            case "d6" -> Dice.D6;
            case "d8" -> Dice.D8;
            case "d10" -> Dice.D10;
            case "d12" -> Dice.D12;
            case "d20" -> Dice.D20;
            case "d100" -> Dice.D100;
            default -> throw new IllegalArgumentException("Dice value is invalid.");
        };
    }
}
