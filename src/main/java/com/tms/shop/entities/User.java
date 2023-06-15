package com.tms.shop.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    @Pattern(regexp = "\\S+", message = "Spaces are not allowed")
    @NotEmpty(message = "Password must not be empty")
    @Column(name = "password")
    private String password;
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    @Column(name = "email")
    private String email;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}