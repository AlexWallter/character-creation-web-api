package com.example.character_creator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.character_creator.model.Weapon;

@Repository
public interface WeaponRepo extends CrudRepository<Weapon, Long>{
    boolean existsByName(String name);
    Weapon findByName(String name);
}
