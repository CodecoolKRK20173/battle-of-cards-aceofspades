package com.codecool.oop;

import java.util.List;

public interface CardDAO<T> {

    List<T> getAll();

    void add(T t);

    void delete(T t);
}
