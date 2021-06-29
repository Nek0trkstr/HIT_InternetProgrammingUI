package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;
import com.hit.graph.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PathQueryWindow extends JFrame  implements ActionListener{
    private IExitObserver parentComponent;
    private LocationController locationController;
    private Location location;
    private JComboBox sourceComboBox;
    private JComboBox destinationComboBox;
    private JButton submitButton = new JButton("Submit");
    private Vertex selectedSource;
    private Vertex selectedDestination;

    public PathQueryWindow(IExitObserver parentComponent,LocationController locationController, Location location) {
        this.parentComponent = parentComponent;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sourceComboBox) {
            System.out.println("Source");
        }
        else if (e.getSource() == destinationComboBox) {
            System.out.println("Destination");
        }
        else if (e.getSource() == submitButton) {
            System.out.println("Submit");
        }
    }
}
