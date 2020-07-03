package com.codecool.oop.controllers;

import com.codecool.oop.dao.CSVCardsDAO;
import com.codecool.oop.dao.CardsDAO;
import com.codecool.oop.table.*;
import com.codecool.oop.ui.Input;
import com.codecool.oop.ui.View;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    Scanner scan = new Scanner(System.in);
    View view = new View();
    Random random = new Random();

    public void run() throws IOException, URISyntaxException {
        List<RealPlayer> players = new Setup().getPlayers();
        view.clearScreen();
        CardsDAO<Card> cardsDAO = new CSVCardsDAO();
        Dealer dealer = new Dealer(cardsDAO.getAll());
        Table table = new Table(players, dealer);
        dealer.shuffle();
        dealer.dealCards(players);
        table.setActualDeckSize();

        int roundNumber = 1;
        RealPlayer startingPlayer = players.get(random.nextInt(players.size()));
        RealPlayer winningPlayer;

        while (!table.checkForWinner()) {

            view.print(startingPlayer.getName() + ", press enter to start new round");
            scan.nextLine();
            view.clearScreen();
            view.print("Your card is: ");
            Card drawnCard = startingPlayer.drawNextCard();
            view.print(drawnCard);
            table.getShowdown().add(drawnCard);
            table.takeCardsFromOtherPlayers(startingPlayer);
            Category category = startingPlayer.chooseCategory();
            table.setCategoryForPool(category);
            Card winningCard = table.compareCards();
            if (table.checkForTie(winningCard)) {
                view.displayDrawScreen(winningCard, category, table);
                table.getPot().addAll(table.getShowdown());
                table.getShowdown().clear();
                view.printStatistics(players, table.getPot(), roundNumber);
                roundNumber++;
            } else {
                winningPlayer = table.getPlayerByName(winningCard.getPlayerOwner());
                winningPlayer.putCardsAtTheBottom(table.getShowdown());
                winningPlayer.putCardsAtTheBottom(table.getPot());
                if (table.checkForWinner()) {
                    view.displayWinScreen(startingPlayer);
                } else {
                    view.displayEndOfRoundScreen(winningPlayer, winningCard, table, category);
                    table.setNewPlayerOwner(winningPlayer.getName());
                    startingPlayer = winningPlayer;
                    table.getShowdown().clear();
                    table.getPot().clear();
                    view.printStatistics(players, table.getPot(), roundNumber);
                    roundNumber++;
                }
            }
        }
    }
}
