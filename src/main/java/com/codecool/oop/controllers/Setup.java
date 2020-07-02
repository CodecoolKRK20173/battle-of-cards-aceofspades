package com.codecool.oop.controllers;

import com.codecool.oop.table.RealPlayer;
import com.codecool.oop.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Setup {

    static Scanner scan = new Scanner(System.in);
    Input input = new Input();
    View view = new View();
    List<RealPlayer> players;

    public Setup() {
        players = new ArrayList<>();
        int numberOfPlayers = input.getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            view.printMessage("Player %d, enter your name: ", (i + 1));
            String name = scan.nextLine();
            players.add(new RealPlayer(name));
        }
    }

    public List<RealPlayer> getPlayers() {
        return players;
    }
}
