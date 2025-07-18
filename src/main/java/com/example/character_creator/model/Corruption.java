package com.example.character_creator.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

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

    public int getCorruptionThreshold() {
        return corruptionThreshold;
    }

    public void setCorruptionThreshold(int corruptionThreshold) {
        this.corruptionThreshold = corruptionThreshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalCorruption() {
        return totalCorruption;
    }

    public void setTotalCorruption() {
        this.totalCorruption = getPermanentCorrution() + getTemporaryCorruption();
    }

    public int getTemporaryCorruption() {
        return temporaryCorruption;
    }

    public void setTemporaryCorruption(int temporaryCorruption) {
        this.temporaryCorruption = temporaryCorruption;
    }

    public int getPermanentCorrution() {
        return permanentCorrution;
    }

    public void setPermanentCorrution(int permanentCorrution) {
        this.permanentCorrution = permanentCorrution;
    }
}
