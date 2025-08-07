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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Weapon weapon;

    @NotNull  
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Armor armor;
    
    private List<String> items;
    
    public void setHealth() {
        if(getAttributes().getStrong() >=10 ) {
            this.Health = getAttributes().getStrong();
        }
        else {
            this.Health = 10;
        }
    }

    public void setDefense() {
        this.defense = getAttributes().getQuick() + getArmor().getImpeding();
    }

    public void setCharacterCorruptionThreshold() {
        //Limiar de corrupcao arredondado para cima
        int corruptionThreshold = getAttributes().getVigilant()/2 + getAttributes().getVigilant()%2;
        this.corruption.setCorruptionThreshold(corruptionThreshold);
    }
}
