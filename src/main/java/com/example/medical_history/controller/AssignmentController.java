package com.example.medical_history.controller;

import com.example.medical_history.request.CreateAssignmentRequest;
import com.example.medical_history.request.CreateDiseaseRequest;
import com.example.medical_history.service.AssignmentService;
import com.example.medical_history.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/create-assignment")
    public ResponseEntity<?> createAssignment(@RequestBody CreateAssignmentRequest request) {
        try {
            return new ResponseEntity<>(assignmentService.createAssignment(request), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @GetMapping("/comlete")
    public ResponseEntity<?> complete(@RequestParam UUID id) {
        try {
            return new ResponseEntity<>(assignmentService.complete(id), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

}
