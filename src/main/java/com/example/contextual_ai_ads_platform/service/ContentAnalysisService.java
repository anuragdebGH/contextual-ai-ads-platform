package com.example.contextual_ai_ads_platform.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * A placeholder service for analyzing text content.
 * This service will eventually be replaced with a real NLP model integration.
 *
 * @author anuragdeb
 *
 */
@Service
public class ContentAnalysisService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String pythonApiUrl = "http://localhost:5000/analyze";

    /**
     * Sends the text to the Python API for analysis and retrieves the sentiment.
     *
     * @param text The text to analyze.
     * @return The sentiment (e.g., "positive", "neutral").
     */
    public String analyzeContent(String text) {
        try {
            Map<String, String> requestBody = Map.of("text", text);
            Map<String, String> response = restTemplate.postForObject(pythonApiUrl, requestBody, Map.class);
            return response != null ? response.get("sentiment") : "unknown";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
