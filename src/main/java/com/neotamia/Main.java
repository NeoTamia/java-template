package com.neotamia;

import com.neotamia.api.ApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main application entry point.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        logger.info("Starting Java Template Application");
        
        ApiController controller = new ApiController();
        String response = controller.handleRequest("Hello World");
        
        System.out.println("Response: " + response);
        logger.info("Application completed successfully");
    }
}