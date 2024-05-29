package com.apollo.bookstore.entities;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "phone_number"),
    @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", 
               joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

}
