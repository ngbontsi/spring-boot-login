package com.bezkoder.spring.login.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class UserInformation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 150)
  private String firstname;
  @NotBlank
  @Size(max = 150)
  private String lastname;

  @Size(max = 120)
  private String post;
  @Size(max = 20)
  private String phone;

  @JoinTable(name = "media",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "media_id"))
  private Set<String> imageId;
  @JoinTable(name = "parent_relations",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "parent_id"))
  private Set<Person> parent;

  public UserInformation() {
  }

  public UserInformation( String firstname, String lastname, String post, String phone, Set<String> imageId, Set<Person> parent) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.post = post;
    this.phone = phone;
    this.imageId = imageId;
    this.parent = parent;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Set<String> getImageId() {
    return imageId;
  }

  public void setImageId(Set<String> imageId) {
    this.imageId = imageId;
  }

  public Set<Person> getParent() {
    return parent;
  }

  public void setParent(Set<Person> parent) {
    this.parent = parent;
  }
}
