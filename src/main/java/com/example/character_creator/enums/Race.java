package com.example.character_creator.enums;

public enum Race {
    HUMANO("humano"), CAMBIANTE("cambiante"),
    GOBLIN("goblin"), OGRO("ogro");
    
    private String race;    
    
    private Race(String race) {
        this.race = race;
    }
    
    public String getValue() {
        return race;
    }

    @Override
    public String toString() {
        return race;
    }
}
