package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.model.Weapon;

@Component
public class WeaponMapper {
    public WeaponDTO toWeaponDTO(Weapon weapon) {
        if (weapon == null) {
            return null;
        }

        return new WeaponDTO(weapon.getId(), 
                            weapon.getName(), 
                            weapon.getDamage(), 
                            weapon.getQuality());
    }

    public Weapon toWeaponEntity(WeaponDTO weaponDTO) {
        if (weaponDTO == null) {
            return null;
        }

        Weapon weapon = new Weapon();
        
        weapon.setId(weaponDTO.id());
        weapon.setName(weaponDTO.name());
        weapon.setDamage(weaponDTO.damage());
        weapon.setQuality(weaponDTO.quality());

        return weapon;
    }
}
