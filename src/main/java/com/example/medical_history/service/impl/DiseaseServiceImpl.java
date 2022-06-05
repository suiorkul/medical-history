package com.example.medical_history.service.impl;

import com.example.medical_history.domain.Disease;
import com.example.medical_history.repository.DiseaseRepository;
import com.example.medical_history.request.CreateDiseaseRequest;
import com.example.medical_history.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;

    @Override
    public Disease createDisease(CreateDiseaseRequest request) {
        return diseaseRepository.save(Disease.builder()
                        .name(request.getName())
                        .treatment(request.getTreatment())
                .build());
    }



}
