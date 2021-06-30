package com.hit.view;

import com.hit.controller.LocationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private JButton userButton;
    private JButton adminButton;
    private JLabel label = new JLabel("Choose your user");
    private LocationController controller;

    public MainFrame() {
        controller = new LocationController("localhost", 34567);
        userButton = new JButton("User");
        userButton.addActionListener(this);
        adminButton = new JButton("Admin");
        adminButton.addActionListener(this);
        Render();
    }

    public void Render() {
        this.setTitle("TailTrip: User selection");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(740,420);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("src/main/java/com.hit/resources/icon.png");
        this.setIconImage(icon.getImage());
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(1,2));
        selectionPanel.add(userButton);
        selectionPanel.add(adminButton);
        this.add(selectionPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userButton) {
           new LocationsFrame(controller);
        }
        else if (e.getSource() == adminButton) {
           new AdminFrame(controller);
        }
    }
}
