package com.bridgelabz.quantitymeasurement.service.implimentation;

import com.bridgelabz.quantitymeasurement.enumTypes.quantityTypes;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public quantityTypes[] getAllQuantityUnits() {
        return quantityTypes.values();
    }
}
