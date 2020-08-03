package com.codecool.oop.table;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    protected final String name;
    protected final LinkedList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();
    }

    public Player(LinkedList<Card> cards) {
        this.name = "Dealer";
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card drawNextCard() {
        return cards.removeFirst();

    }

    public void putCardsAtTheBottom(List<Card> cards) {
        this.cards.addAll(cards);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
