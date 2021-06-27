package com.hit.controller;

import com.hit.client.Client;
import com.hit.dm.Location;
import com.hit.graph.Graph;

import java.io.IOException;
import java.util.List;

public class LocationController {
    private Client client;

    public LocationController(Client client) {
        this.client = client;
    }

    public void listLocations() {
        try {
            List<Location> locationList = client.listLocations();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocation(String name) {
       try {
           Location location = client.getLocation(name);
       }
       catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void createLocation() {
        try {
            Location newLocation = new Location("location", "test location");
            client.createLocation(newLocation);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 34567);
            LocationController controller = new LocationController(client);
//            controller.listLocations();
//            controller.getLocation("Great waterfall");
            controller.createLocation();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

