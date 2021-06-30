package com.hit.view;

import com.hit.controller.LocationController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LocationsFrame extends JFrame {
    private LocationController controller;
    List<LocationSelectButton> locationSelectButtons = new ArrayList<>();

    public LocationsFrame(LocationController controller) {
        this.controller = controller;
        this.setTitle("TailTrip");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());

        JLabel label = new JLabel("Choose a location: ");
        label.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        LocationsListPanel locationsListPanel = new LocationsListPanel(controller);
        this.add(locationsListPanel, BorderLayout.CENTER);
    }

}
