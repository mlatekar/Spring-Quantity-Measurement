package com.bridgelabz.quantitymeasurement.controllers;

import com.bridgelabz.quantitymeasurement.dto.unitDTO;
import com.bridgelabz.quantitymeasurement.enumTypes.quantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.unitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class QuantityMeasurementController {
    QuantityMeasurementController quantityMeasurement = null;

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("hello")
    public String hello()
    {
        return "Hello, Welcome To Quantity Measurement";
    }

    @GetMapping("/unit/getAllQuantityTypes")
    public List<quantityTypes> getAllQuantityTypes() {
        List<quantityTypes> allQuantityUnits = Arrays.asList(quantityMeasurementService.getAllQuantityUnits());
        return allQuantityUnits ;
    }
}
