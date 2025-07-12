package com.example.character_creator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_armor")
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    private String name;
    private int protection;
    private int impeding;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProtection() {
        return protection;
    }
    public void setProtection(int protection) {
        this.protection = protection;
    }
    public int getimpeding() {
        return impeding;
    }
    public void setimpeding(int impeding) {
        this.impeding = impeding;
    }    
}
