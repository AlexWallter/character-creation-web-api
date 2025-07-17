package com.example.character_creator.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity(name = "tb_characters")
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 14)
    private String name;

    @NotNull
    @NotBlank
    private String race;

    @NotNull 
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Attributes attributes;

    private int Health;
    private int defense;

    @NotNull
    @PositiveOrZero
    private int exp;

    @NotNull
    @PositiveOrZero
    private int money;

    @NotNull  
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Weapon weapon;

    @NotNull  
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
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
    public void setHealth() {
        if(getAttributes().getStrong() >=10 ) {
            this.Health = getAttributes().getStrong();
        }
        else {
            this.Health = 10;
        }
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense() {
        this.defense = getAttributes().getQuick() - getArmor().getimpeding();
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
