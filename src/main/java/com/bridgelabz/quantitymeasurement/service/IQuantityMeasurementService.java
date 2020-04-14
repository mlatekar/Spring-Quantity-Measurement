package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.enumTypes.quantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.unitType;

import java.util.List;

public interface IQuantityMeasurementService {
    List<quantityTypes> getAllQuantityUnits();
    List<unitType> getAllUnits();
    List<unitType> getAllUnitType(quantityTypes types);
}
