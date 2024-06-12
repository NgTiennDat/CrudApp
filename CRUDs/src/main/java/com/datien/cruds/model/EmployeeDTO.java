package com.datien.cruds.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record EmployeeDTO(
        @NotEmpty(message = "Firstname should not be empty.")
        String firstname,
        @NotEmpty(message = "Lastname should not be empty.")
        String lastname,
        @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Please, provide a valid email!")
        String email,
        Integer companyId
    ) {

}
