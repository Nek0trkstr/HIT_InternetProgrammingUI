package com.hit.driver;

import javax.swing.*;
import com.hit.view.LocationsFrame;
public class UIDriver {

    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("ButtonExample");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //Create and set up the content pane.
//        JPanel testPanel = new JPanel();
////        ButtonExample newContentPane = new ButtonExample();
//        testPanel.setOpaque(true);
//        frame.setContentPane(testPanel);
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
        new LocationsFrame();
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
