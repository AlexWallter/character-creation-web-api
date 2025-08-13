package com.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.character_creator.dto.ArmorDTO;
import com.example.character_creator.dto.PlayerCharacterDTO;
import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.dto.mapper.PlayerCharacterMapper;
import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.Race;
import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.model.Armor;
import com.example.character_creator.model.Attributes;
import com.example.character_creator.model.Corruption;
import com.example.character_creator.model.PlayerCharacter;
import com.example.character_creator.model.Weapon;
import com.example.character_creator.repository.PlayerCharacterRepo;
import com.example.character_creator.repository.WeaponRepo;
import com.example.character_creator.service.impl.CharacterServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceImplTest {
    @Mock
    private PlayerCharacterRepo repository;

    @Mock 
    private WeaponRepo weaponRepo;

    @InjectMocks
    private CharacterServiceImpl characterService;

    private Attributes attributes = Attributes.builder()
                                                .id(1L)
                                                .accurate(10)
                                                .cunning(10)
                                                .discreet(10)
                                                .persuasive(10)
                                                .quick(10)
                                                .resolute(10)
                                                .strong(10)
                                                .vigilant(10)
                                                .build();
                                                    
    private Corruption corruption = Corruption.builder()
                                                .id(1L)
                                                .permanentCorrution(2)
                                                .temporaryCorruption(3)
                                                .totalCorruption(5)
                                                .build();

    private WeaponDTO weaponDTO1 = new WeaponDTO(1L,
                                                 "exemple", 
                                                 "d6", 
                                                 "sem qualidade", 
                                                 "A arma não têm qualidades especificas.");

    private ArmorDTO armorDTO = new ArmorDTO(1L, 
                                            "name",
                                            "pesada",
                                            "desajeitada",
                                            "d6", 
                                            -5);

    private PlayerCharacterDTO characterDTO1 = new PlayerCharacterDTO(1L, 
                                                                    "exemple",
                                                                    "humano",
                                                                    attributes,
                                                                    corruption,
                                                                        10,
                                                                        5,
                                                                        0,
                                                                        0,
                                                                            weaponDTO1,
                                                                            armorDTO,
                                                                            null);

    PlayerCharacter playerCharacter = new PlayerCharacter();

    @BeforeEach
    void setup() {
        Weapon weapon1 = Weapon.builder()
                                .id(1L)
                                .name("exemple")
                                .damage(Dice.D6)
                                .quality(WeaponQuality.NO_QUALITY)
                                .qualityDescription("A arma não têm qualidades especificas.")
                                .build();

        Armor armor = Armor.builder()
                            .id(1L)
                            .name("name")
                            .protection(Dice.D6)
                            .armorWeight(ArmorWeight.PESADA)
                            .armorQuality(ArmorQuality.DESAJEITADA)
                            .impeding(-5)
                            .build();

        playerCharacter = PlayerCharacter.builder()
                                                    .id(1L)
                                                    .name("exemple")
                                                    .race(Race.HUMANO)
                                                    .attributes(attributes)
                                                    .corruption(corruption)
                                                    .Health(10)
                                                    .defense(5)
                                                    .exp(0)
                                                    .money(0)
                                                    .weapon(weapon1)
                                                    .armor(armor)
                                                    .build();
    }

    @Test
    void testAllChar() {
        List<PlayerCharacter> characters = List.of(playerCharacter);
        List<PlayerCharacterDTO> expectedCharacterDTOs = List.of(characterDTO1);

        when(repository.findAll()).thenReturn(characters);

        List<PlayerCharacterDTO> actualCharacterDTOs = characterService.getAllChar();

        assertEquals(expectedCharacterDTOs, actualCharacterDTOs);
    }

    @Test
    void testGetById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(playerCharacter));

        PlayerCharacterDTO actualCharacterDTO = characterService.getByID(1L);

        assertEquals(characterDTO1, actualCharacterDTO);
    }

    @Test
    void testCreateCharacter() throws IllegalAccessException {
        when(repository.existsByName(anyString())).thenReturn(false);
        when(weaponRepo.existsByName(anyString())).thenReturn(false);

        when(repository.save(PlayerCharacterMapper.toEntity(characterDTO1))).thenReturn(null);

        characterService.createCharacter(characterDTO1);
    }

    @Test
    void testUpdatingCharacter() {

        when(repository.findById(anyLong())).thenReturn(Optional.of(playerCharacter));
        when(repository.save(playerCharacter)).thenReturn(null);

        characterService.updatingCharacter(1L, characterDTO1);

        verify(repository).save(playerCharacter);
    }

    @Test
    void testDeleteCharacter() {

        when(repository.existsById(anyLong())).thenReturn(true);

        doNothing().when(repository).deleteById(anyLong());

       characterService.deleteCharacterById(1L);

       verify(repository).deleteById(1L);
    }
}
