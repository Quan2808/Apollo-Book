package com.apollo.bookstore.entities;

import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

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
