package com.example.eventhandler;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class LoggingHandlerTest {
    private LoggingHandler handler;
    private Logger logger = Logger.getLogger(LoggingHandler.class.getName());
    private TestLogHandler testLogHandler;

    @Before
    public void setUp() {
        handler = new LoggingHandler();
        testLogHandler = new TestLogHandler();
        logger.addHandler(testLogHandler);
        logger.setUseParentHandlers(false); // Disable logging to console
    }

    @Test
    public void testHandleEvent() {
        Map<String, Object> resource = new HashMap<>();
        resource.put("name", "TestResource");
        resource.put("timestamp", "2024-01-01T00:00:00Z");
        resource.put("datatype", "int");
        resource.put("value", 42);

        handler.handleEvent(resource);

        assertTrue(testLogHandler.getLog().contains("Resource event: {datatype=int, name=TestResource, value=42, timestamp=2024-01-01T00:00:00Z}"));
    }

    // Custom Log Handler to capture log messages
    private static class TestLogHandler extends Handler {
        private final StringBuilder log = new StringBuilder();

        @Override
        public void publish(LogRecord record) {
            log.append(record.getMessage()).append(System.lineSeparator());
        }

        @Override
        public void flush() {
            // No action needed
        }

        @Override
        public void close() throws SecurityException {
            // No action needed
        }

        public String getLog() {
            return log.toString();
        }
    }
}
