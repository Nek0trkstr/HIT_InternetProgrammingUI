package com.hit.controller;

import com.github.javafaker.Faker;
import com.hit.client.Client;
import com.hit.dm.Location;
import com.hit.dm.Place;
import com.hit.graph.GraphPath;
import com.hit.graph.Vertex;

import java.util.List;

public class LocationController {
    private Client client;
    String serverAddress;
    int serverPort;

    public LocationController(Client client) {
        this.client = client;
    }
    public LocationController(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public List<Location> listLocations() {
        List<Location> locationList = null;
        try {
            Client client = new Client(serverAddress, serverPort);
            locationList = client.listLocations();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return locationList;
    }

    public Location getLocation(String name) {
        Location location = null;
       try {
           location = client.getLocation(name);
       }
       catch (Exception e) {
           e.printStackTrace();
       }
       return location;
    }

    public void createLocation(Location newLocation) {
        try {
            Client client = new Client(serverAddress, serverPort);
            client.createLocation(newLocation);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createRandomizedLocation() {
        try {
            Client client = new Client(serverAddress, serverPort);
            Faker faker = new Faker();
            String locationName = faker.address().city();
            String locationDescription = faker.chuckNorris().fact();
            Location newLocation = new Location(locationName, locationDescription);
            String placeName = faker.address().streetAddress();
            Place place = new Place(placeName);
            newLocation.addPlace(place);
            client.createLocation(newLocation);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editLocation(Location editedLocation) {
        try {
            Client client = new Client(serverAddress, serverPort);
            client.editLocation(editedLocation);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLocation(String locationToDeleteName) {
        try {
            Client client = new Client(serverAddress, serverPort);
            client.deleteLocation(locationToDeleteName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GraphPath findShortestPath(String locationName, Vertex source, Vertex dest) {
        GraphPath path = null;
        try {
            Client client = new Client(serverAddress, serverPort);
            path = client.findShortestPath(locationName, source, dest);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return path;
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

