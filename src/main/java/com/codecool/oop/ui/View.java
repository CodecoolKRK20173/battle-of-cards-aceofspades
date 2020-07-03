package com.codecool.oop.ui;
import com.codecool.oop.table.Card;
import com.codecool.oop.table.Category;
import com.codecool.oop.table.RealPlayer;
import com.codecool.oop.table.Table;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Scanner;

public class View extends AbstractView {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private final int WIDTH = 40;
    Scanner scan = new Scanner(System.in);
    private final int WIDTH = 30;

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void keyPressed(String text) {
        System.out.println(GREEN + text + RESET);
        Scanner scannerFromUser = new Scanner(System.in);
        String input = scannerFromUser.nextLine();
    }

    public void emptySpace() {
        System.out.print(" ");
    }

    public void pause(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printStart() {
        System.out.println(RED + "Welcome in BATTLE OF CARDS \n  MOVIE VILLAINS EDITION\n" + RESET);
        pause(2);
        System.out.println(RED + "      powered by \n Codecool: Ace of spades\n" + RESET);
        pause(2);
        keyPressed("Press any key to continue...");
    }

    public void printMenu() {
        String[] options = {" New game", " Help", " Exit"};
        System.out.println(RED + "------------------" + RESET);
        System.out.println(RED + "    MAIN MENU" + RESET);
        System.out.println(RED + "------------------" + RESET);
        for(int index = 0; index < options.length; index++){
            System.out.println(GREEN + "   " + (index + 1) + ". " + options[index] + RESET);
        }
        System.out.println(RED + "------------------" + RESET);
        System.out.print(GREEN + "Choose one of the options: " + RESET);
    }

    public void printRules() {
        System.out.println(BLUE + "\nSome rules\n" + RESET);
    }

    public void printInfo(String message){
        System.out.println(RED + message + RESET);
    }

    @Override
    public void print(String info) {
        System.out.println(GREEN + "\n" + info + "\n" + RESET);
        System.out.println(info);
    }

    @Override
    public void print(Card card) {
        String[] lines = card.toString().split("\n");

        System.out.println(RED + "\n" + " " + "-".repeat(WIDTH) + "-" + RESET);
        System.out.println(RED + "| BATTLE OF CARDS: MOVIE VILLAINS EDITION|" + RESET);
        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
        System.out.println(RED + "|" + " ".repeat(WIDTH) + "|" + RESET);
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
