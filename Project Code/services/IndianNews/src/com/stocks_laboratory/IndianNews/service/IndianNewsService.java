package com.stocks_laboratory.IndianNews.service;


import com.stocks_laboratory.IndianNews.model.*;
import com.stocks_laboratory.IndianNews.model.ResponseRootResponseROOTEntryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface IndianNewsService {

  /**
   * 
   * 
    * @param x_RapidAPI_Key X-RapidAPI-Key (optional)
    * @param x_RapidAPI_Host X-RapidAPI-Host (optional)
   * @return List&lt;ResponseRootResponseROOTEntryItem&gt;
   */
  @RequestLine("GET /marketNews")
  @Headers({
    "Accept: application/json",
    "X-RapidAPI-Key: {x_RapidAPI_Key}",

    "X-RapidAPI-Host: {x_RapidAPI_Host}"  })
  List<ResponseRootResponseROOTEntryItem> invoke(@Param("x_RapidAPI_Key") String x_RapidAPI_Key, @Param("x_RapidAPI_Host") String x_RapidAPI_Host);

}
