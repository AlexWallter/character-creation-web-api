package com.example.character_creator.model;

import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.converters.ArmorWeightConvert;
import com.example.character_creator.enums.converters.DiceConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity(name = "tb_armor")
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @NotNull
    @NotBlank
    private String name;
    
    @NotNull
    @Convert(converter = DiceConverter.class)
    private Dice protection;

    @NotNull
    @Convert(converter = ArmorWeightConvert.class)
    private ArmorWeight armorWeight;

    @NotNull
    @PositiveOrZero
    private int impeding;
    
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
    public ArmorWeight getArmorWeight() {
        return armorWeight;
    }
    public void setArmorWeight(ArmorWeight armorWeight) {
        this.armorWeight = armorWeight;
    }
    public Dice getProtection() {
        return protection;
    }
    public void setProtection(Dice protection) {
        this.protection = protection;
    }
    public int getimpeding() {
        return impeding;
    }
    public void setImpeding(int impeding) {
        this.impeding = impeding;
    }    
}
