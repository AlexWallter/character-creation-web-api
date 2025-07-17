package com.example.character_creator.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.model.PlayerCharacter;

@Component
public class PlayerCharacterMapper {
    public PlayerCharacterDTO toDTO(PlayerCharacter character) {
        if (character == null) {
            return null;
        }

        return new PlayerCharacterDTO(character.getId(), 
                character.getName(), 
                character.getRace(), 
                character.getAttributes(), 
                character.getHealth(), 
                character.getDefense(), 
                character.getExp(), 
                character.getMoney(), 
                character.getWeapon(),  
                character.getArmor(), 
                character.getItems());

    }

    public PlayerCharacter toEntity(PlayerCharacterDTO characterDTO) {
        if (characterDTO == null) {
            return null;
        }

        PlayerCharacter character = new PlayerCharacter();
        character.setId(characterDTO.id());
        character.setName(characterDTO.characterName());
        character.setRace(characterDTO.race());
        character.setAttributes(characterDTO.attributes());
        character.setHealth();
        character.setExp(characterDTO.exp());
        character.setMoney(characterDTO.money());
        character.setWeapon(characterDTO.weapon());
        character.setArmor(characterDTO.armor());
        character.setDefense();
        character.setItems(characterDTO.items());

        return character;
    }
}
