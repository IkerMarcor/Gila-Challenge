package com.gila.challenge.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gila.challenge.interfaces.IConnection;

public class LocalConnection implements IConnection {
    private String url = "jdbc:mysql://localhost/notification";
    private String user = "root";
    private String password = "password";
    
    //Instance connection
    private Connection connection;

    public LocalConnection() {
    }

    @Override
    public boolean testConnection() {
        try {
            if(connection != null && connection.isValid(0)){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Succesfully connected to DB: "+ this.url);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Succesfully closed connection");
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
