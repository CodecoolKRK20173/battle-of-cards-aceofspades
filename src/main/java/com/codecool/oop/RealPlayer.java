package com.codecool.oop;

import java.util.Scanner;

public class RealPlayer extends Player {

    Scanner scan = new Scanner(System.in);

    public RealPlayer(String name) {
        super(name);
    }

    @Override
    public int chooseCategory() {
        System.out.println("Choose category to compare: 1 - attire, 2 - weapons, 3 - intelligence, 4 - kills");
        return scan.nextInt();
    }
}
