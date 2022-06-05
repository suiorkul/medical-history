package com.example.medical_history.service.impl;

import com.example.medical_history.domain.Assignment;
import com.example.medical_history.model.Role;
import com.example.medical_history.repository.AssignmentRepository;
import com.example.medical_history.repository.UserRepository;
import com.example.medical_history.request.CreateAssignmentRequest;
import com.example.medical_history.request.CreateMedAssistanceRequest;
import com.example.medical_history.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;

    @Override
    public Assignment createAssignment(CreateAssignmentRequest request) {
        return assignmentRepository.save(Assignment.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .isCompleted(false)
                        .meds(userRepository
                                .findAllByRoleIsAndUsernameIn(Role.MED_ASSISTANT, request.getMedNames()))
                .build());
    }

    @Override
    public Assignment complete(UUID id) {
        return assignmentRepository.findById(id)
                .map(assignment -> {
                    assignment.setIsCompleted(true);
                    return assignmentRepository.save(assignment);
                }).orElseThrow(() -> new RuntimeException("Извините, не удалось найти подобное поручение"));
    }


}