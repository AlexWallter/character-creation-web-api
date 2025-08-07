package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.model.Armor;

@Component
public class ArmorMapper {
    static public ArmorDTO toArmorDTO(Armor armor) {
        if (armor == null) {
            return null;
        }

        return new ArmorDTO(armor.getId(),
                             armor.getName(),
                             armor.getArmorWeight().getWeight(),
                             armor.getArmorQuality().getQuality(),
                             armor.getProtection().getDice(), 
                             armor.getImpeding());
    }

    static public Armor toArmorEntity(ArmorDTO armorDTO) {
        if (armorDTO == null) {
            return null;
        }

        Armor armor = Armor.builder()
                            .id(armorDTO.id())
                            .name(armorDTO.name())
                            .protection(ConvertStringToEnumValue.convertDiceToValue(armorDTO.protection()))
                            .armorWeight(convertArmorWeightValue(armorDTO.armorWeight()))
                            .armorQuality(convertArmorQualityValue(armorDTO.armorQuality()))
                            .build();

        armor.setImpeding();

        return armor;
    }

    static public ArmorWeight convertArmorWeightValue(String armorWeight) {
        return switch (armorWeight) {
            case "leve" -> ArmorWeight.LEVE;
            case "media" -> ArmorWeight.MEDIA;
            case "pesada" -> ArmorWeight.PESADA;
            default -> throw new IllegalArgumentException("The Armor weight is invalid.");
        };
    }

    static public ArmorQuality convertArmorQualityValue(String armorQuality) {
        return switch (armorQuality) {
            case "desajeitada" -> ArmorQuality.DESAJEITADA;
            case "flexivel" -> ArmorQuality.FLEXIVEL;
            default -> throw new IllegalArgumentException("the quality of the armor is invalid.");
        };
    }
}
