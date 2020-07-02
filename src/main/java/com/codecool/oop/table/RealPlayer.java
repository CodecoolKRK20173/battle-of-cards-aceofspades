package com.codecool.oop.table;

import com.codecool.oop.ui.Input;

import java.util.Scanner;

public class RealPlayer extends Player {

    Input input = new Input();

    public RealPlayer(String name) {
        super(name);
    }

    public Category chooseCategory() {
        return Category.findByID(input.getCategory());
    }
}
