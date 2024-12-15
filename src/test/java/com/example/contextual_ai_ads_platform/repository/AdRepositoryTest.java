package com.example.contextual_ai_ads_platform.repository;

import com.example.contextual_ai_ads_platform.entity.Ad;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for AdRepository to verify database operations.
 *
 * @author anuragdeb
 */
@DataJpaTest
public class AdRepositoryTest {

    @Autowired
    private AdRepository adRepository;

    @Test
    void testSaveAndFindAd() {
        // Arrange
        Ad ad = new Ad("Big Sale", "50% off on all items", "sale,discount");

        // Act
        Ad savedAd = adRepository.save(ad);

        // Assert
        assertThat(savedAd).isNotNull();
        assertThat(savedAd.getId()).isNotNull();
        assertThat(savedAd.getHeadline()).isEqualTo("Big Sale");

        // Retrieve all ads
        List<Ad> ads = adRepository.findAll();
        assertThat(ads).hasSize(1);
    }

    @Test
    void testDeleteAd() {
        // Arrange
        Ad ad = new Ad("Limited Offer", "Offer ends today", "offer,discount");
        Ad savedAd = adRepository.save(ad);

        // Act
        adRepository.deleteById(savedAd.getId());

        // Assert
        assertThat(adRepository.findById(savedAd.getId())).isEmpty();
    }
}
