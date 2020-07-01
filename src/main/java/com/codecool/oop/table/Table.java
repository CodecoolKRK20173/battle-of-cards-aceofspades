package com.codecool.oop.table;

import java.util.*;

public class Table {

    private final List<RealPlayer> players;
    private final Dealer dealer;
    private final List<Card> showdown;
    private final List<Card> pot;
    private int actualDeckSize;

    public Table(List<RealPlayer> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        this.showdown = new ArrayList<>();
        this.pot = new ArrayList<>();
    }

    public List<Card> getShowdown() {
        return showdown;
    }

    public List<Card> getPot() {
        return pot;
    }

    public void setActualDeckSize() {
        actualDeckSize = dealer.getActualDeckSize();
    }

    public void setCategoryForPool(Category category) {
        for (Card card : showdown) {
            card.setCategoryToCompare(category);
        }
    }

    public void takeCardsFromOtherPlayers(RealPlayer startingPlayer) {
        for (RealPlayer player : players) {
            if (!player.getName().equals(startingPlayer.getName())) {
                showdown.add(player.drawNextCard());
            }
        }
    }

    public boolean checkForWinner() {
        for (RealPlayer player : players) {
            if (player.getCards().size() == actualDeckSize) {
                return true;
            }
        }
        return false;
    }

    public Card compareCards() {
        showdown.sort(Collections.reverseOrder());
        return showdown.get(0);
    }

    public RealPlayer getPlayerByName(String name) {
        for (RealPlayer player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void setNewPlayerOwner(String name) {
        for (Card card : showdown) {
            card.setPlayerOwner(name);
        }
        for (Card card : pot) {
            card.setPlayerOwner(name);
        }
    }

    public boolean checkForTie(Card winningCard) {
        for (Card card : showdown) {
            if (card != winningCard && card.equals(winningCard)) {
                return true;
            }
        }
        return false;
    }

    public String getOtherCardsNames(Card winningCard) {
        StringBuilder sb = new StringBuilder();
        for (Card card : showdown) {
            if (card != winningCard) {
                sb.append(card.getName()).append(", ");
            }
        }
        return sb.toString().replaceAll(", $", "");
    }

    public String getCardsThatTie(Card winningCard) {
        StringBuilder sb = new StringBuilder();
        for (Card card : showdown) {
            if (card != winningCard && card.equals(winningCard)) {
                sb.append(card.getName()).append(", ");
            }
        }
        return sb.toString().replaceAll(", $", "");
    }
}
