package com.hit.view;

import com.hit.controller.LocationController;

import javax.swing.*;
import java.awt.*;

public class LocationEditSelectionFrame extends JFrame {
    LocationController controller;

    public LocationEditSelectionFrame (LocationController controller) {
        this.controller = controller;
        this.setTitle("TailTrip: Edit Location");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());
        this.setLayout(new BorderLayout());
        Render();
    }

    private void Render() {
        LocationEditSelectionPanel editSelectionPanel = new LocationEditSelectionPanel(controller);
        this.add(editSelectionPanel, BorderLayout.CENTER);
    }
}
