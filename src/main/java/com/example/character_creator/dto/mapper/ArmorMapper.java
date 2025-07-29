package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.enums.Dice;
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
        armor.setProtection(convertDiceToValue(armorDTO.protection()));
        armor.setImpeding(armor.getimpeding());
        
        return armor;
    }
    
    public Dice convertDiceToValue(String dice) {
        return switch (dice) {
            case "d4" -> Dice.D4;
            case "d6" -> Dice.D6;
            case "d8" -> Dice.D8;
            case "d10" -> Dice.D10;
            case "d12" -> Dice.D12;
            case "d20" -> Dice.D20;
            case "d100" -> Dice.D100;
            default -> throw new IllegalArgumentException("Dice value is invalid.");
        };
    }
}
