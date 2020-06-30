package com.codecool.oop;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class RealPlayer extends Player {

    Scanner scan = new Scanner(System.in);
    private final LinkedList<Card> hand;

    public RealPlayer(String name) {
        super(name);
        this.hand = new LinkedList<>();
    }

    public Category chooseCategory() {
        System.out.println("Choose category to compare: 1 - attire, 2 - weapons, 3 - intelligence, 4 - kills");
        int choice = scan.nextInt();
        return Category.findByID(choice);
    }

    @Override
    public Card drawNextCard() {
        return hand.removeFirst();
    }


}
