package com.example.character_creator.service;

import java.util.List;

import com.example.character_creator.dto.PlayerCharacterDTO;

public interface CharacterService {
    List<PlayerCharacterDTO> getAllChar();
    PlayerCharacterDTO getByID(Long id);
    String createCharacter(PlayerCharacterDTO character) throws Exception;
    void updatingCharacter(Long id, PlayerCharacterDTO character);
    String deleteCharacterById(Long id);
}
