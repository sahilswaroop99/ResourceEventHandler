package com.example.eventhandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HighLoadEventHandlerTest {
    private HighLoadEventHandler handler;

    @Before
    public void setUp() {
        handler = new HighLoadEventHandler();
    }

    @After
    public void tearDown() {
        handler.shutdown();
    }

    @Test
    public void testHandleEvent() throws InterruptedException {
        Map<String, Object> resource = new HashMap<>();
        resource.put("name", "TestResource");
        resource.put("timestamp", "2024-01-01T00:00:00Z");
        resource.put("datatype", "int");
        resource.put("value", 42);

        // Redirect System.out to capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        handler.handleEvent(resource);

        // Wait a bit to allow the asynchronous task to complete
        TimeUnit.SECONDS.sleep(1);

        String output = outContent.toString();
        assertTrue(output.contains("Processed event in parallel"));

        // Reset System.out to its original stream
        System.setOut(System.out);
    }
}
