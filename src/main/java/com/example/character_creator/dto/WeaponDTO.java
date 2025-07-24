package com.example.character_creator.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record WeaponDTO(@Positive Long id, 
                        @NotNull @NotBlank @Length(min = 2, max = 14) String name,
                        @NotNull @Positive int damage,
                        @NotNull String quality
                        ) {
}