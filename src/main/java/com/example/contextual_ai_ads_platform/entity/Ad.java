package com.example.contextual_ai_ads_platform.entity;

import jakarta.persistence.*;

/**
 * Represents an advertisement entity in the database.
 * This entity is used to store and manage details about advertisements,
 * including their headline, description, and associated keywords.
 *
 * @author anuragdeb
 *
 */

@Entity
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String headline;

    private String description;

    private String keywords;

    public Ad() {}

    public Ad(String headline, String description, String keywords) {
        this.headline = headline;
        this.description = description;
        this.keywords = keywords;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
