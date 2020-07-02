package com.codecool.oop.ui;

import java.util.Scanner;

public class Input {
    private View view;

    public Input(){
        view = new View();
    }

    private int getIntegerInput(String info) {
        int input = 0;
        view.print(info);
        view.emptySpace();
        Scanner scannerFromUser = new Scanner(System.in);

        while(!scannerFromUser.hasNextInt()){
            view.print("Wrong, please provide correct number");
            scannerFromUser.next();
        }
        input = scannerFromUser.nextInt();
        return input;
    }


    private String getStringInput(String info) {
        view.print(info);
        view.emptySpace();
        Scanner scannerFromUser = new Scanner(System.in);

        return scannerFromUser.nextLine();
    }

    public String getName() {
        String name = "";
        name = getStringInput("What's your name?");
        while(name.length() < 1) {
            name = getStringInput("Wrong, please provide correct name");
        }
        return name;
    }

    public int getCategory() {
        return getIntegerInput("Choose category to compare: 1 - attire, 2 - weapons, 3 - intelligence, 4 - kills");
    }

    public int getNumberOfPlayers() {
        return getIntegerInput("Enter number of players");
    }
}
