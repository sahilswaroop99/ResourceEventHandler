package com.example.eventhandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ResourceEventGenerator {
    private final List<ResourceEventHandler> handlers = new CopyOnWriteArrayList<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final AtomicBoolean running = new AtomicBoolean(false);

    // Method to start generating events
    public void start() {
        if (running.compareAndSet(false, true)) {
            scheduler.scheduleAtFixedRate(this::generateEvent, 0, 1, TimeUnit.SECONDS);
        }
    }

    // Method to stop generating events
    public void stop() {
        if (running.compareAndSet(true, false)) {
            scheduler.shutdown();
        }
    }

    // Method to register an event handler
    public void registerHandler(ResourceEventHandler handler) {
        handlers.add(handler);
    }

    // Method to generate a random resource event
    private void generateEvent() {
        Map<String, Object> resource = new HashMap<>();
        resource.put("name", "TestResource");
        resource.put("timestamp", new Date());
        resource.put("datatype", "int");
        resource.put("value", new Random().nextInt(100));

        for (ResourceEventHandler handler : handlers) {
            handler.handleEvent(resource);
        }
    }
}
