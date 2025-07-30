package com.example.character_creator.dto;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArmorDTO(Long id,
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String armorWeight,
        @NotNull String armorQuality, 
        @NotNull String protection,
        @NotNull @NegativeOrZero int impeding ) {    
}
