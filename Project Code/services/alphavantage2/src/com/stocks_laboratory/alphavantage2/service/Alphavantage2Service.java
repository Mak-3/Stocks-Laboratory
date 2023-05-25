package com.stocks_laboratory.alphavantage2.service;


import com.stocks_laboratory.alphavantage2.model.*;
import com.stocks_laboratory.alphavantage2.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface Alphavantage2Service {

  /**
   * 
   * 
    * @param apikey apikey (optional)
    * @param function function (optional)
    * @param tickers tickers (optional)
   * @return RootResponse
   */
  @RequestLine("GET /query?apikey={apikey}&function={function}&tickers={tickers}")
  @Headers({
    "Accept: application/json",  })
  RootResponse invoke(@Param("apikey") String apikey, @Param("function") String function, @Param("tickers") String tickers);


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
     *   <li>apikey - apikey (optional)</li>
     *   <li>function - function (optional)</li>
     *   <li>tickers - tickers (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /query?apikey={apikey}&function={function}&tickers={tickers}")
    @Headers({
    "Accept: application/json",    })
    RootResponse invoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
