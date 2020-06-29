package com.codecool.oop;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException{
        CSVCardsDAO csvcardsDAO = new CSVCardsDAO();
        Setup setup = new Setup();
        Dealer dealer = new Dealer(csvcardsDAO.getAll());
        Table table = new Table(setup.getPlayers(), dealer);

//        System.out.println(dealer.getDeck());
//        dealer.shuffle();
//        System.out.println(dealer.getDeck());
        System.out.println(table.getPlayers().toString());

    }
}
