package com.greymatter.studentservice.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreationRequest {

    @NotBlank(message = "Field First Name cannot be empty or null")
    private String firstName;
    @NotEmpty(message = "Field Last Name cannot be empty or null")
    private String lastName;
    @NotNull(message = "Field age cannot be null")
    private Integer age;
    @NotBlank(message = "Field address cannot be null")
    private String address;
}
