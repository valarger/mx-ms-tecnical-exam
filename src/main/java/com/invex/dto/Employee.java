package com.invex.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

     Long id;
     String firstName;
     String middleName;
     String lastName;
     String mothersLastName;
     Integer age;
     String gender;
     LocalDate dateOfBirth;
     String position;
     LocalDateTime dateOfStartInSystem;
     boolean active;
    
}
