package com.example.medical_history.service;

import com.example.medical_history.domain.Disease;
import com.example.medical_history.domain.User;
import com.example.medical_history.request.CreateMedAssistanceRequest;
import com.example.medical_history.request.CreatePatientRequest;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    User createPatient(CreatePatientRequest request);

    User createMedAssistant(CreateMedAssistanceRequest request);

    List<User> getAllPatients();

    User getByFirstName(String firstName);

    User getByLastName(String lastName);

    List<User> getByDiseases(String diseases);

}
