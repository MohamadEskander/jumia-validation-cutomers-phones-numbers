package com.example.jumiatask.filter;

import com.example.jumiatask.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component("StateFilter")
public class StateFilter implements Filter<Customer>{

    @Override
    public List<Customer> filter(List<Customer> customers , String state) {
        if (customers == null)
            throw new NullPointerException();

        else if (!state.isEmpty())
            return customers.stream()
                .filter(customer -> customer.getState().equals(state))
                .collect(Collectors.toList());
        return customers;
    }
}
