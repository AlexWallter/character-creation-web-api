package com.example.character_creator.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity(name = "tb_attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int accurate;
    
    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int cunning;

    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int discreet;

    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int persuasive;

    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int quick;
    
    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int resolute;
    
    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
    private int strong;
    
    @NotNull
    @Positive
    @Min(value = 5, message = "The atributte cannot have a value less than 5")
    @Max(value = 15, message = "The atributte cannot have a value greater than 15")
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

        int[] attributesGreatersThanFive =  Arrays.stream(allAttributes).filter(n -> n>=5).toArray();
        
        int sumOfAttributes = Arrays.stream(allAttributes).reduce(0, (a, b)-> a+b);
        
        boolean isValid = (attributesGreatersThanFive.length == 8) && (sumOfAttributes >= 80);
        return isValid;
    }
}
