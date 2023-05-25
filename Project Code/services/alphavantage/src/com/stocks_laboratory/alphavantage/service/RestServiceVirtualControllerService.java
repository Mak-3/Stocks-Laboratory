package com.stocks_laboratory.alphavantage.service;


import com.stocks_laboratory.alphavantage.model.*;
import com.stocks_laboratory.alphavantage.model.RootResponse;

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
    * @param symbol symbol (optional)
    * @param apikey apikey (optional)
    * @param function function (optional)
   * @return RootResponse
   */
  @RequestLine("GET /query?symbol={symbol}&apikey={apikey}&function={function}")
  @Headers({
    "Accept: application/json",  })
  RootResponse restServiceVirtualControllerInvoke(@Param("symbol") String symbol, @Param("apikey") String apikey, @Param("function") String function);


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
     *   <li>symbol - symbol (optional)</li>
     *   <li>apikey - apikey (optional)</li>
     *   <li>function - function (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /query?symbol={symbol}&apikey={apikey}&function={function}")
    @Headers({
    "Accept: application/json",    })
    RootResponse restServiceVirtualControllerInvoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
