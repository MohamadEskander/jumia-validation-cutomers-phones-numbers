package com.example.jumiatask.service;

import com.example.jumiatask.entity.Customer;
import com.example.jumiatask.model.Country;
import com.example.jumiatask.util.RegExpression;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhoneNumberCategorizationService {
    private Map<String , Country> countries = new Country().getCountries();

    public void categorize( List<Customer> customers) {
        for(Customer customer  : customers){
            String code = getCodeFromCustomerPhoneNumber(customer.getPhone());
            customer.setState("not valid");
            if(countries.containsKey(code)){
                customer.setCountry(countries.get(code).getName());
                if(RegExpression.validate(countries.get(code).getRegex() , customer.getPhone()))
                    customer.setState("valid");
            }
        }
    }

    private String getCodeFromCustomerPhoneNumber(String customerPhone){
        return customerPhone.split(" ")[0];
    }
}
