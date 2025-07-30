package com.example.character_creator.enums.converters;

import java.util.stream.Stream;

import com.example.character_creator.enums.ArmorWeight;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ArmorWeightConvert implements AttributeConverter<ArmorWeight, String> {

    @Override
    public String convertToDatabaseColumn(ArmorWeight armor) {
        if (armor == null) {
            return null;
        }

        return armor.getWeight();
    }

    @Override
    public ArmorWeight convertToEntityAttribute(String armor) {
        return Stream.of(ArmorWeight.values())
                                    .filter(weight -> weight.getWeight().equals(armor))
                                    .findFirst()
                                    .orElseThrow(IllegalArgumentException::new);
    }
}
