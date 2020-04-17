package com.bridgelabz.quantitymeasurement.controllers;

import com.bridgelabz.quantitymeasurement.dto.ResponseDTO;
import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    QuantityMeasurementController quantityMeasurement = null;

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("hello")
    public String hello() {
        return "Hello, Welcome To Quantity Measurement";
    }

    @GetMapping("/unit/getAllQuantityTypes")
    public ResponseEntity<ResponseDTO> getAllQuantityTypes() {
        List<QuantityTypes> quantityTypesList = quantityMeasurementService.getAllQuantityUnits();
        ResponseDTO responseDTO = new ResponseDTO(quantityTypesList, "Successful", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/units")
    public ResponseEntity<ResponseDTO> getAllSubUnitTypes(@RequestParam(value = "types") QuantityTypes types) {
        List<UnitType> unitTypesList = quantityMeasurementService.getAllUnitType(types);
        ResponseDTO responseDTO = new ResponseDTO(unitTypesList, "Successful", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/unit/convertUnits")
    public ResponseEntity<ResponseDTO> convertUintValue(@RequestBody UnitDTO unitDTO) throws Exception {
        Double convertedValue = quantityMeasurementService.convertUnit(unitDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, "Successful", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
