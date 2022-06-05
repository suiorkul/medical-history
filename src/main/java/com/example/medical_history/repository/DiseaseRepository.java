package com.example.medical_history.repository;

import com.example.medical_history.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, UUID> {

    List<Disease> findAllByNameIn(List<String> names);

}
