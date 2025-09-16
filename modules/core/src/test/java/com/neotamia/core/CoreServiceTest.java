package com.neotamia.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreServiceTest {
    
    private CoreService coreService;
    
    @BeforeEach
    void setUp() {
        coreService = new CoreService();
    }
    
    @Test
    void testGetMessage() {
        String message = coreService.getMessage();
        assertNotNull(message);
        assertEquals("Hello from Core Service!", message);
    }
    
    @Test
    void testProcessDataWithValidInput() {
        assertDoesNotThrow(() -> coreService.processData("valid data"));
    }
    
    @Test
    void testProcessDataWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> coreService.processData(null));
    }
    
    @Test
    void testProcessDataWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> coreService.processData(""));
        assertThrows(IllegalArgumentException.class, () -> coreService.processData("   "));
    }
}