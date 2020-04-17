package com.bridgelabz.quantitymeasurement.mockitoMVCTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.bridgelabz.quantitymeasurement.controllers.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes;
import com.bridgelabz.quantitymeasurement.enumTypes.UnitType;
import com.bridgelabz.quantitymeasurement.service.implimentation.QuantityMeasurementService;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static com.bridgelabz.quantitymeasurement.enumTypes.QuantityTypes.*;
import static com.bridgelabz.quantitymeasurement.enumTypes.UnitType.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(Enclosed.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementControllerTest {

    Gson gsonObject;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void given_AllQuantityUnits_Tested() {
        try {
            List<QuantityTypes> quantityTypesList = Arrays.asList(WEIGHT, VOLUME, LENGTH, TEMP);

            given(quantityMeasurementService.getAllQuantityUnits()).willReturn(quantityTypesList);
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/unit/getAllQuantityTypes"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{ 'value': [ 'WEIGHT','VOLUME','LENGTH','TEMP'],'message': 'Successful','statusCode': 200 }"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void given_AllSubTypes_Tested() {
        try {
            String types = "TEMP";
            List<UnitType> list = Arrays.asList(FAHRENHEIT_TO_CELSIUS, CELSIUS_TO_FAHRENHEIT);

            given(quantityMeasurementService.getAllUnitType(QuantityTypes.TEMP)).willReturn(list);
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/units").param("types", types))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{ 'value': [ 'FAHRENHEIT_TO_CELSIUS','CELSIUS_TO_FAHRENHEIT'],'message': 'Successful','statusCode': 200 }"));

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Test
    public void givenUniteType_ShouldConvertedInto_ExpectedOutput() {
        try {
            UnitDTO unitDTO = new UnitDTO();
            unitDTO.setInitialValue(1);
            unitDTO.setConversion(UnitType.INCH_TO_CM);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String jsonContent = ow.writeValueAsString(unitDTO);

            double ExpectedOutputValue = 2.5;
            when(quantityMeasurementService.convertUnit(any())).thenReturn(ExpectedOutputValue);
            mockMvc.perform(MockMvcRequestBuilders.post("/unit/convertUnits")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonContent))
                    .andExpect(content().json("{'value': 2.5,'message': 'Successful','statusCode': 200}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
