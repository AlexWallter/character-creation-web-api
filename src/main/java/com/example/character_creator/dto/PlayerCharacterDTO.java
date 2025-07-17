package com.example.character_creator.dto;

import java.util.List;

import com.example.character_creator.model.Armor;
import com.example.character_creator.model.Attributes;
import com.example.character_creator.model.Weapon;

public record PlayerCharacterDTO(Long id, 
        String characterName,
        String race,
        Attributes attributes,
        int health,
        int defense,
        int exp,
        int money,
        Weapon weapon,
        Armor armor,
        List<String> items) {
}
