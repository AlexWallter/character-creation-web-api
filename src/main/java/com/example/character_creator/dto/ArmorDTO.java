package com.example.character_creator.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ArmorDTO(Long id,
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String armorWeight,
        @NotNull String armorQuality, 
        @NotNull String protection,
        @NotNull @PositiveOrZero int impeding ) {    
}
