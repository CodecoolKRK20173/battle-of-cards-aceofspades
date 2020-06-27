package com.codecool.oop;

import java.util.*;

public class Dealer {

    List<Card> deck;

    public Dealer() {
        this.deck = getCards();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<Card> getCards() {
        return deck;
    }
}
