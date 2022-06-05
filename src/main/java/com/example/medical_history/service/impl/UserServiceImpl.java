package com.example.medical_history.service.impl;

import com.example.medical_history.domain.Disease;
import com.example.medical_history.domain.User;
import com.example.medical_history.model.Role;
import com.example.medical_history.repository.DiseaseRepository;
import com.example.medical_history.repository.UserRepository;
import com.example.medical_history.request.CreateMedAssistanceRequest;
import com.example.medical_history.request.CreatePatientRequest;
import com.example.medical_history.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DiseaseRepository diseaseRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Извините, но мы не нашли такой тип аккаунта или у вас неправильно \n" +
                "введены логин и/или пароль пожалуйста повторите"));
    }

    @Override
    public User createPatient(CreatePatientRequest request) {
        return userRepository.save(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .height(request.getHeight())
                .isActive(true)
                .weight(request.getWeight())
                .diseases(diseaseRepository.findAllByNameIn(request.getDiseases()))
                .bloodType(request.getBloodType())
                .role(Role.PATIENT).build());
    }

    @Override
    public User createMedAssistant(CreateMedAssistanceRequest request) {
        return userRepository.save(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .isActive(true)
                .salary(BigDecimal.valueOf(request.getSalary()))
                .role(Role.MED_ASSISTANT).build());
    }

    @Override
    public List<User> getAllPatients() {
        return userRepository.findAllByRoleIs(Role.PATIENT);
    }

    @Override
    public User getByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName).orElseThrow(() -> new RuntimeException("Извините, но мы не нашли такого пациента"));
    }

    @Override
    public User getByLastName(String lastName) {
        return userRepository.findByLastName(lastName).orElseThrow(() -> new RuntimeException("Извините, но мы не нашли такого пациента"));
    }

    @Override
    public List<User> getByDiseases(String diseases) {
        return userRepository.findAllByDiseases(diseaseRepository.findAll().stream().filter(disease -> diseases.contains(disease.getName())).collect(Collectors.toList()));
    }


}
