package com.example.medical_history.controller;

import com.example.medical_history.request.CreateDiseaseRequest;
import com.example.medical_history.request.CreateMedAssistanceRequest;
import com.example.medical_history.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/disease")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/create-disease")
    public ResponseEntity<?> createDisease(@RequestBody CreateDiseaseRequest request) {
        try {
            return new ResponseEntity<>(diseaseService.createDisease(request), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

}
