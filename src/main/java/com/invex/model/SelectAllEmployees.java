package com.invex.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SelectAllEmployees {
  
  private  static final String SELECT_ALL_EMPLOYEES= 
      """
         SELECT * FROM employees;
      """;

  public static String read() {
    return SELECT_ALL_EMPLOYEES; 
  }
}
