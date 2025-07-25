package com.example.character_creator.model;

import org.hibernate.validator.constraints.Length;

import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.enums.converters.WeaponQualityConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity(name = "tb_weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 14)
    private String name;
    
    @NotNull
    @Positive
    private int damage;

    @NotNull
    @Convert(converter = WeaponQualityConverter.class)
    private WeaponQuality quality;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public WeaponQuality getQuality() {
        return quality;
    }
    public void setQuality(WeaponQuality quality) {
        this.quality = quality;
    }
}
