package com.example.character_creator.service;

import com.example.character_creator.model.PlayerCharacter;

public interface CharacterService {
    Iterable<PlayerCharacter> getAllChar();
    PlayerCharacter getByID(Long id);
    String createCharacter(PlayerCharacter character);
    void updatingMoney(Long charID, int value);
    void updatingExp(Long charID, int value);
    String deleteCharacterById(Long id);
}
