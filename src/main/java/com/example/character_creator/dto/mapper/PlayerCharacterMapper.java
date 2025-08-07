package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.enums.Race;
import com.example.character_creator.model.PlayerCharacter;

@Component
public class PlayerCharacterMapper {

    static public PlayerCharacterDTO toDTO(PlayerCharacter character) {
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
                                        WeaponMapper.toWeaponDTO(character.getWeapon()),  
                                        ArmorMapper.toArmorDTO(character.getArmor()), 
                                        character.getItems());
    }

    static public PlayerCharacter toEntity(PlayerCharacterDTO characterDTO) throws IllegalAccessException {
        if (characterDTO == null) {
            return null;
        }

        PlayerCharacter character = PlayerCharacter.builder()
                                                    .id(characterDTO.id())
                                                    .name(characterDTO.characterName())
                                                    .race(convertRaceValue(characterDTO.race()))
                                                    .attributes(characterDTO.attributes())
                                                    .corruption(characterDTO.corruption())
                                                    .exp(characterDTO.exp())
                                                    .money(characterDTO.money())
                                                    .weapon(WeaponMapper.toWeaponEntity(characterDTO.weapon()))
                                                    .armor(ArmorMapper.toArmorEntity(characterDTO.armor()))
                                                    .items(characterDTO.items())
                                                    .build();

        character.setCharacterCorruptionThreshold();
        character.setHealth();
        character.setDefense();

        boolean attributesIsValid = character.getAttributes().validatingAttributes();
        
        if(attributesIsValid) {
            return character;
        }
        else {
            throw new IllegalAccessException("the attribute values must sum up to at least 80.");
        }
    }

    static public Race convertRaceValue(String value) {
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
