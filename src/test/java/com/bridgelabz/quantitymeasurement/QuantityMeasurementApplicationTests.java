package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.UnitType;
import com.bridgelabz.quantitymeasurement.service.implimentation.QuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Assert;
import org.junit.Before;

import java.util.List;

@SpringBootTest
class QuantityMeasurementApplicationTests {

    QuantityMeasurementService quantityMeasurementService;

    @Before
    public void setup() {
        quantityMeasurementService = new QuantityMeasurementService();
    }

    @Test
    void givenQuantityMeasurementService_ReturnTotalQuantityUnits() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<QuantityTypes> totalQuantityUnits = quantityMeasurementService.getAllQuantityUnits();
        Assert.assertEquals(4, totalQuantityUnits.size());
    }

    @Test
    void givenQuantityMeasurement_ShouldReturnAllSubUnits() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<UnitType> totalUnitType = quantityMeasurementService.getAllUnitType(QuantityTypes.LENGTH);
        Assert.assertEquals(9, totalUnitType.size());
    }
}
