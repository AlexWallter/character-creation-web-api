package com.example.character_creator.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.example.character_creator.model.Armor;
import com.example.character_creator.model.Attributes;
import com.example.character_creator.model.Corruption;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PlayerCharacterDTO(Long id, 
        @NotNull @NotBlank @Length(min = 1, max = 14) String characterName,
        @NotBlank String race,
        @NotNull @Valid Attributes attributes,
        @NotNull @Valid Corruption corruption,
        int health,
        int defense,
        @PositiveOrZero int exp,
        @PositiveOrZero int money,
        @NotNull @Valid WeaponDTO weapon,
        @NotNull @Valid Armor armor,
        List<String> items) {
}
