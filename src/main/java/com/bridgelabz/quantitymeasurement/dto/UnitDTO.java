package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.UnitType;

public class UnitDTO {

    public double initialValue;
    public double outputValue;
    public UnitType conversion;
    public QuantityTypes subtypes;

    public UnitType getConversion() {
        return conversion;
    }

    public void setConversion(UnitType conversion) {
        this.conversion = conversion;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    public QuantityTypes getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(QuantityTypes subtypes) {
        this.subtypes = subtypes;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }
}
