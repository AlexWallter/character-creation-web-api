package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.model.Armor;
import com.example.character_creator.model.Attributes;
import com.example.character_creator.model.Corruption;
import com.example.character_creator.model.PlayerCharacter;

public class PlayerCharacterTest {
    PlayerCharacter playerCharacter = new PlayerCharacter();
    Attributes attributes = new Attributes();
    Corruption corruption = new Corruption();
    Armor armor = new Armor();
    
    @Test
    @DisplayName("Should get the right Health points based on Character Strong attribute")
    void testHelth() {
        attributes.setStrong(13);
        playerCharacter.setAttributes(attributes);
        playerCharacter.setHealth();
        assertEquals(13, playerCharacter.getHealth());

        attributes.setStrong(10);
        playerCharacter.setAttributes(attributes);
        playerCharacter.setHealth();
        assertEquals(10, playerCharacter.getHealth());

        attributes.setStrong(8);
        playerCharacter.setAttributes(attributes);
        playerCharacter.setHealth();
        assertEquals(10, playerCharacter.getHealth());
    }

    @Test
    @DisplayName("Should get the right Character CorruptionThreshold based on the vigilant attribute")
    void testCharacterCorruptionThreshold() {
        attributes.setVigilant(11);
        playerCharacter.setAttributes(attributes);
        playerCharacter.setCorruption(corruption);

        playerCharacter.setCharacterCorruptionThreshold();

        assertEquals(6, corruption.getCorruptionThreshold());

        attributes.setVigilant(14);
        playerCharacter.setAttributes(attributes);

        playerCharacter.setCharacterCorruptionThreshold();

        assertEquals(7, corruption.getCorruptionThreshold());
    }

    @Test
    @DisplayName("Should get the right Defence points based on Quick Attribute, ArmorWeight and ArmorQuality")
    void testDefence() {
        attributes.setQuick(15);
        armor.setArmorWeight(ArmorWeight.PESADA);
        armor.setArmorQuality(ArmorQuality.DESAJEITADA);
        armor.setImpeding();
        playerCharacter.setAttributes(attributes);
        playerCharacter.setArmor(armor);
        playerCharacter.setDefense();

        assertEquals(10, playerCharacter.getDefense());

        attributes.setQuick(10);
        playerCharacter.setAttributes(attributes);
        playerCharacter.setDefense();

        assertEquals(5, playerCharacter.getDefense());
    }
}
