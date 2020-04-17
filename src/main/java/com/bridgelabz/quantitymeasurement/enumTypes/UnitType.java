package com.bridgelabz.quantitymeasurement.enumTypes;

public enum UnitType {

    FEET(1 * 12.0, QuantityTypes.LENGTH), INCHES(1 / 12.0, QuantityTypes.LENGTH), YARD(1 * 36.0, QuantityTypes.LENGTH),
    FEET_TO_YARD(1 / 3.0, QuantityTypes.LENGTH), INCH_TO_YARD(1 / 36.0, QuantityTypes.LENGTH),
    YARD_TO_INCH(1 * 36.0, QuantityTypes.LENGTH), YARD_TO_FEET(1 * 3.0, QuantityTypes.LENGTH),
    INCH_TO_CM(1 * 2.5, QuantityTypes.LENGTH), INCH(1 * 1.0, QuantityTypes.LENGTH), CM_TO_INCH(1 / 2.5, QuantityTypes.LENGTH),

    GALLON(1 * 3.785, QuantityTypes.VOLUME), LITER(1.0, QuantityTypes.VOLUME), MILLILITRE(1.0 / 1000.0, QuantityTypes.VOLUME),
    GALLON_TO_LITERS(1 * 3.78, QuantityTypes.VOLUME), MILLILITER_TO_LITER(1 / 1000.0, QuantityTypes.VOLUME),
    LITER_TO_MILLILITER(1 * 1000.0, QuantityTypes.VOLUME),

    KILOGRAM(1.0, QuantityTypes.WEIGHT), GRAM(1 / 1000.0, QuantityTypes.WEIGHT), TONNE(1 * 1000.0, QuantityTypes.WEIGHT),
    KG_TO_GRAM(1 * 1000, QuantityTypes.WEIGHT), TONS_TO_KG(1 * 1000, QuantityTypes.WEIGHT), GRAMS_TO_KG(1 / 1000.0, QuantityTypes.WEIGHT),

    //FAHRENHEIT(0.56, QuantityTypes.TEMP), CELSIUS((1.8/9.0), QuantityTypes.TEMP);
    FAHRENHEIT_TO_CELSIUS(0.56, QuantityTypes.TEMP), CELSIUS_TO_FAHRENHEIT(1.8, QuantityTypes.TEMP);

    public double convertValues;

    public QuantityTypes subtypes;

    UnitType(double convertValues, QuantityTypes subtypes) {
        this.convertValues = convertValues;
        this.subtypes = subtypes;
    }

}
