package com.example.character_creator.service;

import com.example.character_creator.model.PlayerCharacter;

public interface CharacterService {
    Iterable<PlayerCharacter> getAllChar();
    PlayerCharacter getByID(Long id);
    String createCharacter(PlayerCharacter character);
    void updatingCharacter(Long id, PlayerCharacter character);
    String deleteCharacterById(Long id);
}
