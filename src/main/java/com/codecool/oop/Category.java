package com.codecool.oop;

public enum Category {
    ATTIRE(1),
    WEAPONS(2),
    INTELLIGENCE(3),
    KILLS(4);

    int id;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

