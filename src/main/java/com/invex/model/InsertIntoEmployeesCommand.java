package com.invex.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsertIntoEmployeesCommand {

  private static final String INSERT_INTO_EMPLOYEES=
      """
      INSERT INTO employees
      (first_name, second_name, last_name, second_last_name, age, gender, 
      date_burn, job, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
      """;
  public static String read(){
      return INSERT_INTO_EMPLOYEES;
  }
}
