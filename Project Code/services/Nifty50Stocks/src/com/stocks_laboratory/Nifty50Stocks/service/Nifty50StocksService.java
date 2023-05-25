package com.stocks_laboratory.Nifty50Stocks.service;


import com.stocks_laboratory.Nifty50Stocks.model.*;
import com.stocks_laboratory.Nifty50Stocks.model.ResponseRootResponseROOTEntryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface Nifty50StocksService {

  /**
   * 
   * 
    * @param x_RapidAPI_Key X-RapidAPI-Key (optional)
    * @param x_RapidAPI_Host X-RapidAPI-Host (optional)
    * @param Indices Indices (optional)
   * @return List&lt;ResponseRootResponseROOTEntryItem&gt;
   */
  @RequestLine("GET /price?Indices={Indices}")
  @Headers({
    "Accept: application/json",
    "X-RapidAPI-Key: {x_RapidAPI_Key}",

    "X-RapidAPI-Host: {x_RapidAPI_Host}"  })
  List<ResponseRootResponseROOTEntryItem> invoke(@Param("x_RapidAPI_Key") String x_RapidAPI_Key, @Param("x_RapidAPI_Host") String x_RapidAPI_Host, @Param("Indices") String Indices);


    /**
     * 
     * 
     * Note, this is equivalent to the other <code>invoke</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link InvokeQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param x_RapidAPI_Key X-RapidAPI-Key (optional)
     * @param x_RapidAPI_Host X-RapidAPI-Host (optional)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>Indices - Indices (optional)</li>
     *   </ul>
     * @return List&lt;ResponseRootResponseROOTEntryItem&gt;
     */
    @RequestLine("GET /price?Indices={Indices}")
    @Headers({
    "Accept: application/json",
        "X-RapidAPI-Key: {x_RapidAPI_Key}",

        "X-RapidAPI-Host: {x_RapidAPI_Host}"    })
    List<ResponseRootResponseROOTEntryItem> invoke
    (@Param("x_RapidAPI_Key") String x_RapidAPI_Key, @Param("x_RapidAPI_Host") String x_RapidAPI_Host, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
