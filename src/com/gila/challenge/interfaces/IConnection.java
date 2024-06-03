package com.gila.challenge.interfaces;

/* DB connection Interface */

public interface IConnection {
    boolean testConnection();
    void openConnection();
    void closeConnection();
}
