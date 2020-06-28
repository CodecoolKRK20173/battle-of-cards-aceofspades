package com.codecool.oop;

public class Main {
    public static void main(String[] args) {
        Setup setup = new Setup();
        Dealer dealer = new Dealer();
        Table table = new Table(setup.getPlayers(), dealer);
        System.out.println(table.getPlayers().toString());
    }
}
