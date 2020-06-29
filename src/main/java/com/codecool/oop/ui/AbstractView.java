package com.codecool.oop.ui;
import com.codecool.oop.Card;

public abstract class AbstractView {

    public abstract void print(String info);

    public abstract void print(Card card);

    public abstract void print(Card card1, Card card2);


}
