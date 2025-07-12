package com.example.character_creator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.character_creator.model.PlayerCharacter;

@Repository
public interface PlayerCharacterRepo extends CrudRepository<PlayerCharacter, Long>{
    boolean existsByName(String name);
}
