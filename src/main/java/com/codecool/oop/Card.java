package com.codecool.oop;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final String name;
    private final String movie;
    private final int attireScore;
    private final int weaponsScore;
    private final int intelligenceScore;
    private final int numberOfKills;
    private int categoryToCompare;

    public Card(String name, String movie, int attire, int weapons, int intelligence, int kills) {
        this.name = name;
        this.movie = movie;
        this.attireScore = attire;
        this.weaponsScore = weapons;
        this.intelligenceScore = intelligence;
        this.numberOfKills = kills;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
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

    public void setCategoryToCompare(int categoryID) {
        switch (categoryID) {
            case 1:
                categoryToCompare = attireScore;
                break;
            case 2:
                categoryToCompare = weaponsScore;
                break;
            case 3:
                categoryToCompare = intelligenceScore;
                break;
            case 4:
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
                ", movie='" + movie + '\'' +
                ", attireScore=" + attireScore +
                ", weaponsScore=" + weaponsScore +
                ", intelligenceScore=" + intelligenceScore +
                ", numberOfKills=" + numberOfKills +
                '}';
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(other.categoryToCompare, this.categoryToCompare);
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
