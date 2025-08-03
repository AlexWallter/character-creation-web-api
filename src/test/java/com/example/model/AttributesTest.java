package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.character_creator.model.Attributes;

public class AttributesTest {
    Attributes attributes = new Attributes();

    @Test
    void testValidatingAttributes() {
        attributes.setAccurate(5);
        attributes.setCunning(5);
        attributes.setDiscreet(5);
        attributes.setPersuasive(5);
        attributes.setQuick(5);
        attributes.setResolute(5);
        attributes.setStrong(5);
        attributes.setVigilant(5);

        assertEquals(false, attributes.validatingAttributes());

        attributes.setAccurate(10);
        attributes.setCunning(10);
        attributes.setDiscreet(10);
        attributes.setPersuasive(10);
        attributes.setQuick(10);
        attributes.setResolute(10);
        attributes.setStrong(10);
        attributes.setVigilant(10);

        assertEquals(true, attributes.validatingAttributes());

        attributes.setAccurate(4);
        attributes.setCunning(10);
        attributes.setDiscreet(10);
        attributes.setPersuasive(10);
        attributes.setQuick(10);
        attributes.setResolute(10);
        attributes.setStrong(10);
        attributes.setVigilant(10);

        assertEquals(false, attributes.validatingAttributes());   
    }
}
