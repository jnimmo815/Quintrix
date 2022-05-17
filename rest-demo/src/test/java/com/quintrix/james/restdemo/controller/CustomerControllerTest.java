package com.quintrix.james.restdemo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.quintrix.james.restdemo.models.customer.ClientCustomer;
import com.quintrix.james.restdemo.models.customer.GetCustomerResponse;
import com.quintrix.james.restdemo.restservice.CustomerService;


public class CustomerControllerTest {

  @Test
  void MockCustomerControllerMvcMocTest() throws Exception {

    CustomerController customerController = new CustomerController();
    CustomerService customerServiceMock = Mockito.mock(CustomerService.class);

    GetCustomerResponse getCustomerResponse = new GetCustomerResponse();

    List<ClientCustomer> customersList = new ArrayList<>();
    ClientCustomer customer = new ClientCustomer();

    customer.setName("James");
    customer.setPhone("919-480-5555");
    customer.setAge(27);
    customer.setActive(true);
    customer.setState("MD");
    customersList.add(customer);
    getCustomerResponse.setAvailableCustomersList(customersList);


    customerController.setCustomerService(customerServiceMock);
    Mockito.when(customerServiceMock.getCostomers("James")).thenReturn(getCustomerResponse);

    MockMvc mockMvc = standaloneSetup(customerController).build();

    mockMvc.perform(get("/customers/").param("name", "James"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$.availableCustomersList", notNullValue()))
        .andExpect(jsonPath("$.availableCustomersList", hasSize(1))) // Passes up to this line
        .andExpect(jsonPath("$..availableCustomersList[0].age", is(27)));

  }
}
