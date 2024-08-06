package com.greymatter.studentservice.application.service;

import com.greymatter.studentservice.application.ports.input.StudentServicePort;
import com.greymatter.studentservice.application.ports.output.StudentPersistencePort;
import com.greymatter.studentservice.domain.exception.StudentNotFoundException;
import com.greymatter.studentservice.domain.model.Student;
import lombok.RequiredArgsConstructor;


import java.util.List;

//@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort persistencePort;

    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id).map(savedStudent->save(student)).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.findById(id).orElseThrow(StudentNotFoundException::new);
        persistencePort.deleteById(id);
    }
}
