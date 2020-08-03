package com.codecool.oop.table;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TableTest {
    LinkedList<Card> cards = new LinkedList<>();
    Dealer dealer;
    Table table;
    RealPlayer player1 = new RealPlayer("Player1");
    RealPlayer player2 = new RealPlayer("Player2");
    List<RealPlayer> players = new ArrayList<>();

    public TableTest() {
        addCards();
        addPlayers();
        dealer = new Dealer(cards);
        table = new Table(players, dealer);
        table.getShowdown().addAll(cards);
    }

    @Test
    public void testCompareCards() {
        setCategory();
        Assert.assertEquals(cards.get(2), table.compareCards());
    }

    public void addCards() {
        cards.add(new Card("Freddy Krueger", "A Nightmare on Elm Street",7,7,5,35));
        cards.add(new Card("Jason Vorhees", "Friday the 13th",8,7,1,161));
        cards.add(new Card("Hannibal Lecter", "Silence of the Lambs",5,5,10,28));
    }

    public void addPlayers() {
        players.add(player1);
        players.add(player2);
    }

    public void setCategory() {
        table.setCategoryForPool(Category.INTELLIGENCE);
    }
}
