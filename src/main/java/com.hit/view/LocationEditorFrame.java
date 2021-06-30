package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationEditorFrame extends JFrame implements ActionListener {
    private LocationController controller;
    private Location locationToEdit;
    private JButton submit = new JButton("Submit");
    TextArea descriptionArea;

    public LocationEditorFrame(LocationController controller, Location locationToEdit) {
        this.controller = controller;
        this.locationToEdit = locationToEdit;
        submit.addActionListener(this);
        this.setTitle("TailTrip: edit " + locationToEdit.getName());
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
       TextField locationName = new TextField(locationToEdit.getName());
       locationName.setEditable(false);
       descriptionArea = new TextArea(locationToEdit.getDescription());
       this.add(locationName, BorderLayout.NORTH);
       this.add(descriptionArea, BorderLayout.CENTER);
       this.add(submit, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String newDescription = descriptionArea.getText();
            Location editedLocation = locationToEdit;
            editedLocation.setDescription(newDescription);
            controller.editLocation(editedLocation);
        }
    }
}
