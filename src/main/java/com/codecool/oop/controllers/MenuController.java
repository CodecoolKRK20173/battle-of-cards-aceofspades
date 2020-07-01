package com.codecool.oop.controllers;

import com.codecool.oop.ui.View;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class MenuController {

    private static View view = new View();
    private static Scanner scan = new Scanner(System.in);

    public void printMenu() {

        String[] options = {" New game", " Help", " Exit"};
        System.out.println("------------------");
        System.out.println(" BATTLE OF CARDS");
        System.out.println("------------------");
        for(int index = 0; index < options.length; index++){
            System.out.println("   " + (index + 1) + ". " + options[index]);
        }
        System.out.println("------------------");
    }

    public void menu() throws IOException, URISyntaxException {
        boolean gameOn = true;

        while (gameOn) {
            view.clearScreen();
            printMenu();

            System.out.print("Choose one of the options: ");
            int userInput = getUserInput();

            if (userInput == 1) {
                view.clearScreen();
                GameController game = new GameController();
                game.run();

            } else if (userInput == 2) {
                printRules();
            } else if (userInput == 3) {
                gameOn = false;
            } else if (userInput == 0) {
                // runTestGame();
            }
        }
    }

    static int getUserInput(){

        while(!scan.hasNextInt()) {
            System.out.println("Wrong input format");
            scan.next();
        }
        int input = scan.nextInt();

        return input;
    }

    static void printRules() {
        System.out.println("Some rules");
    }
}