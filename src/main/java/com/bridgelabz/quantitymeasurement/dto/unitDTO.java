package com.bridgelabz.quantitymeasurement.dto;

public class unitDTO {

    public double initialValue;
    public String initialUnit;
    public String outputUnit;

    public String getInitialUnit() {
        return initialUnit;
    }

    public void setInitialUnit(String initialUnit) {
        this.initialUnit = initialUnit;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public String getOutputUnit() {
        return outputUnit;
    }

    public void setOutputUnit(String outputUnit) {
        this.outputUnit = outputUnit;
    }
}
