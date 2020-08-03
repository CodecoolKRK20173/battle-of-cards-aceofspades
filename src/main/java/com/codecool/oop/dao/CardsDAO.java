package com.codecool.oop.dao;

import java.util.LinkedList;
import java.util.List;

public interface CardsDAO<T> {

    LinkedList<T> getAll();

    void add(T t);

    void delete(T t);
}
