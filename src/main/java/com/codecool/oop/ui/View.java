package com.codecool.oop.ui;
import com.codecool.oop.table.Card;
import com.codecool.oop.table.Category;
import com.codecool.oop.table.RealPlayer;
import com.codecool.oop.table.Table;

import java.util.List;
import java.util.concurrent.TimeUnit;
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
        System.out.print(GREEN + "Choose one of the options: \n" + RESET);
    }

    public void printRules() {
        System.out.println(BLUE + "\n| BATTLE OF CARDS: MOVIE VILLAINS EDITION |\n" + RESET);
    }

    public void printInfo(String message){
        System.out.println(RED + "\n" + message + "\n" + RESET);
    }

    @Override
    public void print(String info) {
        System.out.println(GREEN + "\n" + info + "\n" + RESET);
    }

    @Override
    public void print(Card card) {
        String[] lines = card.toString().split("\n");

        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
        System.out.println(RED + "| BATTLE OF CARDS: MOVIE VILLAINS EDITION |" + RESET);
        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
        System.out.println(RED + "|" + " ".repeat(WIDTH) + " |" + RESET);
            for (String line : lines) {
                System.out.println(String.format(RED + "| " + RESET + GREEN + "%-38s" + RESET + RED + "  |" + RESET, line));
        }
        System.out.println(RED + "|" + " ".repeat(WIDTH) + " |" + RESET);
        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
    }


    public void printStatistics(List<RealPlayer> players, List<Card> pot, int roundNumber) {
        System.out.printf(GREEN + "Game status after round %d:\n" + RESET, roundNumber);
        for (RealPlayer player : players) {
            System.out.printf(GREEN + "%s: %d cards\n" + RESET, player.getName(), player.getCards().size());
        }
        System.out.printf(GREEN + "Pot: %d cards\n" + RESET, pot.size());

    }


    public void printMessage(String message, int var) {
        System.out.printf(message, var);
    }

    public void displayDrawScreen(Card card, Category category, Table table) {
        System.out.printf(GREEN + "Draw! %s has same %s score as %s. " + RESET, card.getName(),
                                                                category.toString().toLowerCase(),
                                                                table.getCardsThatTie(card));
        System.out.println(GREEN + "Cards stay on the table." + RESET);
    }

    public void displayEndOfRoundScreen(RealPlayer player, Card card, Table table, Category category) {
        System.out.printf(GREEN + "%s wins the round. " + RESET, player.getName());
        System.out.printf(GREEN + "%s beats %s in %s.\n" + RESET, card.getName(), table.getOtherCardsNames(card),
                                                                  category.toString().toLowerCase());
    }

    public void displayWinScreen(RealPlayer player) {
        System.out.printf(RED + "%s wins the game!\n" + RESET, player.getName());
        System.out.println(RED + "Press enter to go back to main menu" + RESET);
        scan.nextLine();
    }
}
