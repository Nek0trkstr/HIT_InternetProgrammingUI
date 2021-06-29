package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;

public class LocationSelectButton extends JButton implements IExitObserver {
    private IExitObserver parentItem;
    private Location location;

    public LocationSelectButton(IExitObserver parentItem, Location location) {
        this.parentItem = parentItem;
        this.location = location;
        this.setText(location.getName());
    }

    @Override
    public void ChildItemExited() {
        this.setEnabled(true);
    }
}
