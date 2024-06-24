package com.example.eventhandler;

import java.util.Map;
import java.util.function.Predicate;

public class FilteringHandler implements ResourceEventHandler {
    private final Predicate<Map<String, Object>> filter;

    public FilteringHandler(Predicate<Map<String, Object>> filter) {
        this.filter = filter;
    }

    @Override
    public void handleEvent(Map<String, Object> resource) {
        if (filter.test(resource)) {
            System.out.println("Filtered event: " + resource);
        }
    }
}
