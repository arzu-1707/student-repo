package com.arzuahmed.student.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
