package com.example.contextual_ai_ads_platform.controller;

import com.example.contextual_ai_ads_platform.entity.Ad;
import com.example.contextual_ai_ads_platform.service.AdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for AdController to verify REST API endpoints and request handling.
 *
 * @author anuragdeb
 */
@WebMvcTest(AdController.class)
public class AdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdService adService;

    @Test
    void testGetAllAds() throws Exception {
        // Arrange
        Ad ad = new Ad("Big Sale", "50% off on all items", "sale,discount");
        when(adService.getAllAds()).thenReturn(List.of(ad));

        // Act & Assert
        mockMvc.perform(get("/ads"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].headline").value("Big Sale"));
    }

    @Test
    void testCreateAd() throws Exception {
        // Arrange
        Ad ad = new Ad("Big Sale", "50% off on all items", "sale,discount");
        when(adService.createAd("Big Sale", "50% off on all items", "sale,discount")).thenReturn(ad);

        // Act & Assert
        mockMvc.perform(post("/ads")
                        .param("headline", "Big Sale")
                        .param("description", "50% off on all items")
                        .param("keywords", "sale,discount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.headline").value("Big Sale"));
    }

    @Test
    void testGetAdById() throws Exception {
        // Arrange
        Ad ad = new Ad("Limited Offer", "Offer ends today", "offer,discount");
        when(adService.getAdById(1L)).thenReturn(ad);

        // Act & Assert
        mockMvc.perform(get("/ads/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.headline").value("Limited Offer"));
    }
}
