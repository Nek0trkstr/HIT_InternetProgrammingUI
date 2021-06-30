package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;
import javax.swing.*;
import java.awt.*;

public class PathQueryWindow extends JFrame {
    private LocationController locationController;
    private Location location;

    public PathQueryWindow(LocationController locationController, Location location) {
        this.locationController = locationController;
        this.location = location;
        Render();
    }

    private void Render() {
        this.setTitle(location.getName());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());

        JLabel label = new JLabel("Check shortest Path " + location.getName());
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        PathQueryPanel queryPanel = new PathQueryPanel(locationController, location);
        this.add(queryPanel, BorderLayout.CENTER);
    }
}
