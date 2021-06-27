package com.hit.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.dm.Location;
import com.hit.graph.Graph;
import com.hit.server.Headers;
import com.hit.server.Request;

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
        Headers headers = new Headers("TripMap", "ListLocation");
        Request req = new Request(headers);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        Type respType = new TypeToken<Response<List<Location>>>(){}.getType();
        Response<List<Location>> response = parser.fromJson(jsonResp, respType);
        return response.getBody();
    }

    public Location getLocation(String name) throws IOException, ClassNotFoundException{
        Headers headers = new Headers("TripMap", "GetLocation", "Great waterfall");
        Request req = new Request(headers);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        Type respType = new TypeToken<Response<Location>>(){}.getType();
        Response<Location> response = parser.fromJson(jsonResp, respType);
        return response.getBody();
    }

    public void createLocation(Location newLocation) throws IOException, ClassNotFoundException {
        Headers headers = new Headers("TripMap", "CreateLocation");
        Request<Location> req = new Request(headers, newLocation);
        String jsonReq = parser.toJson(req);
        outputStream.writeObject(jsonReq);
        String jsonResp = (String) inputStream.readObject();
        parser.fromJson(jsonResp, Response.class);
    }
}
