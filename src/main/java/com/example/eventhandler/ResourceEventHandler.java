package com.example.eventhandler;
import java.util.Map;

public interface ResourceEventHandler {
    void handleEvent(Map<String, Object> resource);
}
