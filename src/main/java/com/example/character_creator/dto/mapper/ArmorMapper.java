package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.model.Armor;

@Component
public class ArmorMapper {
    public ArmorDTO toArmorDTO(Armor armor) {
        if (armor == null) {
            return null;
        }

        return new ArmorDTO(armor.getId(),
                             armor.getName(),
                             armor.getArmorWeight().getWeight(),
                             armor.getArmorQuality().getQuality(),
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
        armor.setArmorWeight(convertArmorWeightValue(armorDTO.armorWeight()));
        armor.setArmorQuality(convertArmorQualityValue(armorDTO.armorQuality()));
        armor.setProtection(ConvertStringToValueEnum.convertDiceToValue(armorDTO.protection()));
        armor.setImpeding();
        
        return armor;
    }

    public ArmorWeight convertArmorWeightValue(String armorWeight) {
        return switch (armorWeight) {
            case "leve" -> ArmorWeight.LEVE;
            case "media" -> ArmorWeight.MEDIA;
            case "pesada" -> ArmorWeight.PESADA;
            default -> throw new IllegalArgumentException("The Armor weight is invalid.");
        };
    }

    public ArmorQuality convertArmorQualityValue(String armorQuality) {
        return switch (armorQuality) {
            case "desajeitada" -> ArmorQuality.DESAJEITADA;
            case "flexivel" -> ArmorQuality.FLEXIVEL;
            default -> throw new IllegalArgumentException("the quality of the armor is invalid.");
        };
    }
}
