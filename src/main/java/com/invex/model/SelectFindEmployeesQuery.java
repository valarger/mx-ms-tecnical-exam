package com.invex.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SelectFindEmployeesQuery {
  
  private static final String SELECT_FIND_EMPLOYEE=
      """
          SELECT * FROM employees WHERE first_name LIKE ?;
      """;
  public static String read(){
      return SELECT_FIND_EMPLOYEE;
  }
}
