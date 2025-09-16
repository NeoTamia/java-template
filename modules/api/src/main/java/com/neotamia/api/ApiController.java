package com.neotamia.api;

import com.neotamia.core.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * API controller that uses core services.
 */
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private final CoreService coreService;
    
    public ApiController() {
        this.coreService = new CoreService();
        logger.info("ApiController initialized");
    }
    
    public String handleRequest(String request) {
        logger.info("Handling request: {}", request);
        coreService.processData(request);
        return coreService.getMessage();
    }
}