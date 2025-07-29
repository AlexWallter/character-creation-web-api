package com.example.character_creator.enums.converters;

import java.util.stream.Stream;

import com.example.character_creator.enums.Dice;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DiceConverter implements AttributeConverter<Dice, String> {

    @Override
    public String convertToDatabaseColumn(Dice dice) {
        if (dice == null) {
            return null;
        }

        return dice.getDice();
    }

    @Override
    public Dice convertToEntityAttribute(String dice) {
        if (dice == null) {
            return null;
        }
        
        return Stream.of(Dice.values())
                            .filter(value -> value.getDice().equals(dice))
                            .findFirst()
                            .orElseThrow(IllegalArgumentException::new);
    }
    
}
