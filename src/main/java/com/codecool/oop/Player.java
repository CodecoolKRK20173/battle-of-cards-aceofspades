package com.codecool.oop;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    private final String name;
    private final LinkedList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public abstract Card drawNextCard();

    public void putCardsAtTheBottom(List<Card> cards) {
        hand.addAll(cards);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
