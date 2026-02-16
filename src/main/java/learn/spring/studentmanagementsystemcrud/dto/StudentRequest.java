package learn.spring.studentmanagementsystemcrud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentRequest {

    @NotBlank(message = "First name is required")
    private String fName;

    @NotBlank(message = "Last name is required")
    private String lName;

    @Email(message = "Invalid email format")
    private String email;

    // getters + setters
}
