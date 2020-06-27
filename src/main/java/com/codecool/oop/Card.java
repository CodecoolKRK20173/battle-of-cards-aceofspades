package com.codecool.oop;

public class Card {

    private final String name;
    private final int attireScore;
    private final int weaponsScore;
    private final int intelligenceScore;
    private final int numberOfKills;

    public static void main(String[] args) {
        Card card = new Card("Hannibal Lecter", 6, 5, 10, 28);
        System.out.println(card);
    }

    public Card(String name, int attire, int weapons, int intelligence, int kills) {
        this.name = name;
        this.attireScore = attire;
        this.weaponsScore = weapons;
        this.intelligenceScore = intelligence;
        this.numberOfKills = kills;
    }

    public String getName() {
        return name;
    }

    public int getAttireValue() {
        return attireScore;
    }

    public int getWeaponsValue() {
        return weaponsScore;
    }

    public int getIntelligenceValue() {
        return intelligenceScore;
    }

    public int getKillsValue() {
        return numberOfKills;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", attireScore=" + attireScore +
                ", weaponsScore=" + weaponsScore +
                ", intelligenceScore=" + intelligenceScore +
                ", numberOfKills=" + numberOfKills +
                '}';
    }
}
