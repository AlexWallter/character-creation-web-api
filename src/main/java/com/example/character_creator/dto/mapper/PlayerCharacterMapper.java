package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.enums.Race;
import com.example.character_creator.model.PlayerCharacter;

@Component
public class PlayerCharacterMapper {

    private final WeaponMapper weaponMapper;
    private final ArmorMapper armorMapper;
    public PlayerCharacterMapper(WeaponMapper weaponMapper, ArmorMapper armorMapper) {
        this.weaponMapper = weaponMapper;
        this.armorMapper = armorMapper;
    }
    

    public PlayerCharacterDTO toDTO(PlayerCharacter character) {
        if (character == null) {
            return null;
        }

        return new PlayerCharacterDTO(character.getId(), 
                character.getName(), 
                character.getRace().getValue(), 
                character.getAttributes(),
                character.getCorruption(), 
                character.getHealth(), 
                character.getDefense(), 
                character.getExp(), 
                character.getMoney(),
                weaponMapper.toWeaponDTO(character.getWeapon()),  
                armorMapper.toArmorDTO(character.getArmor()), 
                character.getItems());
    }

    public PlayerCharacter toEntity(PlayerCharacterDTO characterDTO) throws IllegalAccessException {
        if (characterDTO == null) {
            return null;
        }

        PlayerCharacter character = new PlayerCharacter();
        character.setId(characterDTO.id());
        character.setName(characterDTO.characterName());
        character.setRace(convertRaceValue(characterDTO.race()));
        character.setAttributes(characterDTO.attributes());
        character.setCorruption(characterDTO.corruption());
        character.setCharacterCorruptionThreshold();
        character.getCorruption().setTotalCorruption();
        character.setHealth();
        character.setExp(characterDTO.exp());
        character.setMoney(characterDTO.money());
        character.setWeapon(weaponMapper.toWeaponEntity(characterDTO.weapon()));
        character.setArmor(armorMapper.toArmorEntity(characterDTO.armor()));
        character.setDefense();
        character.setItems(characterDTO.items());

        boolean attributesIsValid = character.getAttributes().validatingAttributes();
        
        if(attributesIsValid) {
            return character;
        }
        else {
            throw new IllegalAccessException("the attribute values must sum up to at least 80.");
        }
    }

    public Race convertRaceValue(String value) {
        if (value == null) {
            return null;
        }

        return switch (value) {
            case "humano" -> Race.HUMANO;
            case "cambiante" -> Race.CAMBIANTE;
            case "goblin" -> Race.GOBLIN;
            case "ogro" -> Race.OGRO;            
            default -> throw new IllegalArgumentException("The name of the race is incorrect/invalid");
        };
    }

}
