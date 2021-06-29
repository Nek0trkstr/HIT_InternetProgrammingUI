package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LocationsListPanel extends JPanel implements IExitObserver, ActionListener {
    private LocationController locationController;
    private IExitObserver parentComponent;
    private List<Location> locationList;
    private List<LocationSelectButton> locationSelectList;

    public LocationsListPanel(IExitObserver parentComponent, LocationController locationController) {
        this.parentComponent = parentComponent;
        this.locationController = locationController;
        Render();
    }

    private void Render() {
        locationList = locationController.listLocations();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        for(Location location : locationList) {
            LocationSelectButton selectButton = new LocationSelectButton(this, location);
            selectButton.addActionListener(this);
            this.add(selectButton);
        }
    }

    @Override
    public void ChildItemExited() {
        System.out.println("Child Exited");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Location location : locationList) {
            if (((JButton)e.getSource()).getText() == location.getName()) {
               new PathQueryWindow(this, locationController, location);
            }
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        new PathQueryWindow(this, locationController, )
//    }
}
