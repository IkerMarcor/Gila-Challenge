package com.gila.challenge.interfaces;

/* Create and Read Interface */

public interface ICR<T> {
    void create(T object);
    T read(int id);
}
