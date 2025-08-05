package com.example.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.dto.mapper.WeaponMapper;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.model.Weapon;

public class WeaponMapperTest {
    Weapon weapon = new Weapon();
    WeaponDTO weaponDTO = new WeaponDTO(1L, 
                                        "weapon", 
                                        "d8", 
                                        "equilibrada", 
                                        "A arma fornece +1 na Defesa.");
    @BeforeEach
    void setup() {
        weapon.setId(1L);
        weapon.setName("weapon");
        weapon.setDamage(Dice.D8);
        weapon.setQuality(WeaponQuality.EQUILIBRADA);
        weapon.setQualityDescription(weapon.getQuality().getValue());
    }

    @Test
    void testToweponDTO() {

        WeaponDTO otherWeaponDTO = WeaponMapper.toWeaponDTO(weapon);

        assertEquals(weaponDTO, otherWeaponDTO);
    }

    @Test 
    void testToWeaponEntity() {

        Weapon weaponEntity = WeaponMapper.toWeaponEntity(weaponDTO);

        assertEquals(weaponEntity, weapon);
    }
}
