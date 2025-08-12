package com.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
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

import com.example.character_creator.dto.WeaponDTO;
import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.model.Weapon;
import com.example.character_creator.repository.WeaponRepo;
import com.example.character_creator.service.impl.WeaponServiceImpl;

@ExtendWith(MockitoExtension.class)
public class WeaponServiceImplTest {
    @Mock
    private WeaponRepo repository;

    @InjectMocks 
    private WeaponServiceImpl weaponServiceImpl;

    private Weapon weapon1;
    private Weapon weapon2;

    private WeaponDTO weaponDTO1 = new WeaponDTO(1L,
                                                 "exemple", 
                                                 "d6", 
                                                 "sem qualidade", 
                                                 "A arma não têm qualidades especificas.");

    private WeaponDTO weaponDTO2 = new WeaponDTO(2L, 
                                                "other exemple", 
                                                "d8", 
                                                "precisa", 
                                                "Concede +1 em Testes de ataque.");

    private WeaponDTO updatedWeaponDTO = new WeaponDTO(1L, 
                                                "other exemple", 
                                                "d8", 
                                                "precisa", 
                                                "Concede +1 em Testes de ataque.");
    
    @BeforeEach
    void setup() {
        weapon1 = Weapon.builder()
        .id(1L)
        .name("exemple")
        .damage(Dice.D6)
        .quality(WeaponQuality.NO_QUALITY)
        .build();
        
        weapon1.setQualityDescription("sem qualidade");

        weapon2 = Weapon.builder()
        .id(2L)
        .name("other exemple")
        .damage(Dice.D8)
        .quality(WeaponQuality.PRECISA)
        .build();

        weapon2.setQualityDescription("precisa");
    }

        @Test
        void testGetAllWeapon() {
        List<Weapon> allWeapons = List.of(weapon1, weapon2);
        List<WeaponDTO> ExpectedWeaponDTOs = List.of(weaponDTO1, weaponDTO2);

        when(repository.findAll()).thenReturn(allWeapons);

        List<WeaponDTO> actualWeaponDTOs = weaponServiceImpl.getAllWeapons();

        assertEquals(ExpectedWeaponDTOs, actualWeaponDTOs);

        verify(repository).findAll();
    }

    @Test
    void testGetWeaponById() {

        when(repository.findById(anyLong())).thenReturn(Optional.of(weapon1));

        WeaponDTO actualWeaponDTO = weaponServiceImpl.getWeaponByid(1L);

        assertEquals(weaponDTO1, actualWeaponDTO);
    }

    @Test
    void testUptadeWeapon() {
        
        when(repository.findById(anyLong())).thenReturn(Optional.of(weapon1));
        when(repository.save(weapon1)).thenReturn(null);

        WeaponDTO actualWeaponDTO = weaponServiceImpl.uptadeWeapon(1L, weaponDTO2);

        assertEquals(updatedWeaponDTO, actualWeaponDTO);
    }
}
