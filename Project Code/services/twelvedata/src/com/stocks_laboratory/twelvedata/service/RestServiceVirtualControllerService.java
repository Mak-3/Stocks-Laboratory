package com.stocks_laboratory.twelvedata.service;


import com.stocks_laboratory.twelvedata.model.*;
import com.stocks_laboratory.twelvedata.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface RestServiceVirtualControllerService {

  /**
   * 
   * 
    * @param country country (optional)
    * @param apikey apikey (optional)
    * @param exchange exchange (optional)
    * @param source source (optional)
   * @return RootResponse
   */
  @RequestLine("GET /stocks?country={country}&apikey={apikey}&exchange={exchange}&source={source}")
  @Headers({
    "Accept: application/json",  })
  RootResponse restServiceVirtualControllerInvoke(@Param("country") String country, @Param("apikey") String apikey, @Param("exchange") String exchange, @Param("source") String source);


    /**
     * 
     * 
     * Note, this is equivalent to the other <code>restServiceVirtualControllerInvoke</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link RestServiceVirtualControllerInvokeQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>country - country (optional)</li>
     *   <li>apikey - apikey (optional)</li>
     *   <li>exchange - exchange (optional)</li>
     *   <li>source - source (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /stocks?country={country}&apikey={apikey}&exchange={exchange}&source={source}")
    @Headers({
    "Accept: application/json",    })
    RootResponse restServiceVirtualControllerInvoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
