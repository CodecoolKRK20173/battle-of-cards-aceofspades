package com.codecool.oop;

import java.util.*;

public class Dealer {

    private final List<Card> deck;

    public Dealer() {
        this.deck = getDeck();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }
}
