package com.codecool.oop;

public enum Category {
    ATTIRE(1),
    WEAPONS(2),
    INTELLIGENCE(3),
    KILLS(4);

    int id;
    String name;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public static Category findByID(int id) {
        for (Category value: values()) {
            if (id == (value.id)) {
                return value;
            }
        }
        return null;
    }
}

