package com.invex.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteByIdQuery {

  private static final String DELETE_BY_ID_QUERY = 
      """
          DELETE FROM employees WHERE id = ?;
      """;
      public static String read(){
      return DELETE_BY_ID_QUERY;
  }
}
