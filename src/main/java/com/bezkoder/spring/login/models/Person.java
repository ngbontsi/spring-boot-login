package com.bezkoder.spring.login.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
@Data
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 20)
  private String firstname;
  @Column(length = 20)
  private String lastname;
  @Column
  @ManyToOne
  @JoinColumn(name = "child_id")
  private Person child;
  @Column
  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Person parent;

  @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
  private List<Person> children;
  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<Person> parents;

}