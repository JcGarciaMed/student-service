package com.greymatter.studentservice.infrastructure.adapters.output.persistence;

import com.greymatter.studentservice.application.ports.output.StudentPersistencePort;
import com.greymatter.studentservice.domain.model.Student;
import com.greymatter.studentservice.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.greymatter.studentservice.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id).map(mapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return mapper.toStudentList(studentRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(studentRepository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
