package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;

public class LocationSelectButton extends JButton {
    private IExitObserver parentItem;
    private Location location;

    public LocationSelectButton(Location location) {
        this.location = location;
        this.setText(location.getName());
    }
}
