package com.hit.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.dm.Location;
import com.hit.dm.Place;
import com.hit.graph.Graph;
import com.hit.graph.GraphPath;
import com.hit.graph.Vertex;
import com.hit.server.Headers;
import com.hit.server.Request;
import com.hit.server.ShortestPathQuery;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.List;

public class Client {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Gson parser = new Gson();

    public Client(String serverAddress, int serverPort) throws IOException {
        Socket socket = new Socket(serverAddress, serverPort);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream( socket.getInputStream());
    }

    public List<Location> listLocations() throws IOException, ClassNotFoundException {
        Headers headers = new Headers("Location", "LIST");
        Request req = new Request(headers);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        Type respType = new TypeToken<Response<List<Location>>>(){}.getType();
        Response<List<Location>> response = parser.fromJson(jsonResp, respType);
        return response.getBody();
    }

    public Location getLocation(String name) throws IOException, ClassNotFoundException{
        Headers headers = new Headers("Location", "GET", "Great waterfall");
        Request req = new Request(headers);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        Type respType = new TypeToken<Response<Location>>(){}.getType();
        Response<Location> response = parser.fromJson(jsonResp, respType);
        return response.getBody();
    }

    public void createLocation(Location newLocation) throws IOException, ClassNotFoundException {
        Headers headers = new Headers("Location", "POST");
        Request<Location> req = new Request(headers, newLocation);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        parser.fromJson(jsonResp, Response.class);
    }

    public void editLocation(Location editedLocation) throws IOException, ClassNotFoundException {
        Headers headers = new Headers("Location", "PUT");
        Request<Location> req = new Request(headers, editedLocation);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        parser.fromJson(jsonResp, Response.class);
    }

    public void deleteLocation(String locationToDelete) throws IOException, ClassNotFoundException {
        Headers headers = new Headers("Location", "DELETE", locationToDelete);
        Request req = new Request(headers);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        parser.fromJson(jsonResp, Response.class);
    }

    public GraphPath findShortestPath(String locationName, Vertex source, Vertex destination)
            throws  IOException, ClassNotFoundException {
        Headers headers = new Headers("TripMap", "GET");
        ShortestPathQuery query = new ShortestPathQuery(locationName, source, destination);
        Request req = new Request(headers, query);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        Type type = new TypeToken<Response<GraphPath>>(){}.getType();
        Response<GraphPath> response = parser.fromJson(jsonResp, type);
        GraphPath result = response.getBody();
        return result;
    }
}
