package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LocationsFrame extends JFrame implements IExitObserver {
    List<LocationSelectButton> locationSelectButtons = new ArrayList<>();

    public LocationsFrame() {
        this.setTitle("TailTrip");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());

        JLabel label = new JLabel("Choose a location: ");
        label.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        LocationController controller = new LocationController("localhost", 34567);
        LocationsListPanel locationsListPanel = new LocationsListPanel(this, controller);
        this.add(locationsListPanel, BorderLayout.CENTER);
    }

    @Override
    public void ChildItemExited() {
        System.out.println("Window Frame exited");
    }

}
