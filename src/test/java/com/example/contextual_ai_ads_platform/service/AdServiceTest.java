package com.example.contextual_ai_ads_platform.service;

import com.example.contextual_ai_ads_platform.entity.Ad;
import com.example.contextual_ai_ads_platform.repository.AdRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Unit tests for AdService to verify business logic and interactions with AdRepository.
 *
 * @author anuragdeb
 */
public class AdServiceTest {

    @Mock
    private AdRepository adRepository;

    @InjectMocks
    private AdService adService;

    public AdServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAd() {
        // Arrange
        Ad ad = new Ad("Big Sale", "50% off on all items", "sale,discount");
        when(adRepository.save(any(Ad.class))).thenReturn(ad);

        // Act
        Ad createdAd = adService.createAd("Big Sale", "50% off on all items", "sale,discount");

        // Assert
        assertThat(createdAd).isNotNull();
        assertThat(createdAd.getHeadline()).isEqualTo("Big Sale");
        verify(adRepository, times(1)).save(any(Ad.class));
    }

    @Test
    void testGetAdById() {
        // Arrange
        Ad ad = new Ad("Limited Offer", "Offer ends today", "offer,discount");
        ad.setId(1L);
        when(adRepository.findById(1L)).thenReturn(Optional.of(ad));

        // Act
        Ad retrievedAd = adService.getAdById(1L);

        // Assert
        assertThat(retrievedAd).isNotNull();
        assertThat(retrievedAd.getHeadline()).isEqualTo("Limited Offer");
        verify(adRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteAd() {
        // Arrange
        Long adId = 1L;
        doNothing().when(adRepository).deleteById(adId);

        // Act
        adService.deleteAd(adId);

        // Assert
        verify(adRepository, times(1)).deleteById(adId);
    }
}
