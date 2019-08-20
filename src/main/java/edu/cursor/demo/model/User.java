package edu.cursor.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(name = "email",nullable = false)
    @Email
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "USERS_ROLE",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}