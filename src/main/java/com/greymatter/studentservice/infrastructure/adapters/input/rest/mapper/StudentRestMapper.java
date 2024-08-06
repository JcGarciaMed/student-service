package com.greymatter.studentservice.infrastructure.adapters.input.rest.mapper;


import com.greymatter.studentservice.domain.model.Student;
import com.greymatter.studentservice.infrastructure.adapters.input.rest.model.request.StudentCreationRequest;
import com.greymatter.studentservice.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {
    Student toStudent(StudentCreationRequest studentCreationRequest);
    StudentResponse toStudentCreationResponse(Student student);
    List<StudentResponse> toStudentCreationResponseList(List<Student> students);
}
