package com.greymatter.studentservice.infrastructure.config;

import com.greymatter.studentservice.application.ports.output.StudentPersistencePort;
import com.greymatter.studentservice.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StudentConfig {

    private final StudentPersistencePort persistencePort;


    @Bean
    public StudentService studentService() {
        return new StudentService(persistencePort);
    }
}
