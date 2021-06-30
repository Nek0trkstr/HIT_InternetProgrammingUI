package com.hit.view;

import com.hit.controller.LocationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationCreateFrame extends JFrame implements ActionListener {
    private LocationController controller;
    private JButton createLocationButton;

    public LocationCreateFrame(LocationController controller) {
        this.controller = controller;
        this.setTitle("TailTrip: Create Location");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());
        Render();
    }

    private void Render() {
       this.setLayout(new BorderLayout());
       createLocationButton = new JButton("Create Randomized Location");
       createLocationButton.addActionListener(this);
       this.add(createLocationButton, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createLocationButton) {
            controller.createRandomizedLocation();
        }
    }
}
