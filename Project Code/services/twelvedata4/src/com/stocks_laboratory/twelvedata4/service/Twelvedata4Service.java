package com.stocks_laboratory.twelvedata4.service;


import com.stocks_laboratory.twelvedata4.model.*;
import com.stocks_laboratory.twelvedata4.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface Twelvedata4Service {

  /**
   * 
   * 
    * @param symbol symbol (optional)
    * @param apikey apikey (optional)
    * @param source source (optional)
   * @return RootResponse
   */
  @RequestLine("GET /quote?symbol={symbol}&apikey={apikey}&source={source}")
  @Headers({
    "Accept: application/json",  })
  RootResponse invoke(@Param("symbol") String symbol, @Param("apikey") String apikey, @Param("source") String source);


    /**
     * 
     * 
     * Note, this is equivalent to the other <code>invoke</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link InvokeQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>symbol - symbol (optional)</li>
     *   <li>apikey - apikey (optional)</li>
     *   <li>source - source (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /quote?symbol={symbol}&apikey={apikey}&source={source}")
    @Headers({
    "Accept: application/json",    })
    RootResponse invoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
