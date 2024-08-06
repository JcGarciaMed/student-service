package com.greymatter.studentservice.infrastructure.adapters.input.rest;

import com.greymatter.studentservice.application.ports.input.StudentServicePort;
import com.greymatter.studentservice.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.greymatter.studentservice.infrastructure.adapters.input.rest.model.request.StudentCreationRequest;
import com.greymatter.studentservice.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServicePort studentService;
    private final StudentRestMapper mapper;

    @GetMapping("/v1/api")
    public List<StudentResponse> findAll() {
        return mapper.toStudentCreationResponseList(studentService.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return mapper.toStudentCreationResponse(studentService.findById(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreationRequest studentRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toStudentCreationResponse(studentService.save(mapper.toStudent(studentRequest))));
    }

    @PutMapping("/v1/api/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id, @Valid @RequestBody StudentCreationRequest studentRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.toStudentCreationResponse(studentService.update(id, mapper.toStudent(studentRequest))));
    }

    @DeleteMapping("/v1/api/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }

}
