package com.codecool.oop;

import java.util.*;

public class Deck {

    List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
