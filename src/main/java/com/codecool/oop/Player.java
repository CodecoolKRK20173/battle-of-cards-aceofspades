package com.codecool.oop;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    private final String name;
    private final LinkedList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getHand() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract Card drawNextCard();

    public void putCardsAtTheBottom(List<Card> cards) {
        cards.addAll(cards);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + cards +
                '}';
    }
}
