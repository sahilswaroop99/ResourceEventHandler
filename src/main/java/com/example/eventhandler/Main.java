package com.example.eventhandler;

public class Main {
    public static void main(String[] args) {
        ResourceEventGenerator generator = new ResourceEventGenerator();

        // Register various handlers
        generator.registerHandler(new JSONEncodingHandler());
        generator.registerHandler(new FilteringHandler(resource -> "int".equals(resource.get("datatype"))));
        generator.registerHandler(new LoggingHandler());
        generator.registerHandler(new BufferingAndReorderingHandler());

        HighLoadEventHandler highLoadHandler = new HighLoadEventHandler();
        generator.registerHandler(highLoadHandler);

        // Start generating events
        generator.start();

        // Add shutdown hook to stop the generator and shutdown high load handler executor
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            generator.stop();
            highLoadHandler.shutdown();
        }));
    }
}
