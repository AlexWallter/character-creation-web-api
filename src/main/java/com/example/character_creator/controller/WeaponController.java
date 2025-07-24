package com.example.character_creator.controller;

import java.util.List;

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

import com.example.character_creator.dto.WeaponDTO;
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
    public ResponseEntity<List<WeaponDTO>> getAllWeapon() {
        return ResponseEntity.ok(weaponService.getAllWeapons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeaponDTO> getWeapon(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(weaponService.getWeaponByid(id));
    }

    @PostMapping
    public ResponseEntity<WeaponDTO> createWeapon(@RequestBody @NotNull @Valid WeaponDTO weapon) {
        return ResponseEntity.ok(weaponService.createWeapon(weapon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeaponDTO> updateWeapon(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @NotNull @Valid WeaponDTO weapon) {
                return ResponseEntity.ok(weaponService.uptadeWeapon(id, weapon));
            }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteWeapon(@PathVariable @NotNull @Positive Long id) {
        weaponService.deleteWeapon(id);
    }
}
