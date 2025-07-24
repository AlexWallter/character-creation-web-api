package com.example.character_creator.enums.converters;

import java.util.stream.Stream;

import com.example.character_creator.enums.WeaponQuality;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class WeaponQualityConverter implements AttributeConverter<WeaponQuality, String> {

    @Override
    public String convertToDatabaseColumn(WeaponQuality quality) {
        if (quality == null) {
            return null;
        }

        return quality.getValue();
    }

    @Override
    public WeaponQuality convertToEntityAttribute(String quality) {
        if (quality == null) {
            return null;
        }
        
        return Stream.of(WeaponQuality.values())
        .filter(value -> value.getValue().equals(quality))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
    }
    
}
