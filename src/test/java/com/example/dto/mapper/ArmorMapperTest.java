package com.example.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.dto.mapper.ArmorMapper;
import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.model.Armor;

public class ArmorMapperTest {

    Armor armor = new Armor();
    ArmorDTO armorDTO = new ArmorDTO(1L,
                                     "name", 
                                     "media", 
                                     "desajeitada", 
                                     "d6",
                                      -4);
    
    @Test
    void testToArmorDTO() {
        armor.setId(1L);
        armor.setName("name");
        armor.setProtection(Dice.D6);
        armor.setArmorWeight(ArmorWeight.MEDIA);
        armor.setArmorQuality(ArmorQuality.DESAJEITADA);
        armor.setImpeding();

        ArmorDTO newArmorDTO = ArmorMapper.toArmorDTO(armor);

        assertEquals(armorDTO, newArmorDTO);
    }

    @Test
    void testToArmorEntity() {
        armor.setId(1L);
        armor.setName("name");
        armor.setProtection(Dice.D6);
        armor.setArmorWeight(ArmorWeight.MEDIA);
        armor.setArmorQuality(ArmorQuality.DESAJEITADA);
        armor.setImpeding();

        Armor newArmorEntity = ArmorMapper.toArmorEntity(armorDTO);

        assertEquals(armor, newArmorEntity);
    }
}
