package com.codecool.oop.table;

public enum Category {
    ATTIRE(1),
    WEAPONS(2),
    INTELLIGENCE(3),
    KILLS(4);

    int id;

    Category(int id) {
        this.id = id;
    }

    public static Category findByID(int id) {
        for (Category category : values()) {
            if (id == category.id) {
                return category;
            }
        }
        return null;
    }
}

