package com.bridgelabz.quantitymeasurement.enumTypes;

public enum unitType {

    FEET(1 * 12.0), INCHES(1 / 12.0), FEET_TO_YARD(1 / 3.0), INCH_TO_YARD(1/36.0), YARD_TO_INCH(1 * 36.0), YARD_TO_FEET(1*3.0), Inch_To_CENTIMETER(1* 2.5),
    INCH(1*1.0),CENTIMETER_TO_INCH(1/2.5),GALLON_TO_LITERS(1*3.78), MILLILITER_TO_LITER(1 / 1000.0), LITER_TO_MILLILITER(1*1000.0),
    LITER(1*1.0), KG_TO_GRAM(1*1000), TONS_TO_KG(1*1000), GRAMS_TO_KG(1/1000.0), FARENHEIT_TO_CELSIUS(100.0/212.0);

    public double unitType;

    unitType(double unitType) {
        this.unitType = unitType;
    }
}
