package com.hit.view;

import com.hit.controller.LocationController;
import com.hit.dm.Location;
import com.hit.graph.GraphPath;
import com.hit.graph.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PathQueryPanel extends JPanel implements ActionListener {
    private LocationController locationController;
    private Location location;
    private JComboBox sourceComboBox;
    private JComboBox destinationComboBox;
    private Vertex selectedSource;
    private Vertex selectedDestination;
    private JButton submitButton = new JButton("Submit");
    private JLabel path = new JLabel();
    private JLabel graphVizLabel = new JLabel("Import to http://dreampuf.github.io to vizualise");
    private JTextField graphViz = new JTextField();

    public PathQueryPanel(LocationController locationController, Location location) {
        this.setLayout(new BorderLayout());
        this.locationController = locationController;
        this.location = location;
        this.sourceComboBox = new JComboBox(location.getVertices().toArray());
        this.destinationComboBox = new JComboBox(location.getVertices().toArray());
        selectedSource = (Vertex)sourceComboBox.getSelectedItem();
        selectedDestination = (Vertex)destinationComboBox.getSelectedItem();
        sourceComboBox.addActionListener(this);
        destinationComboBox.addActionListener(this);
        submitButton.addActionListener(this);
        graphViz.setText(location.toGraphViz());
        graphViz.setFont(new Font(null,Font.PLAIN, 25));
        Render();
    }

    private void Render() {
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout());
        JLabel sourceLabel = new JLabel("Source:");
        horizontalPanel.add(sourceLabel);
        horizontalPanel.add(sourceComboBox);
        JLabel destLabel = new JLabel("Destination:");
        horizontalPanel.add(destLabel);
        horizontalPanel.add(destinationComboBox);
        horizontalPanel.add(submitButton);
        horizontalPanel.add(path);
        this.add(horizontalPanel, BorderLayout.NORTH);
        JPanel graphVizPanel = new JPanel();
        graphVizPanel.setLayout(new BorderLayout());
        graphVizPanel.add(graphVizLabel, BorderLayout.NORTH);
        graphVizPanel.add(graphViz, BorderLayout.CENTER);
        this.add(path, BorderLayout.SOUTH);
        this.add(graphVizPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sourceComboBox) {
            selectedSource = (Vertex) sourceComboBox.getSelectedItem();
        }
        else if (e.getSource() == destinationComboBox) {
            selectedDestination = (Vertex) destinationComboBox.getSelectedItem();
        }
        else if (e.getSource() == submitButton) {
            GraphPath shortestPath = locationController.findShortestPath(location.getName(), selectedSource, selectedDestination);

            path.setText(shortestPath.toString());
            System.out.println(shortestPath);
        }
    }
}
