package com.arzuahmed.student.controller;

import com.arzuahmed.student.model.entity.StudentEntity;
import com.arzuahmed.student.model.request.StudentRequest;
import com.arzuahmed.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentControlller {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentByID(@PathVariable Long id) {
        StudentEntity studentById = studentService.findStudenById(id);
        return ResponseEntity.ok(studentById);
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudensts();
    }

    @PostMapping
    public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentRequest studentRequest) {

        return ResponseEntity.ok(studentService.saveStudent(studentRequest));
    }

    @PutMapping
    public ResponseEntity<StudentEntity> updateStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(studentRequest));
    }

    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllStudents() {
        List<StudentEntity> allStudensts = studentService.getAllStudensts();
        studentService.deleteAll(allStudensts);
    }
}
