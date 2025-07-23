package com.example.character_creator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.character_creator.model.Weapon;
import com.example.character_creator.service.WeaponService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/weapons")
public class WeaponController {

    private final WeaponService weaponService;
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Weapon>> getAllWeapon() {
        return ResponseEntity.ok(weaponService.getAllWeapons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weapon> getWeapon(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(weaponService.getWeaponByid(id));
    }

    @PostMapping
    public ResponseEntity<Weapon> createWeapon(@RequestBody @NotNull @Valid Weapon weapon) {
        return ResponseEntity.ok(weaponService.createWeapon(weapon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weapon> updateWeapon(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @NotNull @Valid Weapon weapon) {
                return ResponseEntity.ok(weaponService.uptadeWeapon(id, weapon));
            }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteWeapon(@PathVariable @NotNull @Positive Long id) {
        weaponService.deleteWeapon(id);
    }
}
