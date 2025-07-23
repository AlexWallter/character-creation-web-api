package com.example.character_creator.service;

import com.example.character_creator.model.Weapon;

public interface WeaponService {
    Iterable<Weapon> getAllWeapons();
    Weapon getWeaponByid(Long id);
    Weapon createWeapon(Weapon weapon);
    Weapon uptadeWeapon(Long id ,Weapon weapon);
    void deleteWeapon(Long id);
}
