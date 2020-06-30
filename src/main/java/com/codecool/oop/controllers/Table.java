package com.codecool.oop.controllers;

import com.codecool.oop.Card;
import com.codecool.oop.Category;
import com.codecool.oop.Dealer;
import com.codecool.oop.RealPlayer;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final List<RealPlayer> players;
    private final Dealer dealer;
    private List<Card> pool;

    public Table(List<RealPlayer> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        this.pool = new ArrayList<>();
    }

    public List<RealPlayer> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Card> getPool() {
        return pool;
    }

    public void clearPool() {
        pool.clear();
    }

    public void setCategoryForPool(Category category) {
        for (Card card : pool) {
            card.setCategoryToCompare(category);
        }
    }
}
