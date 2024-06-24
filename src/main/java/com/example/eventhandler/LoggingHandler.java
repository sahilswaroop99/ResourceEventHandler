package com.example.eventhandler;
import java.util.Map;
import java.util.logging.Logger;

public class LoggingHandler implements ResourceEventHandler {
    private final Logger logger = Logger.getLogger(LoggingHandler.class.getName());

    @Override
    public void handleEvent(Map<String, Object> resource) {
        logger.info("Resource event: " + resource);
    }
}
