package com.example.character_creator.model;

import org.hibernate.validator.constraints.Length;

import com.example.character_creator.enums.Dice;
import com.example.character_creator.enums.WeaponQuality;
import com.example.character_creator.enums.converters.DiceConverter;
import com.example.character_creator.enums.converters.WeaponQualityConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tb_weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 14)
    private String name;
    
    @NotNull
    @Convert(converter = DiceConverter.class)
    private Dice damage;

    @NotNull
    @Convert(converter = WeaponQualityConverter.class)
    private WeaponQuality quality;

    @NotNull
    private String qualityDescription;
    
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
    public Dice getDamage() {
        return damage;
    }
    public void setDamage(Dice damage) {
        this.damage = damage;
    }
    public WeaponQuality getQuality() {
        return quality;
    }
    public void setQuality(WeaponQuality quality) {
        this.quality = quality;
    }
    public String getQualityDescription() {
        return qualityDescription;
    }
    public void setQualityDescription(String weaponQuality) {
        this.qualityDescription = switch (weaponQuality) {
            case "impacto profundo" -> "A arma causa +1 de dano.";

            case "contundente" -> "A arma não tem habilidades cortantes ou perfurantes e," +
                                  " portanto, utiliza um (1) Dado de Efeito menor que outras armas de seu tipo.";
            
            case "equilibrada" -> "A arma fornece +1 na Defesa.";
            
            case "precisa" -> "Concede +1 em Testes de ataque.";
            
            case "articulada" -> "Mesmo se uma aparada for bem-sucedida, " + 
                                 "o ataque acerta se o dado resultar" +
                                " em um número ímpar; caso em que a arma causa" +
                                " 1D6 de dano. Este dano secundário não é afetado" +
                                " por quaisquer habilidades; ele permanece 1D6 independentemente" +
                                " das outras habilidades do atacante.";
            
            case "longa" -> "concedendo ao portador um" + //
                                "Ataque Livre a cada turno contra um oponente" + //
                                "que entre na distância do combate corpo a corpo," + //
                                "desde que esse oponente não esteja armado com" + //
                                "uma arma Longa.";
            
            case "sem qualidade" -> "A arma não têm qualidades especificas.";
            default -> throw new IllegalArgumentException("Weapon quality name is invalid.");
        };
    }
}
