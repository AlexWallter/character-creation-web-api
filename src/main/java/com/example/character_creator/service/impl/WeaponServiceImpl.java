package com.example.character_creator.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.character_creator.model.Weapon;
import com.example.character_creator.repository.WeaponRepo;
import com.example.character_creator.service.WeaponService;

@Service
public class WeaponServiceImpl implements WeaponService {
    private final WeaponRepo repository;

    public WeaponServiceImpl(WeaponRepo repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Weapon> getAllWeapons() {
        return repository.findAll();
    }

    @Override
    public Weapon getWeaponByid(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The id of the weapon is incorrect");
        }

        Optional<Weapon> temp = repository.findById(id);
        if (temp.isPresent()) {
            Weapon weapon = temp.get();
            return weapon;
        }
        else {
            return null;
        }
    }

    @Override
    public Weapon createWeapon(Weapon weapon) {
        repository.save(weapon);
        return weapon;
    }

    @Override
    public Weapon uptadeWeapon(Long id, Weapon weapon) {
        if (id == null) {
            throw new IllegalArgumentException("The id of the weapon is incorrect");
        }

        Optional<Weapon> temp = repository.findById(id);
        if (temp.isPresent()) {
            Weapon weaponToUpdate = temp.get();

            weaponToUpdate.setName(weapon.getName());
            weaponToUpdate.setDamage(weapon.getDamage());
            weaponToUpdate.setQuality(weapon.getQuality());
            repository.save(weaponToUpdate);
            return weaponToUpdate;
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteWeapon(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The id of the weapon is incorrect");
        }
        
        repository.deleteById(id);
    }
    
}
