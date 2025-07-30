package com.example.character_creator.enums;

public enum ArmorQuality {
    DESAJEITADA("desajeitada"), 
    FLEXIVEL("flexivel");
    
    private String armorQuality;
    
    private ArmorQuality(String armorQuality) {
        this.armorQuality = armorQuality;
    }
    
    public String getQuality() {
        return armorQuality;
    }
    
    @Override
    public String toString() {
        return armorQuality;
    }
}
