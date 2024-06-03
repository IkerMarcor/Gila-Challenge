package com.gila.challenge.controller;
import java.awt.event.*;

import javax.swing.JOptionPane;

import com.gila.challenge.model.Notification;
import com.gila.challenge.view.HomeView;
import com.gila.challenge.view.LogHistoryView;

public class HomeController implements MouseListener {
    private HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
        this.view.getbtnExit().addMouseListener(this);
        this.view.getbtnNotify().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getbtnExit()) {
            System.exit(0);
        }

        if (e.getSource() == this.view.getbtnNotify()) {
            // Hacer un registro y comprueba que el mensaje no este vacio
            if (!createNotification()) {
                JOptionPane.showMessageDialog(null, "Please fill up the form", "Warning", JOptionPane.OK_OPTION); 
                return;
            }
            // Crea una ventana nueva
            LogHistoryView logView = new LogHistoryView("Log History");
            logView.homeViewConstructor(this.view);
            logView.setVisible(true);
            this.view.getTxtArea().setText("");
            this.view.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private boolean createNotification(){
        String _message;
        int _categoryId;

        Notification notification = new Notification();
        NotificationController notificationController = new NotificationController();

        _message = this.view.getTxtArea().getText();

        if(_message.equals("")){ return false; }

        _categoryId = this.view.getComboBox().getSelectedIndex() + 1;

        notification.setMessage(_message);
        notification.setId(_categoryId);

        notificationController.create(notification);
        return true;
    }
    
}
