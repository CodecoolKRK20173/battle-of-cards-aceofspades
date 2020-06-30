package com.codecool.oop;

import java.util.*;

public class Dealer extends Player {

    public Dealer(LinkedList<Card> cards) {
        super(cards);
    }

    public void shuffle() {
        Collections.shuffle(getHand());
    }

    public List<Card> getDeck() {
        return getHand();
    }

    public void dealCards(List<RealPlayer> players) {
        int iterations = getHand().size() / players.size();
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
        return getHand().removeFirst();
    }
}
