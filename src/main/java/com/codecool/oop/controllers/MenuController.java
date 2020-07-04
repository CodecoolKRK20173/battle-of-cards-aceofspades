package com.codecool.oop.controllers;

import com.codecool.oop.ui.View;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class MenuController {

    private static View view = new View();
    private static Scanner scan = new Scanner(System.in);

    public void menu() throws IOException, URISyntaxException {
        boolean gameOn = true;

        view.printStart();
        view.clearScreen();

        while (gameOn) {
            view.printMenu();
            int userInput = getUserInput();

            if (userInput == 1) {
                view.clearScreen();
                GameController game = new GameController();
                game.run();
            } else if (userInput == 2) {
                view.printRules();
            } else if (userInput == 3) {
                gameOn = false;
            }
        }
    }

    static int getUserInput() {

        while (!scan.hasNextInt()) {
            view.printInfo("Wrong input format");
            scan.next();
        }
        int input = scan.nextInt();

        return input;
    }
}
