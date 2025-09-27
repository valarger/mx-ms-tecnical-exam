package com.invex.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SelectByIdQuery {

  private  static final String SELECT_BY_ID_QUERY = 
      """
         SELECT * FROM employees WHERE id = ?;
      """;

  public static String read() {
    return SELECT_BY_ID_QUERY; 
  }
}
