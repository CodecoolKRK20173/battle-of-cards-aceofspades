package com.codecool.oop;

import com.codecool.oop.dao.CSVCardsDAO;

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

    }
}
