package com.example.contextual_ai_ads_platform.service;

import com.example.contextual_ai_ads_platform.entity.Ad;
import com.example.contextual_ai_ads_platform.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for business logic and management of Ad entities.
 *
 * @author anuragdeb
 *
 */
@Service
public class AdService {

    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Ad createAd(String headline, String description, String keywords) {
        Ad ad = new Ad(headline, description, keywords);
        return adRepository.save(ad);
    }

    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    public Ad getAdById(Long id) {
        return adRepository.findById(id).orElseThrow(() -> new RuntimeException("Ad not found"));
    }

    public Ad updateAd(Long id, String headline, String description, String keywords) {
        Ad ad = getAdById(id);
        ad.setHeadline(headline);
        ad.setDescription(description);
        ad.setKeywords(keywords);
        return adRepository.save(ad);
    }

    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }
}
