package com.spring.boot.validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //first name should not be null or empty
    @NotEmpty(message = "Fist name must not be empty")
    @Column(name = "first_name")
    private String firstName;
    //Last name should not be null or empty
    @NotEmpty(message = "Last name must not be empty")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = "Phone number must not be empty")
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    //email must not be empty or null
    // email must be valid email format

    @NotEmpty
    @Email(message = "email must be valid email")
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "password must be at least 8 characters")
    private String password;
}
