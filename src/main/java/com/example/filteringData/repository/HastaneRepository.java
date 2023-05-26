package com.example.filteringData.repository;

import com.example.filteringData.model.Hastane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaneRepository extends JpaRepository<Hastane, Long> {
}

