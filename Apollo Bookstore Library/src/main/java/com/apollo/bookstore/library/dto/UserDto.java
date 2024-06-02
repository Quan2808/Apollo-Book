package com.apollo.bookstore.library.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Size(min = 3, max = 10, message = "First name contains 3-10 characters")
    private String firstName;

    @Size(min = 3, max = 10, message = "Last name contains 3-10 characters")
    private String lastName;

    @Size(min = 8, max = 24, message = "Username contains 8-24 characters")
    private String username;

    @Size(min = 8, max = 24, message = "Username contains 8-24 characters")
    private String email;

    @Size(min = 8, max = 24, message = "Password contains 8-24 characters")
    private String password;

    @Size(min = 10, max = 15, message = "Phone number contains 10-15 characters")
    private String phoneNumber;

    private String confirmPassword;

    private String city;

    private String country;

}
