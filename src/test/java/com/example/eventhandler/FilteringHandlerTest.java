package com.example.eventhandler;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class FilteringHandlerTest {
    private FilteringHandler handler;

    @Before
    public void setUp() {
        handler = new FilteringHandler(resource -> "int".equals(resource.get("datatype")));
    }

    @Test
    public void testHandleEvent() {
        Map<String, Object> resource = new HashMap<>();
        resource.put("name", "TestResource");
        resource.put("timestamp", "2024-01-01T00:00:00Z");
        resource.put("datatype", "int");
        resource.put("value", 42);

        // Redirect System.out to capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        handler.handleEvent(resource);

        String output = outContent.toString();
        assertTrue(output.contains("Filtered event"));

        // Reset System.out to its original stream
        System.setOut(System.out);
    }

    @Test
    public void testHandleEventNonMatching() {
        Map<String, Object> resource = new HashMap<>();
        resource.put("name", "TestResource");
        resource.put("timestamp", "2024-01-01T00:00:00Z");
        resource.put("datatype", "string");
        resource.put("value", "test");

        // Redirect System.out to capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        handler.handleEvent(resource);

        String output = outContent.toString();
        assertFalse(output.contains("Filtered event"));

        // Reset System.out to its original stream
        System.setOut(System.out);
    }
}
