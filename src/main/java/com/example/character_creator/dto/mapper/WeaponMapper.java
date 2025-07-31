package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.model.Weapon;

@Component
public class WeaponMapper {
    public WeaponDTO toWeaponDTO(Weapon weapon) {
        if (weapon == null) {
            return null;
        }

        return new WeaponDTO(weapon.getId(), 
                            weapon.getName(), 
                            weapon.getDamage().getDice(), 
                            weapon.getQuality().getValue(),
                            weapon.getQualityDescription());
    }

    public Weapon toWeaponEntity(WeaponDTO weaponDTO) {
        if (weaponDTO == null) {
            return null;
        }

        Weapon weapon = new Weapon();
        
        weapon.setId(weaponDTO.id());
        weapon.setName(weaponDTO.name());
        weapon.setDamage(ConvertStringToEnumValue.convertDiceToValue(weaponDTO.damage()));
        weapon.setQuality(convertQualityToValue(weaponDTO.quality()));
        weapon.setQualityDescription(weaponDTO.quality());

        return weapon;
    }

    public WeaponQuality convertQualityToValue(String quality) {
        return switch (quality) {
            case "impacto profundo" -> WeaponQuality.IMPACTO_PROFUNDO;
            case "contundente" -> WeaponQuality.CONTUNDENTE;
            case "equilibrada" -> WeaponQuality.EQUILIBRADA;
            case "precisa" -> WeaponQuality.PRECISA;
            case "articulada" -> WeaponQuality.ARTICULADA;
            case "longa" -> WeaponQuality.LONGA;
            case "sem qualidade" -> WeaponQuality.NO_QUALITY;
            default -> throw new IllegalArgumentException("The weapon quality is not valid.");
        };
    }
}