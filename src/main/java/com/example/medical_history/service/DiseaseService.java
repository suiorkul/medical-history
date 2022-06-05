package com.example.medical_history.service;

import com.example.medical_history.domain.Disease;
import com.example.medical_history.request.CreateDiseaseRequest;
import org.springframework.stereotype.Service;

@Service
public interface DiseaseService {

    Disease createDisease(CreateDiseaseRequest request);

}
