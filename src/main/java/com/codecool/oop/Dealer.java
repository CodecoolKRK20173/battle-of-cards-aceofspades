package com.codecool.oop;

import java.util.*;

public class Dealer extends Player {

    private final LinkedList<Card> deck;

    public Dealer(String name, LinkedList<Card> deck) {
        super(name);
        this.deck = deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void dealCards(List<RealPlayer> players) {
        int iterations = deck.size() / players.size();
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
        return deck.removeFirst();
    }
}
