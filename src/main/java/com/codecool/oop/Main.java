package com.codecool.oop;

import com.codecool.oop.controllers.*;


import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) {
        try {
            MenuController menuController = new MenuController();
            menuController.menu();
        } catch (IOException | URISyntaxException | NullPointerException e) {
            System.out.println("Input file was not found");
        }
    }
}
