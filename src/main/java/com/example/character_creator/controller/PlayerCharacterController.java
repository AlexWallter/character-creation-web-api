package com.example.character_creator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.character_creator.model.PlayerCharacter;
import com.example.character_creator.service.CharacterService;

@RestController
@RequestMapping("/character")
public class PlayerCharacterController {
        
    private final CharacterService characterService;
    public PlayerCharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
    
    @GetMapping
    public ResponseEntity<Iterable<PlayerCharacter>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllChar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerCharacter> getCharacterByid(@PathVariable Long id) {
        return ResponseEntity.ok(characterService.getByID(id));
    }

    @PostMapping
    public ResponseEntity<String> createCharacter(@RequestBody PlayerCharacter character) {
        return ResponseEntity.ok(characterService.createCharacter(character));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatingCharacter(@PathVariable Long id, @RequestBody PlayerCharacter character) {
        characterService.updatingCharacter(id, character);
        return ResponseEntity.ok("The character was updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        return ResponseEntity.ok(characterService.deleteCharacterById(id));
    }
}
