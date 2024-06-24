package com.example.eventhandler;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

public class BufferingAndReorderingHandler implements ResourceEventHandler {
    private final PriorityBlockingQueue<Map<String, Object>> buffer = new PriorityBlockingQueue<>(
            100, Comparator.comparing(o -> (Date) o.get("timestamp")));

    @Override
    public void handleEvent(Map<String, Object> resource) {
        buffer.offer(resource);
        processBuffer();
    }

    private void processBuffer() {
        while (!buffer.isEmpty() && buffer.peek().get("timestamp").equals(getCurrentTimestamp())) {
            Map<String, Object> event = buffer.poll();
            System.out.println("Processed event: " + event);
        }
    }

    private Date getCurrentTimestamp() {
        return new Date();
    }
}
