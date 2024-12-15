package com.example.contextual_ai_ads_platform.controller;

import com.example.contextual_ai_ads_platform.entity.Ad;
import com.example.contextual_ai_ads_platform.service.AdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing advertisements.
 * Exposes endpoints for creating, retrieving, updating, and deleting Ads.
 *
 * @author anuragdeb
 *
 */
@RestController
@RequestMapping("/ads")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping
    public Ad createAd(@RequestParam String headline,
                       @RequestParam String description,
                       @RequestParam String keywords) {
        return adService.createAd(headline, description, keywords);
    }

    @GetMapping
    public List<Ad> getAllAds() {
        return adService.getAllAds();
    }

    @GetMapping("/{id}")
    public Ad getAdById(@PathVariable Long id) {
        return adService.getAdById(id);
    }

    @PutMapping("/{id}")
    public Ad updateAd(@PathVariable Long id,
                       @RequestParam String headline,
                       @RequestParam String description,
                       @RequestParam String keywords) {
        return adService.updateAd(id, headline, description, keywords);
    }

    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
    }
}
