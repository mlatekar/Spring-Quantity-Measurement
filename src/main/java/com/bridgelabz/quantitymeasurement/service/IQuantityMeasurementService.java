package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.UnitType;

import java.util.List;

public interface IQuantityMeasurementService {
    List<QuantityTypes> getAllQuantityUnits();

    List<UnitType> getAllUnitType(QuantityTypes types);

    double convertUnit(UnitDTO unitDTO) throws Exception;
}
