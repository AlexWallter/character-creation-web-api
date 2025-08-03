package com.example.character_creator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.dto.mapper.PlayerCharacterMapper;
import com.example.character_creator.model.PlayerCharacter;
import com.example.character_creator.repository.PlayerCharacterRepo;
import com.example.character_creator.repository.WeaponRepo;
import com.example.character_creator.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final PlayerCharacterRepo repository;
    private final WeaponRepo weaponRepo;
    private final PlayerCharacterMapper playerCharacterMapper;

    public CharacterServiceImpl(PlayerCharacterRepo repository, 
                                PlayerCharacterMapper playerCharacterMapper,
                                WeaponRepo weaponRepo) 
    {
        this.repository = repository;
        this.weaponRepo = weaponRepo;
        this.playerCharacterMapper = playerCharacterMapper;
    }
    
    @Override
    public List<PlayerCharacterDTO> getAllChar() {
        List<PlayerCharacterDTO> character = new ArrayList<>();

        repository.findAll().forEach(playerCharacter -> {
            character.add(playerCharacterMapper.toDTO(playerCharacter));
        });
        
        return character;
    }

    @Override
    public PlayerCharacterDTO getByID(Long id) {
        Optional<PlayerCharacter> temp = repository.findById(id);

        if (temp.isPresent()) {
            PlayerCharacterDTO character = playerCharacterMapper.toDTO(temp.get());
            return character;
        }
        else {
            throw new NoSuchElementException("This character wasn't found.");
        }
    }

    @Override
    public String createCharacter(PlayerCharacterDTO character) throws IllegalAccessException {
        
        if ( character.exp() < 0 ) {
            throw new IllegalArgumentException("The exp value must be a positive number.");
        }
        else if (repository.existsByName(character.characterName())) {
            throw new IllegalArgumentException("A character with this name already exist.");
        }
        
        PlayerCharacter playerCharacter = playerCharacterMapper.toEntity(character);
        String weaponName = playerCharacter.getWeapon().getName();

        if (weaponRepo.existsByName(weaponName)) {
           playerCharacter.setWeapon(weaponRepo.findByName(weaponName)); 
        }
        repository.save(playerCharacter);
        return "Character created successfully!";
    }

    @Override
    public void updatingCharacter(Long id,  PlayerCharacterDTO character) {
        Optional<PlayerCharacter> temp = repository.findById(id);
        if (temp.isPresent()) {
            PlayerCharacter characterToUpdate = temp.get();
            
            characterToUpdate.setExp(character.exp());
            characterToUpdate.setMoney(character.money());
            characterToUpdate.setItems(character.items());

            repository.save(characterToUpdate);
        }
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
