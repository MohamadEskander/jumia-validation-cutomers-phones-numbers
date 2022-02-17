package com.example.jumiatask.service;

import com.example.jumiatask.entity.Customer;
import com.example.jumiatask.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {
    @MockBean
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;
    List<Customer> customers = new ArrayList<>();

    @BeforeEach
    public void setup(){
        customers.add(new Customer(1,"Mohamed Eskander","(212) 698054317"));
        customers.add(new Customer(2,"ahmed Eskander","(213) 6546545369"));
        customers.add(new Customer(2,"mohamed ahmed","(212) 6546545369000"));
    }

    @Test
    public void GetAllCustomers_itShouldReturnAllCustomers() {
        when(customerRepository.findAll()).thenReturn(customers);

        assertThat(customerService.getAllCustomers().size()).isEqualTo(3);
    }

    @Test
    public void GetFilteredCustomers_itShouldReturnValidMoroccoCustomersOnly() {
        when(customerRepository.findAll()).thenReturn(customers);

        assertThat(customerService.getFilteredCustomers("Morocco" , "valid").size()).isEqualTo(1);
    }

}