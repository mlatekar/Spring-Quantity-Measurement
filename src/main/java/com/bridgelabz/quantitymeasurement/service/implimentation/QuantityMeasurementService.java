package com.bridgelabz.quantitymeasurement.service.implimentation;

import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public List<QuantityTypes> getAllQuantityUnits() {
        return Arrays.asList(QuantityTypes.values());
    }

    @Override
    public List<UnitType> getAllUnitType(QuantityTypes types) {
        return Arrays.stream(UnitType.values())
                .filter(units -> units.subtypes.equals(types))
                .collect(Collectors.toList());
    }

    @Override
    public double convertUnit(UnitDTO unitDTO) {
        if (unitDTO.getConversion().equals(UnitType.FAHRENHEIT_TO_CELSIUS)) {
            double convertedValue = unitDTO.conversion.convertValues * (unitDTO.initialValue - 32.0);
            unitDTO.setOutputValue(convertedValue);
            return convertedValue;
        }
        if (unitDTO.getConversion().equals(UnitType.CELSIUS_TO_FAHRENHEIT)) {
            double convertedValue = (unitDTO.initialValue * unitDTO.conversion.convertValues) + 32.0;
            unitDTO.setOutputValue(convertedValue);
            return convertedValue;
        } else {
            double convertedValue = unitDTO.initialValue * unitDTO.conversion.convertValues;
            unitDTO.setOutputValue(convertedValue);
            return convertedValue;
        }
    }
}

