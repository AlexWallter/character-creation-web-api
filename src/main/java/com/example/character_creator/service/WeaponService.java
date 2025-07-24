package com.example.character_creator.service;

import java.util.List;

import com.example.character_creator.dto.WeaponDTO;

public interface WeaponService {
    List<WeaponDTO> getAllWeapons();
    WeaponDTO getWeaponByid(Long id);
    WeaponDTO createWeapon(WeaponDTO weapon);
    WeaponDTO uptadeWeapon(Long id ,WeaponDTO weapon);
    void deleteWeapon(Long id);
}
