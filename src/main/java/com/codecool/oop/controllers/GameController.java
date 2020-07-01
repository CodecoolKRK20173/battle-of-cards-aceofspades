package com.codecool.oop.controllers;

import com.codecool.oop.dao.CSVCardsDAO;
import com.codecool.oop.dao.CardsDAO;
import com.codecool.oop.table.*;
import com.codecool.oop.ui.Input;
import com.codecool.oop.ui.View;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    Scanner scan = new Scanner(System.in);
    View view = new View();
    Input playerInput = new Input();
    Random random = new Random();

    public void run() throws IOException, URISyntaxException {
        List<RealPlayer> players = new Setup().getPlayers();
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
            System.out.println(startingPlayer.getName() + ", press enter to start new round");
            scan.nextLine();
            System.out.print("Your card is: ");
            Card drawnCard = startingPlayer.drawNextCard();
            System.out.println(drawnCard);
            table.getShowdown().add(drawnCard);
            table.takeCardsFromOtherPlayers(startingPlayer);
            Category category = startingPlayer.chooseCategory();
            table.setCategoryForPool(category);
            Card winningCard = table.compareCards();
            if (table.checkForTie(winningCard)) {
                System.out.print("We have a draw! ");
                System.out.printf("%s has same %s score as %s. ", winningCard.getName(),
                                                                  category.toString().toLowerCase(),
                                                                  table.getCardsThatTie(winningCard));
                System.out.println("Cards stay on the table.");
                table.getPot().addAll(table.getShowdown());
                table.getPot().sort(Collections.reverseOrder());
                table.getShowdown().clear();
                view.printStatistics(players, table.getPot(), roundNumber);
            } else {
                winningPlayer = table.getPlayerByName(winningCard.getPlayerOwner());
                System.out.printf("%s wins the round. ", winningPlayer.getName());
                System.out.printf("%s beats %s in %s.\n", winningCard.getName(),
                                                          table.getOtherCardsNames(winningCard),
                                                          category.toString().toLowerCase());
                table.getShowdown().sort(Collections.reverseOrder());
                winningPlayer.putCardsAtTheBottom(table.getShowdown());
                winningPlayer.putCardsAtTheBottom(table.getPot());
                table.setNewPlayerOwner(winningPlayer.getName());
                startingPlayer = winningPlayer;
                table.getShowdown().clear();
                table.getPot().clear();
                view.printStatistics(players, table.getPot(), roundNumber);
                roundNumber++;
            }
        }

        System.out.println(startingPlayer.getName() + " wins the game");
        System.out.println("Press enter to go back to main menu");
        scan.nextLine();
    }
}
