package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LocationDeletePanel extends JPanel implements ActionListener {
    private LocationController controller;

    public LocationDeletePanel(LocationController controller) {
        this.controller = controller;
        Render();
    }

    private void Render() {
       List<Location> locationList = controller.listLocations();
       for (Location location : locationList) {
           JButton locationDeleteButton = new JButton(location.getName());
           locationDeleteButton.addActionListener(this);
           this.add(locationDeleteButton);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String locationToDeleteName = sourceButton.getText();
        controller.deleteLocation(locationToDeleteName);
        this.remove(sourceButton);
        this.repaint();
    }
}
