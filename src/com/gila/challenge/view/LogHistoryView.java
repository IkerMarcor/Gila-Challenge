package com.gila.challenge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.gila.challenge.config.LocalConnection;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogHistoryView extends JFrame {
    private HomeView homeView;
    private JLabel label;
    private JTable table;
    private JButton btnBack;

    // Construir y mantener el estado de la HomeView
    public void homeViewConstructor(HomeView homeView){
        this.homeView = homeView;
    }

    public LogHistoryView(String title) throws HeadlessException {
        super(title);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) pantalla.getHeight();
        int width = (int) pantalla.getWidth();

        this.setSize(width / 2, height / 2);

        // Usar GridBagLayout para la disposición de los componentes
        GridBagLayout layout = new GridBagLayout();
        this.getContentPane().setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        label = new JLabel("Log");
        table = new JTable();
        btnBack = new JButton("Back");

        // Configurar los GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Añadir márgenes entre los componentes
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir los componentes al contenedor con el layout
        this.getContentPane().add(label, gbc);
        gbc.gridy++;
        this.getContentPane().add(table, gbc);
        gbc.gridy++;
        this.getContentPane().add(btnBack, gbc);

        // Mostrar registros y configurar tabla
        createTable();

        // Agregar ActionListeners a los botones
        btnBack.addActionListener(e -> btnBackActionPerformed());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void createTable(){
        String query = "SELECT notifications.message, categories.fieldname AS category, person.fieldname AS subscribed, person.channels, notifications.creationDate FROM Notifications"
                        + " JOIN categories ON notifications.categoryId = categories.id"
                        + " JOIN subscribed ON categories.id = subscribed.categoryId"
                        + " JOIN person ON subscribed.personId = person.id"
                        + " ORDER BY notifications.creationDate DESC";
                    
        PreparedStatement st = null;
        LocalConnection connection = new LocalConnection();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("a");
        model.addColumn("b");
        model.addColumn("c");
        model.addColumn("d");
        model.addColumn("e");
        table.setModel(model);

        String [] datos = new String[5];

        try {
            connection.openConnection();
            st = connection.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // Evento para el botón de regresar
    private void btnBackActionPerformed() {
        homeView.setVisible(true);
        this.dispose();
    }
}
