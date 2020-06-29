package com.codecool.oop;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException{
        Setup setup = new Setup();
        Dealer dealer = new Dealer();
        Table table = new Table(setup.getPlayers(), dealer);
        CSVCardsDAO csvcardsDAO = new CSVCardsDAO();
        System.out.println(csvcardsDAO.getAll());
        System.out.println(table.getPlayers().toString());

    }
}
