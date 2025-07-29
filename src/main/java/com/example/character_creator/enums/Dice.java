package com.example.character_creator.enums;

public enum Dice {
    D4("d4"), 
    D6("d6"), 
    D8("d8"), 
    D10("d10"), 
    D12("d12"), 
    D20("d20"),
    D100("d100");

    private String dice;

    private Dice(String dice) {
        this.dice = dice;
    }
    
    public String getDice() {
        return dice;
    }

    @Override
    public String toString() {
        return dice;
    }
}
