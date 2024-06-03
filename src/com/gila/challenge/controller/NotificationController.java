package com.gila.challenge.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.gila.challenge.config.LocalConnection;
import com.gila.challenge.interfaces.ICR;
import com.gila.challenge.model.Notification;

public class NotificationController implements ICR<Notification> {

    private Connection conn;
    private final LocalConnection connection = new LocalConnection();

    @Override
    public void create(Notification notificationObject) {
        try {
            connection.openConnection();
            String query = "INSERT INTO Notifications(categoryId, message) VALUES (?,?)";
            PreparedStatement statement = connection.getConnection().prepareStatement(query);

            statement.setInt(1, notificationObject.getId());
            statement.setString(2, notificationObject.getMessage());

            statement.executeUpdate();
            System.out.println("Se hizo un registro de forma exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error - 404", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Notification read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
    
}
