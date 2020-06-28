package com.codecool.oop;

public class View {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessage(String message, int var) {
        System.out.printf(message, var);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
