package com.hit.controller;

import com.hit.client.Client;
import com.hit.dm.Place;
import com.hit.graph.GraphPath;
import com.hit.graph.Vertex;

public class TripMapController {
    private Client client;

    public TripMapController(Client client) {
        this.client = client;
    }

    public void findShortestPath(String locationName, Vertex source, Vertex dest) {
        try {
            GraphPath path = client.findShortestPath(locationName, source, dest);
            System.out.println(path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
