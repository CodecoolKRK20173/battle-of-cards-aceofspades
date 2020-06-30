package com.codecool.oop;

import java.util.*;

public class Dealer extends Player {

    private final LinkedList<Card> cards;

    public Dealer(String name, LinkedList<Card> cards) {
        super(name);
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getDeck() {
        return cards;
    }

    public void dealCards(List<RealPlayer> players) {
        int iterations = cards.size() / players.size();
        for (int i = 0; i < iterations; i++) {
            for (RealPlayer player : players) {
                Card drawnCard = this.drawNextCard();
                player.addCard(drawnCard);
                drawnCard.setPlayerOwner(player.getName());
            }
        }
    }

    @Override
    public Card drawNextCard() {
        return cards.removeFirst();
    }
}
