package com.example.jumiatask.filter;

import com.example.jumiatask.entity.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component("CountryFilter")
@Primary
public class CountryFilter implements Filter<Customer>{

    @Override
    public List<Customer> filter(List<Customer> customers , String country) {
        if (customers == null)
            throw new NullPointerException();
        else if (!country.isEmpty())
            return customers.stream()
                .filter(customer -> customer.getCountry().equals(country))
                .collect(Collectors.toList());
        return customers;
    }
}
