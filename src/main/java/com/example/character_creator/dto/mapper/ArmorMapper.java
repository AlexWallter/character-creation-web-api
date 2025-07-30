package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.model.Armor;

@Component
public class ArmorMapper {
    public ArmorDTO toArmorDTO(Armor armor) {
        if (armor == null) {
            return null;
        }

        return new ArmorDTO(armor.getId(),
                             armor.getName(),
                             armor.getProtection().getDice(), 
                             armor.getimpeding());
    }

    public Armor toArmorEntity(ArmorDTO armorDTO) {
        if (armorDTO == null) {
            return null;
        }

        Armor armor = new Armor();
        armor.setId(armorDTO.id());
        armor.setName(armorDTO.name());
        armor.setProtection(ConvertStringToValueEnum.convertDiceToValue(armorDTO.protection()));
        armor.setImpeding(armorDTO.impeding());
        
        return armor;
    }
}
