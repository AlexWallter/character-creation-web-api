package com.example.enums.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.converters.ArmorQualityConverter;

public class ArmorQualityConverterTest {
    ArmorQualityConverter armorQualityConverter = new ArmorQualityConverter();

    @Test
    @DisplayName("should return the Armor quality as a String")
    void testConvertToDatabaseColumn() {
        assertEquals("desajeitada", armorQualityConverter.convertToDatabaseColumn(ArmorQuality.DESAJEITADA));
        assertEquals("flexivel", armorQualityConverter.convertToDatabaseColumn(ArmorQuality.FLEXIVEL));
    }
    
    @Test
    @DisplayName("should return the Armor quality as a enum value")
    void testConvertToEntityAttribute() {
        assertEquals(ArmorQuality.DESAJEITADA, armorQualityConverter.convertToEntityAttribute("desajeitada"));
        assertEquals(ArmorQuality.FLEXIVEL, armorQualityConverter.convertToEntityAttribute("flexivel"));
    }
}
