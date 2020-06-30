package com.codecool.oop.controllers;

public class ViewController {

    public void printMenu() {

        String[] options = {" New game", " Help", " Exit"};
        System.out.println("------------------");
        System.out.println(" BATTLE OF CARDS");
        System.out.println("------------------");
        for(int index = 0; index < options.length; index++){
            System.out.println("   " + (index + 1) + ". " + options[index]);
        }
        System.out.println("------------------");
    }
}
