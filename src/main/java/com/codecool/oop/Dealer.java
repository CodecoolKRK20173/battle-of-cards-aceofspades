package com.codecool.oop;

import java.util.*;

public class Dealer extends Player {

    public Dealer(LinkedList<Card> cards) {
        super(cards);
    }

    public void shuffle() {
        Collections.shuffle(getCards());
    }

    public void dealCards(List<RealPlayer> players) {
        int iterations = getCards().size() / players.size();
        for (int i = 0; i < iterations; i++) {
            for (RealPlayer player : players) {
                Card drawnCard = drawNextCard();
                player.addCard(drawnCard);
                drawnCard.setPlayerOwner(player.getName());
            }
        }
    }
}
