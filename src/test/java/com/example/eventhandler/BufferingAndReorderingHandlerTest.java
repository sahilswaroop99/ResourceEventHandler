package com.example.eventhandler;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BufferingAndReorderingHandlerTest {
    private BufferingAndReorderingHandler handler;

    @Before
    public void setUp() {
        handler = new BufferingAndReorderingHandler();
    }

    @Test
    public void testHandleEvent() throws InterruptedException {
        // Create a resource event with the current timestamp
        Map<String, Object> resource = new HashMap<>();
        resource.put("name", "TestResource");
        resource.put("timestamp", new Date());
        resource.put("datatype", "int");
        resource.put("value", 42);

        // Redirect System.out to capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Handle the event
        handler.handleEvent(resource);

        // Allow some time for the handler to process the event
        Thread.sleep(100);

        String output = outContent.toString();
        assertTrue(output.contains("Processed event"));

        // Reset System.out to its original stream
        System.setOut(System.out);
    }
}
