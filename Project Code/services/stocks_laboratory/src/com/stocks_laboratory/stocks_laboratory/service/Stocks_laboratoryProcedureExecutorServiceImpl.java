/*Copyright (c) 2023-2024 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.stocks_laboratory.stocks_laboratory.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

@Service
public class Stocks_laboratoryProcedureExecutorServiceImpl implements Stocks_laboratoryProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Stocks_laboratoryProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("stocks_laboratoryWMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;


}