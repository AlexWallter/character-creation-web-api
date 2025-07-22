package com.example.character_creator.enums.converters;

import java.util.stream.Stream;

import com.example.character_creator.enums.Race;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RaceConverter implements AttributeConverter<Race, String>{

    @Override
    public String convertToDatabaseColumn(Race race) {
        if (race == null) {
            return null;
        }

        return race.getValue();
    }

    @Override
    public Race convertToEntityAttribute(String race) {
        if (race == null) {
            return null;            
        }

        return Stream.of(Race.values())
        .filter(value -> value.getValue().equals(race))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
    }    
}
