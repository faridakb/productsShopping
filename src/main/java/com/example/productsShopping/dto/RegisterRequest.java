package com.example.productsShopping.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.aspectj.bridge.IMessage;

@Data
public class RegisterRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50)
    private  String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 1, max = 50)
    private  String surname;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Email(message = "Username is required")
    @Size(min = 1, max = 50)
    private String username;

    @Email(message = "Password is required")
    @Size(min = 1)
    private String password;
}
