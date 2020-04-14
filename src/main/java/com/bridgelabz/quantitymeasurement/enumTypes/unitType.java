package com.bridgelabz.quantitymeasurement.enumTypes;

public enum unitType {

    FEET(1 * 12.0,quantityTypes.LENGTH), INCHES(1 / 12.0,quantityTypes.LENGTH),
    FEET_TO_YARD(1 / 3.0,quantityTypes.LENGTH), INCH_TO_YARD(1/36.0,quantityTypes.LENGTH),
    YARD_TO_INCH(1 * 36.0,quantityTypes.LENGTH), YARD_TO_FEET(1*3.0,quantityTypes.LENGTH),
    Inch_To_CENTIMETER(1* 2.5,quantityTypes.LENGTH), INCH(1*1.0,quantityTypes.LENGTH),
    CENTIMETER_TO_INCH(1/2.5,quantityTypes.LENGTH),

    GALLON_TO_LITERS(1*3.78,quantityTypes.VOLUME), MILLILITER_TO_LITER(1 / 1000.0,quantityTypes.VOLUME),
    LITER_TO_MILLILITER(1*1000.0,quantityTypes.VOLUME), LITER(1*1.0,quantityTypes.VOLUME),

    KG_TO_GRAM(1*1000,quantityTypes.WEIGHT), TONS_TO_KG(1*1000,quantityTypes.WEIGHT),
    GRAMS_TO_KG(1/1000.0,quantityTypes.WEIGHT),

    FARENHEIT_TO_CELSIUS(100.0/212.0,quantityTypes.TEMP);


    public double convertValues;
    public quantityTypes subtypes;

    unitType(double convertValues,quantityTypes subtypes) {
        this.convertValues = convertValues;
        this.subtypes=subtypes;
    }

}
