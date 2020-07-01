package com.codecool.oop.table;

import java.util.*;

public class Dealer extends Player {

    int deckSize;

    public Dealer(LinkedList<Card> cards) {
        super(cards);
        deckSize = cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void dealCards(List<RealPlayer> players) {
        int iterations = cards.size() / players.size();
        for (int i = 0; i < iterations; i++) {
            for (RealPlayer player : players) {
                Card drawnCard = drawNextCard();
                player.addCard(drawnCard);
                drawnCard.setPlayerOwner(player.name);
            }
        }
    }

    public int getActualDeckSize() {
        return deckSize - cards.size();
    }
}
