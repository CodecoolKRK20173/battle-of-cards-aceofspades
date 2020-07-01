package com.codecool.oop.ui;
import com.codecool.oop.table.Card;
import com.codecool.oop.table.RealPlayer;

import java.util.List;

public class View extends AbstractView {

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

    public void printStatistics(List<RealPlayer> players, int roundNumber) {
        System.out.printf("Game status after round %d:\n", roundNumber);
        for (RealPlayer player : players) {
            System.out.printf("%s: %d cards left\n", player.getName(), player.getCards().size());
        }
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessage(String message, int var) {
        System.out.printf(message, var);
    }

}
