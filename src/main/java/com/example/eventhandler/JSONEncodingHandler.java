package com.example.eventhandler;
import java.util.Map;

import com.google.gson.Gson;

public class JSONEncodingHandler implements ResourceEventHandler {
    private final Gson gson = new Gson();

    @Override
    public void handleEvent(Map<String, Object> resource) {
        String json = gson.toJson(resource);
        System.out.println("Encoded JSON: " + json);
    }
}
