package com.example.medical_history.service;

import com.example.medical_history.domain.Assignment;
import com.example.medical_history.request.CreateAssignmentRequest;
import com.example.medical_history.request.CreateMedAssistanceRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AssignmentService {
    Assignment createAssignment(CreateAssignmentRequest request);

    Assignment complete(UUID id);
}
