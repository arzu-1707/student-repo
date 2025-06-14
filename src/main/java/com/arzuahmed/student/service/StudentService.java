package com.arzuahmed.student.service;

import com.arzuahmed.student.model.entity.StudentEntity;
import com.arzuahmed.student.model.request.StudentRequest;
import com.arzuahmed.student.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;
    
    public StudentEntity findStudenById(Long id) {
        Optional<StudentEntity> studentById = studentRepository.findById(id);
        return studentById.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public List<StudentEntity> getAllStudensts() {
        return studentRepository.findAll();
    }

    public StudentEntity saveStudent(StudentRequest studentRequest) {
        StudentEntity newStudent = new StudentEntity();
        if (studentRequest.getAge() != null) {
            newStudent.setAge(studentRequest.getAge());
        }
        if (studentRequest.getName() != null) {
            newStudent.setName(studentRequest.getName());
        }
        if (studentRequest.getEmail() != null) {
            newStudent.setEmail(studentRequest.getEmail());
        }
        return studentRepository.save(newStudent);
    }


    public StudentEntity updateStudent(StudentRequest studentRequest) {
        StudentEntity existedStudent = studentRepository.findById(studentRequest.getId())
                .orElseThrow(()-> new RuntimeException("Student not found"));
        existedStudent.setName(studentRequest.getName());
        existedStudent.setAge(studentRequest.getAge());
        existedStudent.setEmail(studentRequest.getEmail());
        return studentRepository.save(existedStudent);
    }
    

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAll(List<StudentEntity> students) {
        studentRepository.deleteAll(students);
    }
}
