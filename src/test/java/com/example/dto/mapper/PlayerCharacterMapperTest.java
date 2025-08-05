package com.example.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.dto.mapper.PlayerCharacterMapper;
import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.Race;
import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.model.Armor;
import com.example.character_creator.model.Attributes;
import com.example.character_creator.model.Corruption;
import com.example.character_creator.model.PlayerCharacter;
import com.example.character_creator.model.Weapon;

public class PlayerCharacterMapperTest {

    PlayerCharacter playerCharacter = new PlayerCharacter();
    Attributes attributes = new Attributes();
    Corruption corruption = new Corruption();
    Weapon weapon = new Weapon();
    Armor armor = new Armor();

    WeaponDTO weaponDTO = new WeaponDTO(1L, 
                                        "weapon", 
                                        "d8", 
                                        "precisa", 
                                        "Concede +1 em Testes de ataque.");

    ArmorDTO armorDTO = new ArmorDTO(1L, 
                                     "armor", 
                                     "leve", 
                                     "flexivel", 
                                     "d4", 
                                     -1);
                                     
    PlayerCharacterDTO playerCharacterDTO = new PlayerCharacterDTO(1L, 
                                                                   "name", 
                                                                   "humano",
                                                                   attributes, 
                                                                   corruption,
                                                                    10,
                                                                    9, 
                                                                    0, 
                                                                    0, 
                                                                    weaponDTO, 
                                                                    armorDTO, 
                                                                    null);
    @BeforeEach
    void setup() {
        attributes.setAccurate(10);
        attributes.setCunning(10);
        attributes.setDiscreet(10);
        attributes.setPersuasive(10);
        attributes.setQuick(10);
        attributes.setResolute(10);
        attributes.setStrong(10);
        attributes.setVigilant(10);

        corruption.setId(1L);
        corruption.setPermanentCorrution(3);
        corruption.setTemporaryCorruption(2);
        corruption.setTotalCorruption();

        weapon.setId(1L);
        weapon.setName("weapon");
        weapon.setDamage(Dice.D8);
        weapon.setQuality(WeaponQuality.PRECISA);
        weapon.setQualityDescription(weapon.getQuality().getValue());

        armor.setId(1L);
        armor.setName("armor");
        armor.setProtection(Dice.D4);
        armor.setArmorWeight(ArmorWeight.LEVE);
        armor.setArmorQuality(ArmorQuality.FLEXIVEL);
        armor.setImpeding();
    
        playerCharacter.setId(1L);
        playerCharacter.setName("name");
        playerCharacter.setRace(Race.HUMANO);
        playerCharacter.setArmor(armor);
        playerCharacter.setWeapon(weapon);
        playerCharacter.setAttributes(attributes);
        playerCharacter.setCorruption(corruption);
        playerCharacter.setHealth();
        playerCharacter.setDefense();
        playerCharacter.setExp(0);
        playerCharacter.setExp(0);
        
    }

    @Test
    void testTocharacterDTO() {
        

        PlayerCharacterDTO otherPlayerCharacterDTO = PlayerCharacterMapper.toDTO(playerCharacter);

        assertEquals(playerCharacterDTO, otherPlayerCharacterDTO);

    }

    @Test
    void testToPlayerCharcterEntity() {
        try {
            PlayerCharacter newPlayerCharacter = PlayerCharacterMapper.toEntity(playerCharacterDTO);

            assertEquals(newPlayerCharacter, playerCharacter);
        } 
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
