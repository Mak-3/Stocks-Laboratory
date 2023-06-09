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

import com.stocks_laboratory.stocks_laboratory.IndianStockPortfolio;
import com.stocks_laboratory.stocks_laboratory.service.IndianStockPortfolioService;


/**
 * Controller object for domain model class IndianStockPortfolio.
 * @see IndianStockPortfolio
 */
@RestController("stocks_laboratory.IndianStockPortfolioController")
@Api(value = "IndianStockPortfolioController", description = "Exposes APIs to work with IndianStockPortfolio resource.")
@RequestMapping("/stocks_laboratory/IndianStockPortfolio")
public class IndianStockPortfolioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndianStockPortfolioController.class);

    @Autowired
	@Qualifier("stocks_laboratory.IndianStockPortfolioService")
	private IndianStockPortfolioService indianStockPortfolioService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new IndianStockPortfolio instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IndianStockPortfolio createIndianStockPortfolio(@RequestBody IndianStockPortfolio indianStockPortfolio) {
		LOGGER.debug("Create IndianStockPortfolio with information: {}" , indianStockPortfolio);

		indianStockPortfolio = indianStockPortfolioService.create(indianStockPortfolio);
		LOGGER.debug("Created IndianStockPortfolio with information: {}" , indianStockPortfolio);

	    return indianStockPortfolio;
	}

    @ApiOperation(value = "Returns the IndianStockPortfolio instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IndianStockPortfolio getIndianStockPortfolio(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting IndianStockPortfolio with id: {}" , id);

        IndianStockPortfolio foundIndianStockPortfolio = indianStockPortfolioService.getById(id);
        LOGGER.debug("IndianStockPortfolio details with id: {}" , foundIndianStockPortfolio);

        return foundIndianStockPortfolio;
    }

    @ApiOperation(value = "Updates the IndianStockPortfolio instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IndianStockPortfolio editIndianStockPortfolio(@PathVariable("id") Integer id, @RequestBody IndianStockPortfolio indianStockPortfolio) {
        LOGGER.debug("Editing IndianStockPortfolio with id: {}" , indianStockPortfolio.getId());

        indianStockPortfolio.setId(id);
        indianStockPortfolio = indianStockPortfolioService.update(indianStockPortfolio);
        LOGGER.debug("IndianStockPortfolio details with id: {}" , indianStockPortfolio);

        return indianStockPortfolio;
    }
    
    @ApiOperation(value = "Partially updates the IndianStockPortfolio instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IndianStockPortfolio patchIndianStockPortfolio(@PathVariable("id") Integer id, @RequestBody @MapTo(IndianStockPortfolio.class) Map<String, Object> indianStockPortfolioPatch) {
        LOGGER.debug("Partially updating IndianStockPortfolio with id: {}" , id);

        IndianStockPortfolio indianStockPortfolio = indianStockPortfolioService.partialUpdate(id, indianStockPortfolioPatch);
        LOGGER.debug("IndianStockPortfolio details after partial update: {}" , indianStockPortfolio);

        return indianStockPortfolio;
    }

    @ApiOperation(value = "Deletes the IndianStockPortfolio instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteIndianStockPortfolio(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting IndianStockPortfolio with id: {}" , id);

        IndianStockPortfolio deletedIndianStockPortfolio = indianStockPortfolioService.delete(id);

        return deletedIndianStockPortfolio != null;
    }

    @GetMapping(value = "/userId-stockSymbol" )
    @ApiOperation(value = "Returns the matching IndianStockPortfolio with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public IndianStockPortfolio getByUserIdAndStockSymbol(@RequestParam("userId") int userId, @RequestParam("stockSymbol") String stockSymbol) {
        LOGGER.debug("Getting IndianStockPortfolio with uniques key UserIdAndStockSymbol");
        return indianStockPortfolioService.getByUserIdAndStockSymbol(userId, stockSymbol);
    }

    /**
     * @deprecated Use {@link #findIndianStockPortfolios(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of IndianStockPortfolio instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IndianStockPortfolio> searchIndianStockPortfoliosByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering IndianStockPortfolios list by query filter:{}", (Object) queryFilters);
        return indianStockPortfolioService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of IndianStockPortfolio instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IndianStockPortfolio> findIndianStockPortfolios(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering IndianStockPortfolios list by filter:", query);
        return indianStockPortfolioService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of IndianStockPortfolio instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<IndianStockPortfolio> filterIndianStockPortfolios(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering IndianStockPortfolios list by filter", query);
        return indianStockPortfolioService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportIndianStockPortfolios(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return indianStockPortfolioService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportIndianStockPortfoliosAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = IndianStockPortfolio.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> indianStockPortfolioService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of IndianStockPortfolio instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countIndianStockPortfolios( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting IndianStockPortfolios");
		return indianStockPortfolioService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getIndianStockPortfolioAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return indianStockPortfolioService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IndianStockPortfolioService instance
	 */
	protected void setIndianStockPortfolioService(IndianStockPortfolioService service) {
		this.indianStockPortfolioService = service;
	}

}