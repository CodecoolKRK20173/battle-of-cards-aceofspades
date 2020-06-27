package com.codecool.oop;

import java.util.*;

public class Dealer {

    List<Card> deck;

    public Dealer() {
        this.cards = getCards();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
