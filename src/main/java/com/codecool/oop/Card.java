package com.codecool.oop;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final String name;
    private final String movie;
    private final int attire;
    private final int weapons;
    private final int intelligence;
    private final int kills;
    private int categoryToCompare;
    private String playerOwner;

    public Card(String name, String movie, int attire, int weapons, int intelligence, int kills) {
        this.name = name;
        this.movie = movie;
        this.attire = attire;
        this.weapons = weapons;
        this.intelligence = intelligence;
        this.kills = kills;
    }

    public String getPlayerOwner() {return playerOwner;}

    public void setCategoryToCompare(Category category) {
        switch (category) {
            case ATTIRE:
                categoryToCompare = attire;
                break;
            case WEAPONS:
                categoryToCompare = weapons;
                break;
            case INTELLIGENCE:
                categoryToCompare = intelligence;
                break;
            case KILLS:
                categoryToCompare = kills;
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
                ", attire=" + attire +
                ", weapons=" + weapons +
                ", intelligence=" + intelligence +
                ", kills=" + kills +
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
