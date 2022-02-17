package com.example.jumiatask.service;

import com.example.jumiatask.entity.Customer;
import com.example.jumiatask.filter.Filter;
import com.example.jumiatask.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PhoneNumberCategorizationService  categorizationService;
    @Autowired
    @Qualifier(value = "StateFilter")
    Filter stateFilter;
    @Autowired
    @Qualifier(value = "CountryFilter")
    Filter countryFilter;

    public List<Customer> getAllCustomers(){
        List<Customer> customers =  customerRepository.findAll();
        categorizationService.categorize(customers);
        return customers;
    }
    public List<Customer> getFilteredCustomers(String country , String state){
        List<Customer> customers =  getAllCustomers();
        List<Customer> filteredCustomers = countryFilter.filter(
                stateFilter.filter(customers , state),country
        );
        return filteredCustomers;
    }

}
