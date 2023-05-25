package com.stocks_laboratory.twelvedata6.service;


import com.stocks_laboratory.twelvedata6.model.*;
import com.stocks_laboratory.twelvedata6.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface Twelvedata6Service {

  /**
   * 
   * 
    * @param symbol symbol (optional)
    * @param outputsize outputsize (optional)
    * @param apikey apikey (optional)
    * @param interval interval (optional)
    * @param source source (optional)
   * @return RootResponse
   */
  @RequestLine("GET /time_series?symbol={symbol}&outputsize={outputsize}&apikey={apikey}&interval={interval}&source={source}")
  @Headers({
    "Accept: application/json",  })
  RootResponse invoke(@Param("symbol") String symbol, @Param("outputsize") String outputsize, @Param("apikey") String apikey, @Param("interval") String interval, @Param("source") String source);


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
     *   <li>outputsize - outputsize (optional)</li>
     *   <li>apikey - apikey (optional)</li>
     *   <li>interval - interval (optional)</li>
     *   <li>source - source (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /time_series?symbol={symbol}&outputsize={outputsize}&apikey={apikey}&interval={interval}&source={source}")
    @Headers({
    "Accept: application/json",    })
    RootResponse invoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
