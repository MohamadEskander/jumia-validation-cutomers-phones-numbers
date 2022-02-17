package com.example.jumiatask.controller;

import com.example.jumiatask.entity.Customer;
import com.example.jumiatask.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @MockBean
    CustomerService customerService;
    @Autowired
    MockMvc mockMvc;
    List<Customer> customers = new ArrayList<>();

    @BeforeEach
    public void setup(){
        customers.add(new Customer(1,"Mohamed Eskander","(212) 698054317", "valid", "Morocco"));
        customers.add(new Customer(2,"mohamed ahmed","(212) 6546545369", "valid", "Morocco"));
    }

    @Test
    void getCustomers_itShouldReturnStatusOK() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(customers);
        mockMvc.perform( get("/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void GetFilteredCustomers_itShouldReturnFilteredCustomersOnly() throws Exception {
        String moroccoCountry = "Morocco";
        String validState = "valid";
        when(customerService.getFilteredCustomers(moroccoCountry, validState)).thenReturn(customers);
        mockMvc.perform( get("/customers/filter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("country" , moroccoCountry)
                        .param("state" , validState))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].country" , is(moroccoCountry)))
                .andExpect(jsonPath("$[0].state" , is(validState)));
    }
}