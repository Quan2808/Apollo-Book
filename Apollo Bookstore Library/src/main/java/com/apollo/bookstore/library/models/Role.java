package com.apollo.bookstore.library.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}