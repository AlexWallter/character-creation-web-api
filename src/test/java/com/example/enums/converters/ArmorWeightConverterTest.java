package com.example.enums.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.enums.converters.ArmorWeightConvert;

public class ArmorWeightConverterTest {
    ArmorWeightConvert armorWeightConvert = new ArmorWeightConvert();

    @Test
    @DisplayName("should return the Armor weight as a String")
    void testConvertToDatabaseColumn() {
        assertEquals("leve", armorWeightConvert.convertToDatabaseColumn(ArmorWeight.LEVE));
        assertEquals("media", armorWeightConvert.convertToDatabaseColumn(ArmorWeight.MEDIA));
        assertEquals("pesada", armorWeightConvert.convertToDatabaseColumn(ArmorWeight.PESADA));
        
    }
    
    @Test
    @DisplayName("should return the Armor wight as a enum value")
    void testConvertToEntityAttribute() {
        assertEquals(ArmorWeight.LEVE, armorWeightConvert.convertToEntityAttribute("leve"));
        assertEquals(ArmorWeight.MEDIA, armorWeightConvert.convertToEntityAttribute("media"));
        assertEquals(ArmorWeight.PESADA, armorWeightConvert.convertToEntityAttribute("pesada"));
    }
}
