package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.*;

public class LocationDeleteFrame extends JFrame {
        private LocationController controller;
        private JLabel label = new JLabel("TailTrip");

        public LocationDeleteFrame(LocationController controller) {
            this.controller = controller;
            this.setTitle("TailTrip: Delete Location");
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
            this.add(label, BorderLayout.NORTH);

            LocationDeletePanel deletePanel = new LocationDeletePanel(controller);
            this.add(deletePanel, BorderLayout.CENTER);
        }
}
