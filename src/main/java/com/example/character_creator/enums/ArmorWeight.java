package com.example.character_creator.enums;

public enum ArmorWeight {
    LEVE("leve"),
    MEDIA("media"), 
    PESADA("pesada");
    
    private String weight;
    
    private ArmorWeight(String weight) {
        this.weight = weight;
    }
    
    public String getWeight() {
        return weight;
    }    
    
    @Override
    public String toString() {
        return weight;
    }
    
}
