package com.bezkoder.spring.login.payload.request;

import com.bezkoder.spring.login.models.Person;
import com.bezkoder.spring.login.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class UserInformationRequest {


  @NotBlank
  private String firstname;
  @NotBlank
  private String lastname;
  private Person child;
  private Person parent;

}
