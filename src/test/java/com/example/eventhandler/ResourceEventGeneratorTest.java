package com.example.eventhandler;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Before;
import org.junit.Test;

public class ResourceEventGeneratorTest {
    private ResourceEventGenerator generator;
    private MockHandler mockHandler;

    @Before
    public void setUp() {
        generator = new ResourceEventGenerator();
        mockHandler = new MockHandler();
        generator.registerHandler(mockHandler);
    }

    @Test
    public void testGenerateEvent() throws InterruptedException {
        generator.start();
        Thread.sleep(2000); // Wait for 2 seconds to let the generator produce events
        generator.stop();

        assertFalse(mockHandler.getHandledEvents().isEmpty());
    }

    private static class MockHandler implements ResourceEventHandler {
        private final CopyOnWriteArrayList<Map<String, Object>> handledEvents = new CopyOnWriteArrayList<>();

        @Override
        public void handleEvent(Map<String, Object> resource) {
            handledEvents.add(resource);
        }

        public CopyOnWriteArrayList<Map<String, Object>> getHandledEvents() {
            return handledEvents;
        }
    }
}
