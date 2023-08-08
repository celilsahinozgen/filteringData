package com.example.filteringData.repository;


import com.example.filteringData.model.ArabaMarkalari;
import com.example.filteringData.model.Filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArabaMarkalariRepository  extends JpaRepository<ArabaMarkalari, String > ,  JpaSpecificationExecutor<ArabaMarkalari> {


    List<ArabaMarkalari> findAll(Specification<ArabaMarkalari> arabaMarkalariSpecification);
}
