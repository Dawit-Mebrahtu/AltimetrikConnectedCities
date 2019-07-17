package com.altimetrik.connectedcities.connectedcities.controller;

import com.altimetrik.connectedcities.connectedcities.ConnectedcitiesApplication;
import com.altimetrik.connectedcities.connectedcities.service.CitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value="Connected cities resource", description = "Determines if two cities are connected or not")
public class CitiesController {

    @Autowired
    CitiesService citiesService;

    @ApiOperation(value="Returns true if two cities are connected otherwise returns false", produces = "application/json")
    @GetMapping(value="/connected", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean connected(@RequestParam("origin") String origin, @RequestParam("destination") String destination ){

        return citiesService.isConnected(origin, destination);
    }

}
