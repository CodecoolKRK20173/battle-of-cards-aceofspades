package com.codecool.oop;

import com.codecool.oop.controllers.*;

import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException{
        ViewController viewController = new ViewController();
        viewController.menu();

    }
}
