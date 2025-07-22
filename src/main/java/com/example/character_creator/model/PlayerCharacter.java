package com.example.character_creator.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.example.character_creator.enums.Race;
import com.example.character_creator.enums.converters.RaceConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
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
    @Convert(converter = RaceConverter.class)
    private Race race;

    @NotNull 
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Attributes attributes;

    @NotNull
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Corruption corruption;

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
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
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

    public Corruption getCorruption() {
        return corruption;
    }
    
    public void setCorruption(Corruption corruption) {
        this.corruption = corruption;
    }

    public void setCharacterCorruptionThreshold() {
        //Limiar de corrupcao arredondado para cima
        int corruptionThreshold = getAttributes().getVigilant()/2 + getAttributes().getVigilant()%2;
        this.corruption.setCorruptionThreshold(corruptionThreshold);
    }
}
