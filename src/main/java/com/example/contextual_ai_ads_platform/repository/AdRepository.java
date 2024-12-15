package com.example.contextual_ai_ads_platform.repository;

import com.example.contextual_ai_ads_platform.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Ad entities in the database.
 *
 * @author anuragdeb
 *
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
}
