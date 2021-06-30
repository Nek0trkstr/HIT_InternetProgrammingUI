package com.hit.view;

import com.hit.controller.LocationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {
    private LocationController controller;
    private JButton deleteButton = new JButton("Delete Location");
    private JButton createButton = new JButton("Create Location");
    private JButton editButton = new JButton("Edit Location");
    private JLabel label = new JLabel("Choose action");

    public AdminFrame(LocationController controller) {
        this.controller = controller;
        deleteButton.addActionListener(this);
        createButton.addActionListener(this);
        editButton.addActionListener(this);
        label.setHorizontalAlignment(JLabel.CENTER);
        Render();
    }

    private void Render() {
        this.setTitle("TailTrip: Select Action");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());

        this.add(label, BorderLayout.NORTH);
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new FlowLayout());
        actionsPanel.add(deleteButton);
        actionsPanel.add(createButton);
        actionsPanel.add(editButton);
        this.add(actionsPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == deleteButton) {
            new LocationDeleteFrame(controller);
        }
        else if (source == editButton) {
            new LocationEditSelectionFrame(controller);
        }
        else if (source == createButton) {
            new LocationCreateFrame(controller);
        }
    }
}
