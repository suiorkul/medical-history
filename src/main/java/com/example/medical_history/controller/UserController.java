package com.example.medical_history.controller;

import com.example.medical_history.domain.Disease;
import com.example.medical_history.domain.User;
import com.example.medical_history.request.CreateMedAssistanceRequest;
import com.example.medical_history.request.CreatePatientRequest;
import com.example.medical_history.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/create-patient")
    public ResponseEntity<?> createPatient(@RequestBody CreatePatientRequest request) {
        try {
            return new ResponseEntity<>(userService.createPatient(request), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/create-medassistance")
    public ResponseEntity<?> createMedAssistance(@RequestBody CreateMedAssistanceRequest request) {
        try {
            return new ResponseEntity<>(userService.createMedAssistant(request), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/get-allpatient")
    public ResponseEntity<?> getAllPatients(){
        try {
            return new ResponseEntity<>(userService.getAllPatients(), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/get-byfirstname")
    public ResponseEntity<?> getByFirstName(@RequestParam String firstName) {
        try {
            return new ResponseEntity<>(userService.getByFirstName(firstName), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/get-bylastname")
    public ResponseEntity<?> getByLastName(@RequestParam String lastName) {
        try {
            return new ResponseEntity<>(userService.getByFirstName(lastName), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/get-bydiseases")
    public ResponseEntity<?> getByDiseases(@RequestParam String disease) {
        try {
            return new ResponseEntity<>(userService.getByDiseases(disease), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
