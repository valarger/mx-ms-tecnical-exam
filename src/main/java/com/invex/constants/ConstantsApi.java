package com.invex.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantsApi {
  
  /**
   * Valor externalizado para indicar el path base para interceptar peticiones.
   */
  public static final String BASE_PATH = "${constants.api.basePath}";

  /**
   *ParametroId de busqueda
   */
  public static final String ID_FIND = "${constants.api.idParam}";
  
  /**
   *Search endpoint de busqueda
   */
  public static final String SEARCH_API = "${constants.api.search}";
  
  
}
