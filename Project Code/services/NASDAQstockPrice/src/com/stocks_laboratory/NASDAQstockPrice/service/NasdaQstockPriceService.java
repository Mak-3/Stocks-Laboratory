package com.stocks_laboratory.NASDAQstockPrice.service;


import com.stocks_laboratory.NASDAQstockPrice.model.*;
import com.stocks_laboratory.NASDAQstockPrice.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface NasdaQstockPriceService {

  /**
   * 
   * 
    * @param name  (required)
    * @param x_RapidAPI_Key X-RapidAPI-Key (optional)
    * @param x_RapidAPI_Host X-RapidAPI-Host (optional)
   * @return RootResponse
   */
  @RequestLine("GET /{name}")
  @Headers({
    "Accept: application/json",
    "X-RapidAPI-Key: {x_RapidAPI_Key}",

    "X-RapidAPI-Host: {x_RapidAPI_Host}"  })
  RootResponse invoke(@Param("name") String name, @Param("x_RapidAPI_Key") String x_RapidAPI_Key, @Param("x_RapidAPI_Host") String x_RapidAPI_Host);

}
