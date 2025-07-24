package com.example.character_creator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.dto.mapper.WeaponMapper;
import com.example.character_creator.model.Weapon;
import com.example.character_creator.repository.WeaponRepo;
import com.example.character_creator.service.WeaponService;

@Service
public class WeaponServiceImpl implements WeaponService {
    private final WeaponRepo repository;
    private final WeaponMapper weaponMapper;

    public WeaponServiceImpl(WeaponRepo repository, WeaponMapper weaponMapper) {
        this.repository = repository;
        this.weaponMapper = weaponMapper;
    }

    @Override
    public List<WeaponDTO> getAllWeapons() {
        List<WeaponDTO> weaponDTOs = new ArrayList<>();

        repository.findAll().forEach(record -> weaponDTOs.add(weaponMapper.toWeaponDTO(record)));
        return weaponDTOs;
    }

    @Override
    public WeaponDTO getWeaponByid(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The id of the weapon is incorrect");
        }

        Optional<Weapon> temp = repository.findById(id);
        if (temp.isPresent()) {
            Weapon weapon = temp.get();

            return weaponMapper.toWeaponDTO(weapon);
        }
        else {
            return null;
        }
    }

    @Override
    public WeaponDTO createWeapon(WeaponDTO weapon) {
        repository.save(weaponMapper.toWeaponEntity(weapon));
        return weapon;
    }

    @Override
    public WeaponDTO uptadeWeapon(Long id, WeaponDTO weapon) {
        if (id == null) {
            throw new IllegalArgumentException("The id of the weapon is incorrect");
        }

        Optional<Weapon> temp = repository.findById(id);
        if (temp.isPresent()) {
            Weapon weaponToUpdate = temp.get();

            weaponToUpdate.setName(weapon.name());
            weaponToUpdate.setDamage(weapon.damage());
            weaponToUpdate.setQuality(weaponMapper.convertQualityToValue(weapon.quality()));
            repository.save(weaponToUpdate);
            return weaponMapper.toWeaponDTO(weaponToUpdate);
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
