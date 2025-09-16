package com.neotamia.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiControllerTest {
    
    private ApiController apiController;
    
    @BeforeEach
    void setUp() {
        apiController = new ApiController();
    }
    
    @Test
    void testHandleRequest() {
        String response = apiController.handleRequest("test request");
        assertNotNull(response);
        assertEquals("Hello from Core Service!", response);
    }
    
    @Test
    void testHandleRequestWithNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> apiController.handleRequest(null));
    }
}