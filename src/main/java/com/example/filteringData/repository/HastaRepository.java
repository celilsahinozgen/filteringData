package com.example.filteringData.repository;

import com.example.filteringData.model.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaRepository extends JpaRepository<Hasta,Long> {
}
