package com.example.eventhandler;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HighLoadEventHandler implements ResourceEventHandler {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    @Override
    public void handleEvent(Map<String, Object> resource) {
        executor.submit(() -> processEvent(resource));
    }

    private void processEvent(Map<String, Object> resource) {
        // Process event in parallel
        System.out.println("Processed event in parallel: " + resource);
    }

    // Ensure to shutdown the executor service properly
    public void shutdown() {
        executor.shutdown();
    }
}
