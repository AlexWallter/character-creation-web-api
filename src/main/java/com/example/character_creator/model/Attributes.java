package com.example.character_creator.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    private int accurate;
    private int cunning;
    private int discreet;
    private int persuasive;
    private int quick;
    private int resolute;
    private int strong;
    private int vigilant;

    public int getAccurate() {
        return accurate;
    }
    public void setAccurate(int accurate) {
        this.accurate = accurate;
    }
    public int getCunning() {
        return cunning;
    }
    public void setCunning(int cunning) {
        this.cunning = cunning;
    }
    public int getDiscreet() {
        return discreet;
    }
    public void setDiscreet(int discreet) {
        this.discreet = discreet;
    }
    public int getPersuasive() {
        return persuasive;
    }
    public void setPersuasive(int persuasive) {
        this.persuasive = persuasive;
    }
    public int getQuick() {
        return quick;
    }
    public void setQuick(int quick) {
        this.quick = quick;
    }
    public int getResolute() {
        return resolute;
    }
    public void setResolute(int resolute) {
        this.resolute = resolute;
    }
    public int getStrong() {
        return strong;
    }
    public void setStrong(int strong) {
        this.strong = strong;
    }
    public int getVigilant() {
        return vigilant;
    }
    public void setVigilant(int vigilant) {
        this.vigilant = vigilant;
    }
    public boolean validatingAttributes() {
        int[] allAttributes = {getAccurate(), 
                                getCunning(), 
                                getDiscreet(), 
                                getPersuasive(), 
                                getQuick(),
                                getResolute(), 
                                getStrong(), 
                                getVigilant()};

        int[] test =  Arrays.stream(allAttributes).filter(n -> n>=0).toArray();
        boolean isValid = (test.length == 8);
        
        return isValid;
    }
}
