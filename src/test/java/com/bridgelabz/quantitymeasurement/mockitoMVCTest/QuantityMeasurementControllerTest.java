package com.bridgelabz.quantitymeasurement.mockitoMVCTest;

import com.bridgelabz.quantitymeasurement.controllers.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.enumTypes.quantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.unitType;
import com.bridgelabz.quantitymeasurement.service.implimentation.QuantityMeasurementService;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static com.bridgelabz.quantitymeasurement.enumTypes.quantityTypes.*;
import static com.bridgelabz.quantitymeasurement.enumTypes.unitType.*;
import static javax.swing.UIManager.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(Enclosed.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void given_AllQuantityUnits_Tested() {
        try {List<quantityTypes> quantityTypesList = Arrays.asList(WEIGHT, VOLUME, LENGTH, TEMP);
        given(quantityMeasurementService.getAllQuantityUnits()).willReturn(quantityTypesList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/unit/getAllQuantityTypes"))
                .andExpect(content().json(quantityTypesList.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @Test
    public void given_AllUnitTypes_Tested() throws Exception{
        List<unitType> quantityTypesList = Arrays.asList(FEET,INCH,LITER );
       given(quantityMeasurementService.getAllUnits()).willReturn(quantityTypesList);
       mockMvc.perform(MockMvcRequestBuilders
               .get("/unit/getAllUnitTypes"))
               .andExpect(content().json(quantityTypesList.toString()));
    }

    @Test
    public void testingGetAllSubQuantitiesMethod1()throws Exception {
        String types="LENGTH";
        List<unitType> list = Arrays.asList(FEET,INCH,LITER);
        given(quantityMeasurementService.getAllUnitType(LENGTH)).willReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/units").param("types",types))
                .andExpect(content().json(list.toString()));

    }
}
