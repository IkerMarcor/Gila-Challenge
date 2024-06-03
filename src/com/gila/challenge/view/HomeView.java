package com.gila.challenge.view;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {
    private String categories[] = {"Sports", "Finance", "Movies"};
    private JLabel label;
    private JTextArea txtArea;
    private JComboBox<String> comboBox;
    private JButton btnNotify, btnExit;

    public HomeView(String title) throws HeadlessException {
        super(title);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) pantalla.getHeight();
        int width = (int) pantalla.getWidth();

        this.setSize(width / 2, height / 2);

        // Usar GridBagLayout para la disposición de los componentes
        GridBagLayout layout = new GridBagLayout();
        this.getContentPane().setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        label = new JLabel("Message");
        txtArea = new JTextArea(10, 35);
        comboBox = new JComboBox<String>(categories);
        btnNotify = new JButton("Notify");
        btnExit = new JButton("Exit");

        // Configurar los GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Añadir márgenes entre los componentes
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir los componentes al contenedor con el layout
        this.getContentPane().add(label, gbc);
        gbc.gridy++;
        this.getContentPane().add(txtArea, gbc);
        gbc.gridy++;
        this.getContentPane().add(comboBox, gbc);
        gbc.gridy++;
        this.getContentPane().add(btnNotify, gbc);
        gbc.gridy++;
        this.getContentPane().add(btnExit, gbc);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // getters y setters
    public JButton getbtnExit() {
        return btnExit;
    }

    public void setbtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    public JButton getbtnNotify() {
        return btnNotify;
    }

    public void setbtnNotify(JButton btnNotify) {
        this.btnNotify = btnNotify;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

}