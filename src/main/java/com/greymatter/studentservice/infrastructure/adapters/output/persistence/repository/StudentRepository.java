package com.greymatter.studentservice.infrastructure.adapters.output.persistence.repository;

import com.greymatter.studentservice.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
