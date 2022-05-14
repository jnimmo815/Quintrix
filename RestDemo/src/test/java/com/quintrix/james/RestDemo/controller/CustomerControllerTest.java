package com.quintrix.james.restdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.quintrix.james.restdemo.models.customer.Customer;
import com.quintrix.james.restdemo.restservice.CustomerService;


public class CustomerControllerTest {

  @Test
  void MockCustomerControllerMvcMocTest() throws Exception {

    CustomerController customerController = new CustomerController();
    CustomerService carServiceMock = Mockito.mock(CustomerService.class);

    Customer customer = new Customer();

    customer.setId(14L);
    customer.setName("James");
    customer.setPhone("919-480-5555");
    customer.setAge(27);
    customer.setActive(true);
    customer.setState("NC");


    customerController.setCustomerService(carServiceMock);
    Mockito.when(carServiceMock.getCustomerById(14L)).thenReturn(customer);

    MockMvc mockMvc = standaloneSetup(customerController).build();

    mockMvc.perform(get("/customers/{id}", 14).param("name", "James"))
        .andExpect(MockMvcResultMatchers.status().isOk());;
  }
}
