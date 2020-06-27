package com.codecool.oop;


import java.util.Objects;

public class Card implements Comparable<Card> {

    private final String name;
    private final int attireScore;
    private final int weaponsScore;
    private final int intelligenceScore;
    private final int numberOfKills;
    private int categoryToCompare;

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

    public int getNumberOfKills() {
        return numberOfKills;
    }

    public int getCategoryToCompare() {
        return categoryToCompare;
    }

    public void setCategoryToCompare(String category) {
        switch (category) {
            case "attire":
                categoryToCompare = attireScore;
                break;
            case "weapons":
                categoryToCompare = weaponsScore;
                break;
            case "intelligence":
                categoryToCompare = intelligenceScore;
                break;
            case "kills":
                categoryToCompare = numberOfKills;
                break;
            default:
                System.out.println("There is no such category");
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", attireScore=" + attireScore +
                ", weaponsScore=" + weaponsScore +
                ", intelligenceScore=" + intelligenceScore +
                ", numberOfKills=" + numberOfKills +
                ", categoryToCompare=" + categoryToCompare +
                '}';
    }

    @Override
    public int compareTo(Card other) {
        return this.categoryToCompare - other.categoryToCompare;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return this.categoryToCompare == other.categoryToCompare;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryToCompare);
    }
}
