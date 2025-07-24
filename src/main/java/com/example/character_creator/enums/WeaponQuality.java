package com.example.character_creator.enums;

public enum WeaponQuality {
    IMPACTO_PROFUNDO("impacto profundo"),
    CONTUNDENTE("contundente"),
    EQUILIBRADA("equilibrada"),
    PRECISA("precisa"),
    ARTICULADA("articulada");

    private String quality;
    
    private WeaponQuality(String quality) {
        this.quality = quality;
    }
    
    public String getValue() {
        return quality;
    }

    @Override
    public String toString() {
        return quality;
    }
}
