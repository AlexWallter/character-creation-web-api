package com.example.enums.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.enums.converters.WeaponQualityConverter;

public class WeaponQualityConverterTest {
    WeaponQualityConverter weaponQualityConverter = new WeaponQualityConverter();

    @Test
    @DisplayName("should return the WeaponQuality value as a String")
    void testConvertToDatabaseColumn() {
        assertEquals("articulada", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.ARTICULADA));
        assertEquals("contundente", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.CONTUNDENTE));
        assertEquals("equilibrada", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.EQUILIBRADA));
        assertEquals("impacto profundo", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.IMPACTO_PROFUNDO));
        assertEquals("longa", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.LONGA));
        assertEquals("sem qualidade", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.NO_QUALITY));
        assertEquals("precisa", weaponQualityConverter.convertToDatabaseColumn(WeaponQuality.PRECISA));

    }
    
    @Test
    @DisplayName("should return the WeaponQuality value as a enum value")
    void testConvertToEntityAttribute() {
        assertEquals(WeaponQuality.ARTICULADA, weaponQualityConverter.convertToEntityAttribute("articulada"));
        assertEquals(WeaponQuality.CONTUNDENTE, weaponQualityConverter.convertToEntityAttribute("contundente"));
        assertEquals(WeaponQuality.EQUILIBRADA, weaponQualityConverter.convertToEntityAttribute("equilibrada"));
        assertEquals(WeaponQuality.IMPACTO_PROFUNDO, weaponQualityConverter.convertToEntityAttribute("impacto profundo"));
        assertEquals(WeaponQuality.LONGA, weaponQualityConverter.convertToEntityAttribute("longa"));
        assertEquals(WeaponQuality.NO_QUALITY, weaponQualityConverter.convertToEntityAttribute("sem qualidade"));
        assertEquals(WeaponQuality.PRECISA, weaponQualityConverter.convertToEntityAttribute("precisa"));
    }
}
