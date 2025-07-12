package com.example.character_creator.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_characters")
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    private String name;
    private String race;

    @OneToOne
    private Attributes attributes;

    private int Health;
    private int defense;
    private int exp;
    private int money;

    @OneToOne
    private Weapon weapon;

    @OneToOne
    private Armor armor;
    
    private List<String> items;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public Attributes getAttributes() {
        return attributes;
    }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    public int getHealth() {
        return Health;
    }
    public void setHealth(int health) {
        Health = health;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }
}
