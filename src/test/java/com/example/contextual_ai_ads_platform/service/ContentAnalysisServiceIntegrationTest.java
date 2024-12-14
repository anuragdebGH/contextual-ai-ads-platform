package com.example.contextual_ai_ads_platform.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for ContentAnalysisService with the Python API.
 *
 * @author anuragdeb
 *
 */
public class ContentAnalysisServiceIntegrationTest {

    private final ContentAnalysisService contentAnalysisService = new ContentAnalysisService();

    @Test
    void analyzeContentShouldReturnPositive() {
        String text = "This is a good day";
        String sentiment = contentAnalysisService.analyzeContent(text);
        assertEquals("positive", sentiment, "Sentiment should be 'positive' for input containing 'good'");
    }

    @Test
    void analyzeContentShouldReturnNeutral() {
        String text = "This is a normal day";
        String sentiment = contentAnalysisService.analyzeContent(text);
        assertEquals("neutral", sentiment, "Sentiment should be 'neutral' for input not containing 'good'");
    }
}
