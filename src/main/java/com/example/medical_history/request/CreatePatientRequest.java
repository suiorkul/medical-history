package com.example.medical_history.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientRequest {

    String firstName;

    String lastName;

    Double weight;

    Double height;

    Integer bloodType;

    Timestamp dob;

    List<String> diseases;

}
