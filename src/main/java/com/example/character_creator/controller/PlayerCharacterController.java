package com.example.character_creator.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.service.CharacterService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/character")
public class PlayerCharacterController {
        
    private final CharacterService characterService;
    public PlayerCharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
    
    @GetMapping
    public ResponseEntity<List<PlayerCharacterDTO>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllChar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerCharacterDTO> getCharacterByid(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(characterService.getByID(id));
    }

    @PostMapping
    public ResponseEntity<String> createCharacter(@RequestBody @NotNull @Valid PlayerCharacterDTO character) {
        return ResponseEntity.ok(characterService.createCharacter(character));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatingCharacter(@PathVariable @NotNull @Positive Long id,
                                                @RequestBody @NotNull @Valid PlayerCharacterDTO character) {
        characterService.updatingCharacter(id, character);
        return ResponseEntity.ok("The character was updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(characterService.deleteCharacterById(id));
    }
}
