package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationEditSelectionPanel extends JPanel implements ActionListener {
    private LocationController controller;
    private Map<JButton, Location> buttonLocationMap = new HashMap<>();

    public LocationEditSelectionPanel(LocationController controller) {
        this.controller = controller;
        this.setLayout(new FlowLayout());
        Render();
    }

    private void Render() {
        List<Location> locationList = controller.listLocations();
        for (Location location : locationList) {
            JButton editLocationButton = new JButton(location.getName());
            buttonLocationMap.put(editLocationButton, location);
            editLocationButton.addActionListener(this);
            this.add(editLocationButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        Location locationToEdit = buttonLocationMap.get(sourceButton);
        new LocationEditorFrame(controller, locationToEdit);
    }
}
