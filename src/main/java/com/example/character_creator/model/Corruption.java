package com.example.character_creator.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_corruption")
public class Corruption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalCorruption;

    private int temporaryCorruption;
    
    private int permanentCorrution;

    @NotNull
    private int corruptionThreshold;

    public void setTotalCorruption() {
        this.totalCorruption = getPermanentCorrution() + getTemporaryCorruption();
    }
}
