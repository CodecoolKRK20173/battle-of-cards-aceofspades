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
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String ITALIC = "\u001B[3m";
    public static final String GREEN = "\u001B[32m";

    private final int WIDTH = 50;
    Scanner scan = new Scanner(System.in);


    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void keyPressed(String text) {
        System.out.println(BLUE + text + RESET);
        Scanner scannerFromUser = new Scanner(System.in);
        String input = scannerFromUser.nextLine();
    }

    public void emptySpace() {
        System.out.print("\n");
    }

    public void pause(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printStart() {
        clearScreen();
        System.out.println(RED + "Welcome in BATTLE OF CARDS \n  MOVIE VILLAINS EDITION\n" + RESET);
        pause(2);
        System.out.println(RED + "      powered by \n Codecool: Ace of spades\n" + RESET);
        pause(2);
        keyPressed("Press any key to continue...");
    }

    public void printMenu() {
        String[] options = {" New game", " Help", " Exit"};
        System.out.println(RED + " ------------------" + RESET);
        System.out.println(RED + "|     MAIN MENU    |" + RESET);
        System.out.println(RED + " ------------------" + RESET);
        for(int index = 0; index < options.length; index++){
            System.out.println(RED + "   " + (index + 1) + ". " + RESET + BLUE + options[index] + RESET + "\n");
        }
        System.out.print(BLUE + "Choose one of the options: \n" + RESET);
    }

    public void printRules() {
        clearScreen();
        System.out.println(BLUE + "| BATTLE OF CARDS: MOVIE VILLAINS EDITION |\n");
        System.out.println("Have you ever wondered who would win in the clash: Jason Vorhees from \"Friday the 13th\" vs Freddy Krueger from \"Nightmare on Elm Street\"?");
        System.out.println("In this game these characters and many others movie villains compete with each other in 4 categories: attire, weapons, intelligence and kills.");
        System.out.println("Categories \"attire\", \"weapons\" and \"intelligence\" are scored on the scale 1-10.");
        System.out.println("\"Kills\" category is an estimate of how many victims died at the hands of the given character.");
        System.out.println("\nENJOY!\n");
        System.out.println("Press enter to go back to main menu" + RESET);
        scan.nextLine();
    }

    public void printInfo(String message){
        System.out.println(BLUE + message + RESET);
    }

    @Override
    public void print(String info) {
        System.out.println(BLUE + info + RESET);
    }

    @Override
    public void print(Card card) {
        String[] lines = card.toString().split("\n");
        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
        System.out.println(String.format(RED + "| " + RESET + BLUE + "name:" + "%-43s" + RESET + RED + "  |" + RESET, card.getName()));
        System.out.println(String.format(RED + "| " + RESET +  BLUE + "movie:" + ITALIC + "%-42s" + RESET + RED + "  |" + RESET, card.getMovie()));
        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
        System.out.println(RED + "|" + " ".repeat(WIDTH) + " |" + RESET);
            for (String line : lines) {
                System.out.println(String.format(RED + "| " + RESET + BLUE + "%-48s" + RESET + RED + "  |" + RESET, line));
        }
        System.out.println(RED + "|" + " ".repeat(WIDTH) + " |" + RESET);
        System.out.println(RED + " " + "-".repeat(WIDTH) + "-" + RESET);
    }

    public void printStatistics(List<RealPlayer> players, List<Card> pot, int roundNumber) {
        System.out.println();
        System.out.printf(YELLOW + "\nGame status after round %d:\n" + RESET, roundNumber);
        for (RealPlayer player : players) {
            System.out.printf(YELLOW + "%s: %d cards\n" + RESET, player.getName(), player.getCards().size());
        }
        System.out.printf(YELLOW + "Pot: %d cards\n" + RESET, pot.size());

    }

    public void printMessage(String message, int var) {
        System.out.printf(message, var);
    }

    public void displayDrawScreen(Card card, Category category, Table table) {
        System.out.printf(YELLOW + "Draw! %s has same %s score as %s. \n" + RESET, card.getName(),
                                                                category.toString().toLowerCase(),
                                                                table.getCardsThatTie(card));
        System.out.println(YELLOW + "Cards stay on the table." + RESET);
    }

    public void displayEndOfRoundScreen(RealPlayer player, Card card, Table table, Category category) {
        System.out.printf(GREEN + "%s wins the round. " + RESET, player.getName());
        System.out.printf(GREEN + "%s beats %s in %s." + RESET, card.getName(), table.getOtherCardsNames(card),
                                                                  category.toString().toLowerCase());
    }

    public void displayWinScreen(RealPlayer player) {
        System.out.println();
        System.out.printf(YELLOW + "%s WINS THE GAME!%n" + RESET, player.getName().toUpperCase());
        System.out.println(RED + "\nPress enter to go back to main menu" + RESET);
        scan.nextLine();
    }
}
