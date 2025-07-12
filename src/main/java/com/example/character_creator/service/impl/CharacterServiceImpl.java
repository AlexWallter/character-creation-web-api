package com.example.character_creator.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.character_creator.model.PlayerCharacter;
import com.example.character_creator.repository.PlayerCharacterRepo;
import com.example.character_creator.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final PlayerCharacterRepo repository;
    public CharacterServiceImpl(PlayerCharacterRepo repository) {
        this.repository = repository;
    }
    
    @Override
    public Iterable<PlayerCharacter> getAllChar() {
        return repository.findAll();
    }

    @Override
    public PlayerCharacter getByID(Long id) {
        Optional<PlayerCharacter> temp = repository.findById(id);

        if (temp.isPresent()) {
            PlayerCharacter character = temp.get();
            return character;
        }
        else {
            throw new NoSuchElementException("This character wasn't found.");
        }
    }

    @Override
    public String createCharacter(PlayerCharacter character) {
        repository.save(character);
        return "Character created successfully!";
    }

    @Override
    public String deleteCharacterById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("This character wasn't found.");
        }
        repository.deleteById(id);
        return "The character was deleted!";
    }
    
}
