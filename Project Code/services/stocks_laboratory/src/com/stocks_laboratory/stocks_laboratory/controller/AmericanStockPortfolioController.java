/*Copyright (c) 2023-2024 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.stocks_laboratory.stocks_laboratory.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.commons.file.manager.ExportedFileManager;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.stocks_laboratory.stocks_laboratory.AmericanStockPortfolio;
import com.stocks_laboratory.stocks_laboratory.service.AmericanStockPortfolioService;


/**
 * Controller object for domain model class AmericanStockPortfolio.
 * @see AmericanStockPortfolio
 */
@RestController("stocks_laboratory.AmericanStockPortfolioController")
@Api(value = "AmericanStockPortfolioController", description = "Exposes APIs to work with AmericanStockPortfolio resource.")
@RequestMapping("/stocks_laboratory/AmericanStockPortfolio")
public class AmericanStockPortfolioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmericanStockPortfolioController.class);

    @Autowired
	@Qualifier("stocks_laboratory.AmericanStockPortfolioService")
	private AmericanStockPortfolioService americanStockPortfolioService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new AmericanStockPortfolio instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AmericanStockPortfolio createAmericanStockPortfolio(@RequestBody AmericanStockPortfolio americanStockPortfolio) {
		LOGGER.debug("Create AmericanStockPortfolio with information: {}" , americanStockPortfolio);

		americanStockPortfolio = americanStockPortfolioService.create(americanStockPortfolio);
		LOGGER.debug("Created AmericanStockPortfolio with information: {}" , americanStockPortfolio);

	    return americanStockPortfolio;
	}

    @ApiOperation(value = "Returns the AmericanStockPortfolio instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AmericanStockPortfolio getAmericanStockPortfolio(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting AmericanStockPortfolio with id: {}" , id);

        AmericanStockPortfolio foundAmericanStockPortfolio = americanStockPortfolioService.getById(id);
        LOGGER.debug("AmericanStockPortfolio details with id: {}" , foundAmericanStockPortfolio);

        return foundAmericanStockPortfolio;
    }

    @ApiOperation(value = "Updates the AmericanStockPortfolio instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AmericanStockPortfolio editAmericanStockPortfolio(@PathVariable("id") Integer id, @RequestBody AmericanStockPortfolio americanStockPortfolio) {
        LOGGER.debug("Editing AmericanStockPortfolio with id: {}" , americanStockPortfolio.getId());

        americanStockPortfolio.setId(id);
        americanStockPortfolio = americanStockPortfolioService.update(americanStockPortfolio);
        LOGGER.debug("AmericanStockPortfolio details with id: {}" , americanStockPortfolio);

        return americanStockPortfolio;
    }
    
    @ApiOperation(value = "Partially updates the AmericanStockPortfolio instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AmericanStockPortfolio patchAmericanStockPortfolio(@PathVariable("id") Integer id, @RequestBody @MapTo(AmericanStockPortfolio.class) Map<String, Object> americanStockPortfolioPatch) {
        LOGGER.debug("Partially updating AmericanStockPortfolio with id: {}" , id);

        AmericanStockPortfolio americanStockPortfolio = americanStockPortfolioService.partialUpdate(id, americanStockPortfolioPatch);
        LOGGER.debug("AmericanStockPortfolio details after partial update: {}" , americanStockPortfolio);

        return americanStockPortfolio;
    }

    @ApiOperation(value = "Deletes the AmericanStockPortfolio instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAmericanStockPortfolio(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting AmericanStockPortfolio with id: {}" , id);

        AmericanStockPortfolio deletedAmericanStockPortfolio = americanStockPortfolioService.delete(id);

        return deletedAmericanStockPortfolio != null;
    }

    @GetMapping(value = "/userId-stockSymbol" )
    @ApiOperation(value = "Returns the matching AmericanStockPortfolio with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AmericanStockPortfolio getByUserIdAndStockSymbol(@RequestParam("userId") int userId, @RequestParam("stockSymbol") String stockSymbol) {
        LOGGER.debug("Getting AmericanStockPortfolio with uniques key UserIdAndStockSymbol");
        return americanStockPortfolioService.getByUserIdAndStockSymbol(userId, stockSymbol);
    }

    /**
     * @deprecated Use {@link #findAmericanStockPortfolios(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AmericanStockPortfolio instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AmericanStockPortfolio> searchAmericanStockPortfoliosByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AmericanStockPortfolios list by query filter:{}", (Object) queryFilters);
        return americanStockPortfolioService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AmericanStockPortfolio instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AmericanStockPortfolio> findAmericanStockPortfolios(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AmericanStockPortfolios list by filter:", query);
        return americanStockPortfolioService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AmericanStockPortfolio instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AmericanStockPortfolio> filterAmericanStockPortfolios(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AmericanStockPortfolios list by filter", query);
        return americanStockPortfolioService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAmericanStockPortfolios(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return americanStockPortfolioService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportAmericanStockPortfoliosAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = AmericanStockPortfolio.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> americanStockPortfolioService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of AmericanStockPortfolio instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAmericanStockPortfolios( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AmericanStockPortfolios");
		return americanStockPortfolioService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAmericanStockPortfolioAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return americanStockPortfolioService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AmericanStockPortfolioService instance
	 */
	protected void setAmericanStockPortfolioService(AmericanStockPortfolioService service) {
		this.americanStockPortfolioService = service;
	}

}