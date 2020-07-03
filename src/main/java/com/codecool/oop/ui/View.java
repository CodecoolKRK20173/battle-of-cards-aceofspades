package com.codecool.oop.ui;
import com.codecool.oop.table.Card;
import com.codecool.oop.table.Category;
import com.codecool.oop.table.RealPlayer;
import com.codecool.oop.table.Table;

import java.util.List;
import java.util.Scanner;

public class View extends AbstractView {

    Scanner scan = new Scanner(System.in);
    private final int WIDTH = 30;

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void emptySpace() {
        System.out.print(" ");
    }

    @Override
    public void print(String info) {
        System.out.println("\n" + info);
    }

    @Override
    public void print(Card card) {
        String[] lines = card.toString().split("\n");

        System.out.println("\n" + " " + "-".repeat(WIDTH) + "-");
        System.out.println("\n" + "|" + " ".repeat(WIDTH) + "|");
            for (String line : lines) {
                System.out.println(String.format(" | %-26s | ", line));
        }
        System.out.println("\n" + "|" + " ".repeat(WIDTH) + "|");
        System.out.println("\n" + " " + "-".repeat(WIDTH) + "-");
    }


    @Override
    public void print(Card card1, Card card2) {
        String[] lines1 = card1.toString().split("\n");
        String[] lines2 = card2.toString().split("\n");

        System.out.println("\n" + " " + "-".repeat(WIDTH) + " " + " " + " " + "-".repeat(WIDTH) + " ");
        System.out.println("\n" + "|" + " ".repeat(WIDTH) + "|" + " " + "|" + " ".repeat(WIDTH) + "|");
            for (int i = 0; i < lines1.length; i++) {
                System.out.println(String.format(" | %-26s | ", lines1[i]));
                System.out.println(String.format(" | %-26s | ", lines2[i]));
            }
        System.out.println("\n" + "|" + " ".repeat(WIDTH) + "|" + " " + "|" + " ".repeat(WIDTH) + "|");
        System.out.println("\n" + " " + "-".repeat(WIDTH) + " " + " " + " " + "-".repeat(WIDTH) + " ");
    }

    public void printStatistics(List<RealPlayer> players, List<Card> pot, int roundNumber) {
        System.out.printf("Game status after round %d:\n", roundNumber);
        for (RealPlayer player : players) {
            System.out.printf("%s: %d cards\n", player.getName(), player.getCards().size());
        }
        System.out.printf("Pot: %d cards\n", pot.size());
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessage(String message, int var) {
        System.out.printf(message, var);
    }

    public void displayDrawScreen(Card card, Category category, Table table) {
        System.out.printf("Draw! %s has same %s score as %s. ", card.getName(),
                                                                category.toString().toLowerCase(),
                                                                table.getCardsThatTie(card));
        System.out.println("Cards stay on the table.");
    }

    public void displayEndOfRoundScreen(RealPlayer player, Card card, Table table, Category category) {
        System.out.printf("%s wins the round. ", player.getName());
        System.out.printf("%s beats %s in %s.\n", card.getName(), table.getOtherCardsNames(card),
                                                                  category.toString().toLowerCase());
    }

    public void displayWinScreen(RealPlayer player) {
        System.out.printf("%s wins the game!\n", player.getName());
        System.out.println("Press enter to go back to main menu");
        scan.nextLine();
    }
}
