package com.example.character_creator.model;

import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.converters.ArmorQualityConverter;
import com.example.character_creator.enums.converters.ArmorWeightConvert;
import com.example.character_creator.enums.converters.DiceConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    @Convert(converter = ArmorQualityConverter.class)
    private ArmorQuality armorQuality;

    @NotNull
    @NegativeOrZero
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
    public ArmorQuality getArmorQuality() {
        return armorQuality;
    }
    public void setArmorQuality(ArmorQuality armorQuality) {
        this.armorQuality = armorQuality;
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
    public void setImpeding() {
        switch (armorWeight.getWeight()) {
            case "leve":
                impeding = -2;
                break;
            case "media":
                impeding = -3;
                break;
            case "pesada":
                impeding = -4;
                break;
            default:
                throw new IllegalArgumentException("The armor weight must be leve, media or pesada");
        }

        switch (armorQuality.getQuality()) {
            case "flexivel":
                ++impeding;
                break;
            case "desajeitada":
                --impeding;
                break;
            default:
                break;
        }
    }    
}
