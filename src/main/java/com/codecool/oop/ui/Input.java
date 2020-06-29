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
        int number = getIntegerInput("Choose category to compare: \n1 - attire, \n2 - weapons, \n3 - intelligence, \n4 - kills");
        return number;
    }
}
