package com.example.character_creator.enums.converters;

import java.util.stream.Stream;

import com.example.character_creator.enums.ArmorQuality;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ArmorQualityConverter implements AttributeConverter<ArmorQuality, String>{

    @Override
    public String convertToDatabaseColumn(ArmorQuality armorQuality) {
        if (armorQuality == null) {
            return null;
        }

        return armorQuality.getQuality();
    }

    @Override
    public ArmorQuality convertToEntityAttribute(String quality) {
        return Stream.of(ArmorQuality.values())
                                     .filter(armorQuality -> armorQuality.getQuality().equals(quality))
                                     .findFirst()
                                     .orElseThrow(IllegalArgumentException::new);
    }
    
}
