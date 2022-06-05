package com.example.medical_history.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAssignmentRequest {

    String title;

    String description;

    Boolean isCompleted;

    List<String> medNames;
}
