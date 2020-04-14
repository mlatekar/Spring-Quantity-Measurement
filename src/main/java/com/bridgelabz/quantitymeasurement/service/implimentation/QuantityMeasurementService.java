package com.bridgelabz.quantitymeasurement.service.implimentation;

import com.bridgelabz.quantitymeasurement.enumTypes.quantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.unitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public List<quantityTypes> getAllQuantityUnits() {
        /*List<quantityTypes> quantityTypesValues =*/
         return Arrays.asList(quantityTypes.values());
       // return quantityTypesValues;
    }

    public List<unitType> getAllUnits() {
         return Arrays.asList(unitType.values());
        // return unitTypesValues;
    }

    @Override
    public List<unitType> getAllUnitType(quantityTypes types) {
        return Arrays.stream(unitType.values())
               .filter(units -> units.subtypes.equals(types))
                .collect(Collectors.toList());
/*
        return allUniteType;
*/

    }

}

