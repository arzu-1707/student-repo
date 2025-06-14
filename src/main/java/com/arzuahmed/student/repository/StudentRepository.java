package com.arzuahmed.student.repository;

import com.arzuahmed.student.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
