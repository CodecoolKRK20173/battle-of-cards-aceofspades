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
    private String playerOwner;

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

    public String getPlayerOwner() {return playerOwner;}

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

    public void setCategoryToCompare(Category category) {
        switch (category) {
            case ATTIRE:
                categoryToCompare = attireScore;
                break;
            case WEAPONS:
                categoryToCompare = weaponsScore;
                break;
            case INTELLIGENCE:
                categoryToCompare = intelligenceScore;
                break;
            case KILLS:
                categoryToCompare = numberOfKills;
                break;
            default:
                System.out.println("There is no such category");
        }
    }

    public void setPlayerOwner(String playerOwner) {
        this.playerOwner = playerOwner;
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
                ", playerOwner='" + playerOwner + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.categoryToCompare, other.categoryToCompare);
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
