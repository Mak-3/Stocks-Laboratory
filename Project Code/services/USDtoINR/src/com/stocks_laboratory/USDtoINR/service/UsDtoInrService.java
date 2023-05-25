package com.stocks_laboratory.USDtoINR.service;


import com.stocks_laboratory.USDtoINR.model.*;
import com.stocks_laboratory.USDtoINR.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface UsDtoInrService {

  /**
   * 
   * 
    * @param x_RapidAPI_Host X-RapidAPI-Host (optional)
    * @param x_RapidAPI_Key X-RapidAPI-Key (optional)
    * @param amount amount (optional)
    * @param want want (optional)
    * @param have have (optional)
   * @return RootResponse
   */
  @RequestLine("GET /convertcurrency?amount={amount}&want={want}&have={have}")
  @Headers({
    "Accept: application/json",
    "X-RapidAPI-Host: {x_RapidAPI_Host}",

    "X-RapidAPI-Key: {x_RapidAPI_Key}"  })
  RootResponse invoke(@Param("x_RapidAPI_Host") String x_RapidAPI_Host, @Param("x_RapidAPI_Key") String x_RapidAPI_Key, @Param("amount") String amount, @Param("want") String want, @Param("have") String have);


    /**
     * 
     * 
     * Note, this is equivalent to the other <code>invoke</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link InvokeQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param x_RapidAPI_Host X-RapidAPI-Host (optional)
     * @param x_RapidAPI_Key X-RapidAPI-Key (optional)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>amount - amount (optional)</li>
     *   <li>want - want (optional)</li>
     *   <li>have - have (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /convertcurrency?amount={amount}&want={want}&have={have}")
    @Headers({
    "Accept: application/json",
        "X-RapidAPI-Host: {x_RapidAPI_Host}",

        "X-RapidAPI-Key: {x_RapidAPI_Key}"    })
    RootResponse invoke
    (@Param("x_RapidAPI_Host") String x_RapidAPI_Host, @Param("x_RapidAPI_Key") String x_RapidAPI_Key, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
