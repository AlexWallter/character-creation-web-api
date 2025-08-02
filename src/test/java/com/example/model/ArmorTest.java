package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.character_creator.enums.ArmorQuality;
import com.example.character_creator.enums.ArmorWeight;
import com.example.character_creator.model.Armor;

public class ArmorTest {
    
    @Test
    @DisplayName("Should get the right impeding based on the ArmorWeight and ArmorQuality")
    void testEmpeding() {

        Armor armor = new Armor();
        ArmorWeight[] arrayOfWeightsName = ArmorWeight.values();
        int[] empedingValues = new int[6];
        
        for (int i = 0; i < arrayOfWeightsName.length; i++) {
            ArmorWeight armorWeight = arrayOfWeightsName[i];

            armor.setArmorWeight(armorWeight);
            armor.setArmorQuality(ArmorQuality.FLEXIVEL);
            armor.setImpeding();
            empedingValues[i] = armor.getimpeding();

            armor.setArmorQuality(ArmorQuality.DESAJEITADA);
            armor.setImpeding();
            empedingValues[i+3] = armor.getimpeding();
        }

        Assertions.assertAll(
                ()->assertEquals(-1, empedingValues[0]),
                ()->assertEquals(-2, empedingValues[1]),
                ()->assertEquals(-3, empedingValues[2]),
                ()->assertEquals(-3, empedingValues[3]),
                ()->assertEquals(-4, empedingValues[4]),
                ()->assertEquals(-5, empedingValues[5])
        );
    }
}
