package com.codecool.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Setup {

    static Scanner scan = new Scanner(System.in);
    List<RealPlayer> players;

    public Setup() {
        View view = new View();
        players = new ArrayList<>();
        view.printMessage("Enter number of players: ");
        String numberOfPlayers = scan.nextLine();
        for (int i = 0; i < Integer.parseInt(numberOfPlayers); i++) {
            view.printMessage("Player %d, enter your name: ", (i + 1));
            String name = scan.nextLine();
            players.add(new RealPlayer(name));
        }
    }

    public List<RealPlayer> getPlayers() {
        return players;
    }
}
