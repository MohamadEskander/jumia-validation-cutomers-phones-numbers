package com.example.jumiatask.rest.controller;

import com.example.jumiatask.entity.Customer;
import com.example.jumiatask.rest.exceptionHandler.NoDataFoundException;
import com.example.jumiatask.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        if(customers == null || customers.isEmpty())
            throw new NoDataFoundException("No Customer Found.");
        return new ResponseEntity( customers , HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Customer>> getFilteredCustomers(
            @RequestParam(value = "country", required = false, defaultValue = "") String country
            ,@RequestParam(value = "state", required = false, defaultValue = "")  String state){
        List<Customer> filteredCustomers = customerService.getFilteredCustomers(country , state);
        return new ResponseEntity(filteredCustomers, HttpStatus.OK);
    }
}
