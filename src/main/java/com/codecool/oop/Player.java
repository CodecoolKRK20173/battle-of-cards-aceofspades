package com.codecool.oop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    String name;
    private LinkedList<Card> hand;

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public abstract String chooseCategory();

    public Card drawNextCard() {
        return hand.removeFirst();
    }

    public void putCardsAtTheBottom(Card... cards) {
        hand.addAll(Arrays.asList(cards));
    }

}
