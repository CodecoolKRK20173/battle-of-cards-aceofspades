package com.codecool.oop;

import java.util.Scanner;

public class RealPlayer extends Player {

    Scanner scan = new Scanner(System.in);

    public RealPlayer(String name) {
        super(name);
    }

    public Category chooseCategory() {
        System.out.println("Choose category to compare: 1 - attire, 2 - weapons, 3 - intelligence, 4 - kills");
        int choice = scan.nextInt();
        return Category.findByID(choice);
    }

    @Override
    public Card drawNextCard() {
        return getCards().removeFirst();
    }

}
