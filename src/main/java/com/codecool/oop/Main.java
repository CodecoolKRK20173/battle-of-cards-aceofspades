package com.codecool.oop;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException{
        CSVCardsDAO csvcardsDAO = new CSVCardsDAO();
        Dealer dealer = new Dealer(csvcardsDAO.getAll());
        List<RealPlayer> players = new Setup().getPlayers();
        Table table = new Table(players, dealer);
        dealer.shuffle();
        dealer.dealCards(players);
        System.out.println(players.get(0).getHand());


//        System.out.println(dealer.getDeck());
//        dealer.shuffle();
//        System.out.println(dealer.getDeck());
//        System.out.println(table.getPlayers().toString());

    }
}
