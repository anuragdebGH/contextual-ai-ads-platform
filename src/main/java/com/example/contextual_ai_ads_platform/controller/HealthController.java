package com.example.contextual_ai_ads_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * The HealthController provides a simple health check endpoint to verify that
 * the application is running and responsive.
 *
 * @author anuragdeb
 *
 */

@RestController
public class HealthController {

    /**
     * Returns a simple JSON response indicating the application's health status.
     *
     * @return A Map with key "status" and value "UP".
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        // Returning a Map automatically serializes to JSON.
        // { "status": "UP" }
        return Map.of("status", "UP");
    }

}
