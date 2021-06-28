package com.hit.controller;

import com.hit.client.Client;
import com.hit.dm.Location;
import com.hit.dm.Place;
import com.hit.graph.GraphPath;
import com.hit.graph.Vertex;

import java.util.List;

public class LocationController {
    private Client client;

    public LocationController(Client client) {
        this.client = client;
    }

    public List<Location> listLocations() {
        List<Location> locationList = null;
        try {
            locationList = client.listLocations();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return locationList;
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

    public void editLocation() {
        try {
            Location editedLocation = new Location("location", "edited location");
            client.editLocation(editedLocation);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLocation() {
        try {
            client.deleteLocation("location");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 34567);
            LocationController controller = new LocationController(client);
            List<Location> locationList = controller.listLocations();

            Location location = locationList.get(0);
            String locationName = location.getName();
            Vertex source = location.getVertices().get(0);
            Vertex dest = location.getVertices().get(1);
            client = new Client("localhost", 34567);
            TripMapController mapController = new TripMapController(client);
            mapController.findShortestPath(locationName, source, dest);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

