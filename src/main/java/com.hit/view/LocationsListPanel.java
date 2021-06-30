package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LocationsListPanel extends JPanel implements ActionListener {
    private LocationController locationController;
    private List<Location> locationList;

    public LocationsListPanel(LocationController locationController) {
        this.locationController = locationController;
        Render();
    }

    private void Render() {
        locationList = locationController.listLocations();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        for(Location location : locationList) {
            LocationSelectButton selectButton = new LocationSelectButton(location);
            selectButton.addActionListener(this);
            this.add(selectButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Location location : locationList) {
            if (((JButton)e.getSource()).getText() == location.getName()) {
               new PathQueryWindow(locationController, location);
            }
        }
    }
}
