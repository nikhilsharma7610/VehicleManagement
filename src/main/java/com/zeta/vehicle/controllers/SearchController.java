package com.zeta.vehicle.controllers;

import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.service.impl.SearchService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author nikhil sharma created on 09/12/20
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService = new SearchService();

    @GetMapping(path = "/location", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceCenter>> searchByLocation(@RequestParam String location) {

        List<ServiceCenter> serviceCenters = null;
        try {
            serviceCenters = searchService.searchByLocation(location);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(serviceCenters, HttpStatus.OK);
    }

    @GetMapping(path = "/slot", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceCenter>> searchByLocation(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                                @RequestParam Integer from,
                                                                @RequestParam Integer to) {

        List<ServiceCenter> serviceCenters = null;
        try {
            serviceCenters = searchService.searchBySlotsInDay(date, from, to);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(serviceCenters, HttpStatus.OK);
    }

}
