package com.neotamia.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Core service providing common functionality.
 */
public class CoreService {
    private static final Logger logger = LoggerFactory.getLogger(CoreService.class);
    
    public String getMessage() {
        logger.info("Getting message from CoreService");
        return "Hello from Core Service!";
    }
    
    public void processData(String data) {
        logger.info("Processing data: {}", data);
        // Simulate some processing
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");
        }
    }
}